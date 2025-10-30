package ProjetoBase;

import Connections.ConnectionFactory;

import java.sql.*;

public class UsuarioDAO
{
    public boolean verificarCpf(String cpf)
    {
        String querySql = "SELECT * FROM Usuario WHERE cpf = ? LIMIT 1";

        // Pega a conexão
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySql))
        {
            stmt.setString(1, cpf);

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
    public void inserirUsuario(UsuarioModel usuario)
    {
        // Comando SQL
        String querySQL = "INSERT INTO Usuario (nome, cpf, senha, nivel_acesso) VALUES (?, ?, ?, ?)";
        int idGerado = -1; // Armazena o id.

        // Pega a conexão
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS))
        {
            //Definindo parametros (PreparedStatement).
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getNivelAcesso());

            //Executando a inserção
            int linhasAF = stmt.executeUpdate();

            // Verificando se o comando ocorreu
            if (linhasAF > 0)
            {
                // Pega as chaves geradas.
                try (ResultSet rs = stmt.getGeneratedKeys())
                {
                    {
                        if (rs.next()) {
                            idGerado = rs.getInt(1);// Pega a chave (geralmente pela primeira coluna)
                            usuario.setIdUsuario(idGerado);
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

    public UsuarioModel loginUsuario(String cpf, String senha) {

        String querySQL = "SELECT id_usuario, senha FROM Usuario WHERE cpf = ? LIMIT 1";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {

            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {

                //  Verifica se o CPF foi encontrado

                if (rs.next()) {
                    if (senha.equals(rs.getString("senha"))) {

                        long idDoUsuarioLogado = rs.getLong("id_usuario");

                        return findById(idDoUsuarioLogado);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao iniciar login ");
        }

        return null;
    }
    public UsuarioModel findById(long idDoUsuarioLogado)
    {
        // Consulta MYSQL.
        String querySQL = "SELECT " +
                "U.ID_USUARIO, U.nome, U.cpf, U.senha, U.nivel_acesso, " +
                "G.departamento, " +
                "S.meta_mensal, " +
                "T.especialidade " +
                "FROM Usuario U " +
                "LEFT JOIN Gerentes G ON U.id_usuario = G.id_gerente " +
                "LEFT JOIN Supervisor S ON U.id_usuario = S.id_supervisor " +
                "LEFT JOIN Tecnico T ON U.id_usuario = T.id_tecnico " +
                "WHERE U.id_usuario = ?";

        UsuarioModel usuarioModel = null;

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
                    int nivelAcesso = rs.getInt("nivel_acesso");

                    switch(nivelAcesso)
                    {
                        case 1:
                            // Criando objeto de acordo com seu nivel_acesso.
                            int especialidade = rs.getInt("especialidade");
                            usuarioModel = new TecnicoModel(id, nome, cpf, senha, especialidade);
                            break;

                        case 2:
                            double metaMensal = rs.getDouble("meta_mensal");
                            usuarioModel = new SupervisorModel(id, nome, cpf, senha, metaMensal);
                            break;

                        case 3:
                            int departamento = rs.getInt("departamento");
                            usuarioModel = new GerenteModel(id, nome, cpf, senha, departamento);
                            break;
                    }
                }
            }
        } catch (SQLException e)
        {
            System.err.println("ERRO ao buscar usuário por ID!"+e.getMessage());
        }
        return usuarioModel;
    }

    public boolean deletarUsuario(long id)
    {
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
    public void updateNomeUsuario(long id, String novoNome)
    {
        String querySQl = "UPDATE Usuario " +
                        "SET nome = ?" +
                        "WHERE id_usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQl))
        {
            stmt.setString(1, novoNome);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        } catch (SQLException e)
        {
            System.err.println("ERRO ao atualizar nome do usuário.");
        }
    }

    public void updateSenhaUsuario(long id, String senhaNova)
    {
        String querySQl = "UPDATE Usuario " +
                "SET senha = ?" +
                "WHERE id_usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQl))
        {
            stmt.setString(1, senhaNova);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar senha do usuário.");
        }
    }

    public void updateCpfUsuario(long id, String cpfNovo)
    {
        String querySQl = "UPDATE Usuario " +
                "SET cpf = ?" +
                "WHERE id_usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQl))
        {
            stmt.setString(1, cpfNovo);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar cpf do usuário.");
        }
    }
}
