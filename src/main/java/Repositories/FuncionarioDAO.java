package Repositories;

import Database.ConnectionFactory;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioQueriesRepositorio;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Tecnico.Tecnico;

import java.sql.*;

public class FuncionarioDAO implements FuncionarioRepositorio, FuncionarioQueriesRepositorio
{
    @Override
    public boolean existeCpf(CPF cpf) {
        return false;
    }

    @Override
    public boolean existeId(long id) {
        return false;
    }

    @Override
    public Funcionario buscarPorId(long id) {
        return null;
    }

    @Override
    public NivelAcesso nivelAcessoPorID(long id) {
        return null;
    }

    @Override
    public Funcionario buscarPorCpf(CPF cpf) {
        return null;
    }

    @Override
    public void salvar(Funcionario funcionario) {

    }

    @Override
    public void atualizar(Funcionario funcionario) {

    }

    @Override
    public boolean excluirPorId(long id) {
        return false;
    }

    /*
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
                        funcionario.alteraIdUsuario(idGerado);
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

                        return buscarPorId(idDoUsuarioLogado);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao iniciar login ");
        }

        return null;
    }
    public Funcionario buscarPorId(long idDoUsuarioLogado)
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

        Funcionario funcionario = null;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, idDoUsuarioLogado);

            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    // Pega dados comuns...
                    long id = rs.getLong("id_usuario");
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String senha = rs.getString("senha");
                    int nivelAcesso = rs.getInt("id_na");

                    switch(nivelAcesso)
                    {
                        case 1:
                            // Criando objeto de acordo com seu nivel_acesso.
                            int idEspecialidade = rs.getInt("id_especialidade");

                            Especialidade especialidade = switch(idEspecialidade) {
                                case 1 -> Especialidade.TECNICO_ELETROTECNICA;
                                case 2 -> Especialidade.ELETRICISTA_FABRIL;
                                case 3 -> Especialidade.SOLDADOR;
                                case 4 -> Especialidade.TECNICO_ELETROMECANICA;
                                default -> Especialidade.PINTOR_INDUSTRIAL;
                            };

                            funcionario = new Tecnico(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha),new ListaDepartamentos(departamento), especialidade);
                            break;

                        case 2:
                            double metaMensal = rs.getDouble("meta_mensal");
                            funcionario = new Supervisor(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha), new ListaDepartamentos(departamento), new MetaMensal(metaMensal));
                            break;

                        case 3:
                            int idDepartamento = rs.getInt("id_departamento");

                            Departamento departamento = switch (idDepartamento) {
                                case 1 -> Departamento.ELETRICA;
                                default -> Departamento.MECANICA;
                            };

                            funcionario = new Gerente(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha), new ListaDepartamentos();
                            break;

                        case 4:
                            funcionario = new Administrador(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha), new ListaDepartamentos();
                            break;
                    }
                }
            }
        } catch (SQLException e)
        {
            System.err.println("ERRO ao buscar usuário por ID!"+e.getMessage());
        }
        return funcionario;
    }

    public boolean excluirPorId(long id)
    {
        // Consulta MYSQL.
        String querySQL = "DELETE FROM Usuario WHERE id_usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, id);

            int linhasAF = stmt.executeUpdate();

            // Se conseguir deletar retorna true.
            if(linhasAF > 0)
            {
                return true;
            }
            // Senão retorna false.
            else
            {
                return false;
            }
        }catch (SQLException e)
        {
            System.err.println("ERRO ao deletar usuário com o ID: " + id);
            return false;
        }
    }
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
            stmt.setLong(4, funcionario.getIdUsuario());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com o ID: " + funcionario.getIdUsuario());
            }

        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar usuário: " + e.getMessage());
        }
    }

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
                    int nivelAcesso = rs.getInt("id_na");

                    switch (nivelAcesso)
                    {
                        case 1:
                            return NivelAcesso.TECNICO;
                        case 2:
                            return NivelAcesso.SUPERVISOR;
                        case 3:
                            return NivelAcesso.GERENTE;
                        default:
                            return NivelAcesso.ADMIN;
                    }
                }
            }
        }
         catch (SQLException e) {
             System.err.println("ERRO ao consultar Nivel de Acesso do ID: " + id);

         } return null;
    }

    public Funcionario buscarPorCpf(CPF cpf)
    {

    }

     */
}