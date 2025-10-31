package ProjetoBase;

import Connections.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenteDAO
{
    public void inserirGerente(GerenteModel gerente)
    {
        String querySQL = "INSERT INTO Gerentes (id_gerente, departamento) VALUES (?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, gerente.getIdUsuario());
            stmt.setInt(2, gerente.getDepartamento());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERRO AO INSERIR GERENTE");
        }
    }

    public boolean deletarGerente(long id)
    {
        String querySQL = "DELETE FROM Gerentes WHERE id_gerente = ?";

        try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, id);

            int linhasAF = stmt.executeUpdate();

            // Se conseguir retorna true.
            if(linhasAF > 0 )
            {
                return true;
            }
            // Senão conseguir retorna false.
            else
            {
                return false;
            }
        }catch (SQLException e )
        {
            System.err.println("ERRO ao deletar gerente com o ID: " + id);
            return false;
        }
    }

    public void updatedepartamento(long id, int novoDepartamento)
    {
        String querySQL = "UPDATE FROM Gerente g " +
                        "INNER JOIN Usuario u ON g.id_gerente = u.id_usuario " +
                        "SET departamento = ? " +
                        "WHERE id_usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setInt(1, novoDepartamento);
            stmt.setLong(2, id);

            stmt.executeQuery();
        }catch (SQLException e)
        {
            System.err.println("ERRO ao atualizar departamento do gerente");
        }
    }

}

