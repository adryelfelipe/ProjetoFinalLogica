package Infraestrutura.Persistencia.Implementacao.Funcionario.JDBC;

import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Infraestrutura.Configuracao.ConnectionFactory;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Tecnico.Tecnico;
import Infraestrutura.Persistencia.Implementacao.Funcionario.Mapper.FuncionarioJdbcMapper;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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
            String sqlUsuario = "INSERT INTO Usuario (nome, cpf, senha, id_na) VALUES (?, ?, ?, ?)";

            try (Connection conn = ConnectionFactory.getConnection()) {

                // Prepara o comando avisando que queremos a chave gerada de volta
                PreparedStatement stmt = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);

                stmt.setString(1, funcionario.getNome().getNome());
                stmt.setString(2, funcionario.getCpf().getCpf());
                stmt.setString(3, funcionario.getSenha().getSenha());

                // Define o ID do Nivel de Acesso baseado na classe
                int idNa = 1; // Padrão Tecnico
                if (funcionario instanceof Supervisor) idNa = 2;
                else if (funcionario instanceof Gerente) idNa = 3;
                else if (funcionario instanceof Administrador) idNa = 4;

                stmt.setInt(4, idNa);
                stmt.executeUpdate(); // Executa o INSERT

                // --- PASSO 2: Pegar o ID que o banco criou ---
                ResultSet rs = stmt.getGeneratedKeys();
                long idGerado = 0;
                if (rs.next()) {
                    idGerado = rs.getLong(1);
                }

                String sqlDept = "INSERT INTO UsuarioDepartamento (id_usuario, id_departamento) VALUES (?, ?)";
                PreparedStatement stmtDept = conn.prepareStatement(sqlDept);

                for (Departamento dept : funcionario.getDepartamentos().getListaDepartamentos()) {
                    stmtDept.setLong(1, idGerado);

                    // Se for Eletrica é 1, se não é 2 (Mecanica)
                    int idD = (dept == Departamento.ELETRICA) ? 1 : 2;
                    stmtDept.setInt(2, idD);

                    stmtDept.executeUpdate();
                }

                // --- PASSO 4: Salvar na tabela específica (Tecnico, Supervisor, etc) ---
                if (funcionario instanceof Tecnico) {
                    String sql = "INSERT INTO Tecnico (id_tecnico, id_especialidade) VALUES (?, ?)";
                    PreparedStatement stmtCargo = conn.prepareStatement(sql);
                    stmtCargo.setLong(1, idGerado);

                    // Faz o cast para poder pegar a especialidade
                    Tecnico tec = (Tecnico) funcionario;

                    // Lógica simples: Se for Eletrotécnica é 1, senão coloca 2 (exemplo basico)
                    int idEsp = (tec.getEspecialidade() == Especialidade.TECNICO_ELETROTECNICA) ? 1 : 2;

                    stmtCargo.setInt(2, idEsp);
                    stmtCargo.executeUpdate();
                }
                else if (funcionario instanceof Supervisor) {
                    String sql = "INSERT INTO Supervisor (id_supervisor, meta_mensal) VALUES (?, ?)";
                    PreparedStatement stmtCargo = conn.prepareStatement(sql);
                    stmtCargo.setLong(1, idGerado);

                    Supervisor sup = (Supervisor) funcionario;
                    stmtCargo.setDouble(2, sup.getMetaMensal().getValorMetaMensal());
                    stmtCargo.executeUpdate();
                }
                else if (funcionario instanceof Gerente) {
                    String sql = "INSERT INTO Gerentes (id_gerente, id_departamento) VALUES (?, ?)";
                    PreparedStatement stmtCargo = conn.prepareStatement(sql);
                    stmtCargo.setLong(1, idGerado);

                    // Pega o primeiro departamento da lista como principal, ou 1 se não tiver
                    int idDeptPrincipal = 1;
                    if (!funcionario.getDepartamentos().getListaDepartamentos().isEmpty()) {
                        idDeptPrincipal = (funcionario.getDepartamentos().getListaDepartamentos().getFirst() == Departamento.ELETRICA) ? 1 : 2;
                    }

                    stmtCargo.setInt(2, idDeptPrincipal);
                    stmtCargo.executeUpdate();
                }

            } catch (SQLException e) {
                System.err.println("Erro ao salvar: " + e.getMessage());
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
        FuncionarioJdbcMapper departamentoDAO = new FuncionarioJdbcMapper();

        String querySQL = "SELECT " +
                "U.ID_USUARIO, U.nome, U.cpf, U.senha, U.id_na, " +
                "S.meta_mensal, " +
                "T.id_especialidade " +
                "FROM Usuario U " +
                "LEFT JOIN Gerentes G ON U.id_usuario = G.id_gerente " +
                "LEFT JOIN Supervisor S ON U.id_usuario = S.id_supervisor " +
                "LEFT JOIN Tecnico T ON U.id_usuario = T.id_tecnico";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL);
            ResultSet rs = stmt.executeQuery())
        {
            while(rs.next())
            {
                long id = rs.getLong("id_usuario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String senha = rs.getString("senha");
                int nivelAcesso = rs.getInt("id_na");

                ListaDepartamentos listaDepartamentos = departamentoDAO.paraDepartamentosPorId(conn, id);

                Funcionario funcionario = null;

                switch(nivelAcesso)
                {
                    case 1:
                        int idEspecialidade = rs.getInt("id_especialidade");
                        Especialidade especialidade = switch(idEspecialidade) {
                            case 1 -> Especialidade.TECNICO_ELETROTECNICA;
                            case 2 -> Especialidade.ELETRICISTA_FABRIL;
                            case 3 -> Especialidade.SOLDADOR;
                            case 4 -> Especialidade.TECNICO_ELETROMECANICA;
                            default -> Especialidade.PINTOR_INDUSTRIAL;
                        };
                        funcionario = new Tecnico(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha), listaDepartamentos, especialidade);
                        break;

                    case 2:
                        double metaMensal = rs.getDouble("meta_mensal");
                        funcionario = new Supervisor(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha), listaDepartamentos, new MetaMensal(metaMensal));
                        break;

                    case 3:
                        funcionario = new Gerente(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha), listaDepartamentos);
                        break;

                    case 4:
                        funcionario = new Administrador(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha), listaDepartamentos);
                        break;
                }

                if(funcionario != null)
                {
                    funcionarios.add(funcionario);
                }
            }
        } catch (SQLException e)
        {
            System.err.println("ERRO ao visualizar a lista.");
        }
        return funcionarios;
    }

    @Override
    public NomeFuncionario buscarNome(long id)
    {
        return null;
    }
}