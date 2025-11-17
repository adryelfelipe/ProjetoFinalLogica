package Infraestrutura.Persistencia.Implementacao.Funcionario.JDBC;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Infraestrutura.Configuracao.ConnectionFactory;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Tecnico.Tecnico;
import Infraestrutura.Persistencia.Implementacao.Funcionario.Mapper.FuncionarioJdbcMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorioJdbc implements FuncionarioRepositorio
{
    FuncionarioJdbcMapper mapper;

    public FuncionarioRepositorioJdbc(FuncionarioJdbcMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean existeCpf(CPF cpf)
    {
        // Consulta MYSQL.
        String querySql = "SELECT * FROM Usuario WHERE cpf = ? LIMIT 1";

        // Pega a conexão
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySql))
        {
            stmt.setString(1, cpf.getCpf());

            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao verificar CPF: ");
        }
        return false;
    }

        @Override
        public void salvar(Funcionario funcionario)
        {
            // Comando SQL
            String querySQL = "INSERT INTO Usuario (nome, cpf, senha, id_na) VALUES (?, ?, ?, ?)";
            long idGerado = -1; // Armazena o id.

            // Pega a conexão
            try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS))
            {
                //Definindo parametros (PreparedStatement).
                stmt.setString(1, funcionario.getNome().getNome());
                stmt.setString(2, funcionario.getCpf().getCpf());
                stmt.setString(3, funcionario.getSenha().getSenha());
                stmt.setInt(4, funcionario.getNivelAcesso().getId());

                //Executando a inserção
                int linhasAF = stmt.executeUpdate();

                // Verificando se o comando ocorreu
                if (linhasAF > 0)
                {
                    // Pega as chaves geradas.
                    try (ResultSet rs = stmt.getGeneratedKeys())
                    {
                        if (rs.next()) {
                            idGerado = rs.getLong(1);// Pega a chave (geralmente pela primeira coluna)
                            funcionario.alteraIdFuncionario(idGerado);

                            if(funcionario.getNivelAcesso().equals(NivelAcesso.GERENTE))
                            {
                                Gerente gerente = (Gerente) funcionario;
                                String querySQLG = "INSERT INTO Gerentes (id_gerente, id_departamento) VALUES (?, ?)";

                                try(PreparedStatement stmtGerente = conn.prepareStatement(querySQLG))
                                {
                                    stmtGerente.setLong(1, gerente.getId());
                                    stmtGerente.setInt(2, gerente.getDepartamentos().getListaDepartamentos().getFirst().getId());
                                    stmtGerente.executeUpdate();
                                }
                            }
                        }
                        if(funcionario.getNivelAcesso().equals(NivelAcesso.SUPERVISOR))
                        {
                            Supervisor supervisor = (Supervisor) funcionario;
                            String querySupervisor = "INSERT INTO Supervisor (id_supervisor, meta_mensal) VALUES (?, ?)";

                            try(PreparedStatement stmtSupervisor = conn.prepareStatement(querySupervisor))
                            {
                                stmtSupervisor.setLong(1, supervisor.getId());
                                stmtSupervisor.setDouble(2, supervisor.getMetaMensal().getValorMetaMensal());
                                stmtSupervisor.executeUpdate();
                            }
                        }
                        if (funcionario.getNivelAcesso().equals(NivelAcesso.TECNICO)) {
                            Tecnico tecnico = (Tecnico) funcionario;
                            String queryTecnico = "INSERT INTO Tecnico (id_tecnico, id_especialidade) VALUES (?, ?)";

                            try (PreparedStatement stmtTecnico = conn.prepareStatement(queryTecnico)) {
                                stmtTecnico.setLong(1, tecnico.getId());
                                stmtTecnico.setInt(2, tecnico.getEspecialidade().getId());
                                stmtTecnico.executeUpdate();
                            }
                        }
                    }
                }
            }
            catch (SQLException e)
            {
                System.err.println("Erro ao inserir o Usuario");
            }
        }

    public Funcionario loginUsuario(String cpf, String senha) {

        // Consulta MYSQL.
        String querySQL = "SELECT id_usuario, senha FROM Usuario WHERE cpf = ? LIMIT 1";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {

            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {

                //  Verifica se o CPF foi encontrado
                if (rs.next()) {
                    if (senha.equals(rs.getString("senha"))) {

                        long idDoUsuarioLogado = rs.getLong("id_usuario");

                        return this.buscar(idDoUsuarioLogado);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao iniciar login ");
        }

        return null;
    }
    @Override
    public Funcionario buscar(long idDoUsuarioLogado)
    {
        // Consulta MYSQL.
        String querySQL = "SELECT " +
                "U.ID_USUARIO, U.nome, U.cpf, U.senha, U.id_na, " +
                "G.id_departamento, " +
                "S.meta_mensal, " +
                "T.id_especialidade " +
                "FROM Usuario U " +
                "LEFT JOIN Gerentes G ON U.id_usuario = G.id_gerente " +
                "LEFT JOIN Supervisor S ON U.id_usuario = S.id_supervisor " +
                "LEFT JOIN Tecnico T ON U.id_usuario = T.id_tecnico " +
                "WHERE U.id_usuario = ?";


        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, idDoUsuarioLogado);

            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    return mapper.paraEntidadePorId(rs);
                }
            }
        } catch (SQLException e)
        {
            System.err.println("ERRO ao buscar usuário por ID!"+e.getMessage());
        }

        return null;
    }

    @Override
    public boolean excluir(long id)
    {
        // Consulta MYSQL.
        String querySQL = "DELETE FROM Usuario WHERE id_usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, id);

            int linhasAF = stmt.executeUpdate();

            return linhasAF > 0;

        }catch (SQLException e)
        {
            System.err.println("ERRO ao deletar usuário com o ID: " + id);
            return false;
        }
    }
    @Override
    public void atualizar(Funcionario funcionario) {
        // Consulta MySQL CORRIGIDA
        String querySQL = "UPDATE Usuario " +
                "SET nome = ?, cpf = ?, senha = ? " +
                "WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {

            stmt.setString(1, funcionario.getNome().toString());
            stmt.setString(2, funcionario.getCpf().toString());
            stmt.setString(3, funcionario.getSenha().toString());
            stmt.setLong(4, funcionario.getId());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com o ID: " + funcionario.getId());
            }

        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar usuário: " + e.getMessage());
        }
    }

    @Override
    public boolean existeId(long id)
    {
        // Consulta MYSQL.
        String querySql = "SELECT * FROM Usuario WHERE id_usuario = ? LIMIT 1";

        // Pega a conexão
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySql))
        {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            //Se o id for lido, ou seja, existe. Retorna true.
            if(rs.next())
            {
                return true;
            }
            //Caso contrario, retorna false.
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao verificar ID: ");
        }
        return false;
    }


    @Override
    public NivelAcesso nivelAcessoPorID(long id)
    {
        String querySQL = "SELECT id_na FROM Usuario WHERE id_usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    return mapper.paraNivelAcesso(rs);
                }
            }
        }
         catch (SQLException e) {
             System.err.println("ERRO ao consultar Nivel de Acesso do ID: " + id);

         } return null;
    }

    @Override
    public Funcionario buscar(CPF cpf)
    {
        // Consulta SQL
        String querySQL = "SELECT " +
                "U.ID_USUARIO, U.nome, U.cpf, U.senha, U.id_na, " +
                "S.meta_mensal, " +
                "T.id_especialidade " +
                "FROM Usuario U " +
                "LEFT JOIN Gerentes G ON U.id_usuario = G.id_gerente " +
                "LEFT JOIN Supervisor S ON U.id_usuario = S.id_supervisor " +
                "LEFT JOIN Tecnico T ON U.id_usuario = T.id_tecnico " +
                "WHERE U.cpf = ?";

        Funcionario funcionario = null;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setString(1, cpf.getCpf());

            try(ResultSet rs = stmt.executeQuery())
            {
                // Pegar Dados
                if(rs.next())
                {
                    return mapper.paraEntidadePorCpf(rs, conn);
                }
            }
        } catch (SQLException e)
        {
            System.err.println("ERRO ao buscar usuário por CPF!" + cpf + e.getMessage());
        }
        return funcionario;
    }
    public List<Funcionario> listarFuncionarios()
    {
        List<Funcionario> funcionarios = new ArrayList<>();

        String querySQL = "SELECT * FROM Usuarios";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                // Pega dados comuns.
                long id = rs.getLong("id_usuario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String senha = rs.getString("senha");
                int nivelAcesso = rs.getInt("id_na");


                // Cria funcionario (Comum).
                //Funcionario funcionario = new Funcionario(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha), new ListaDepartamentos());
            }
        }catch (SQLException e)
        {
            System.err.println("ERRO ao visualizar a lista.");
        }
        return List.of();
    }

    @Override
    public NomeFuncionario buscarNome(long id) {
        return null;
    }
}