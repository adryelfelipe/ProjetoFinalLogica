import Connections.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    }

}
