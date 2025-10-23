package ProjetoBase;

import Connections.ConnectionFactory;

import java.sql.*;

public class UsuarioDAO
{
    public boolean verificarCpf(String cpf)
    {
        String querySql = "SELECT * FROM Usuario WHERE cpf = ? LIMIT 1";

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
            System.err.println("Erro ao verificar CPF: " + e.getMessage());
        }
        return false;
    }
    public void inserirUsuario(UsuarioModel usuario)
    {
        // Comando SQL
        String querySQL = "INSERT INTO Usuario (nome, cpf, senha, nivel_acesso) VALUES (?, ?, ?, ?)";
        int idGerado = 0; // Armazena o id.

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
            System.out.println("Erro ao inserir o Usuario");
        }
    }

}
