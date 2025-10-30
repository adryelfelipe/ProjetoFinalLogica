package ProjetoBase;

import Connections.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupervisorDAO
{
    public void inserirSupervisor(SupervisorModel supervisor)
    {
        String querySQL = "INSERT INTO Supervisor (id_supervisor, meta_mensal) VALUES (?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, supervisor.getIdUsuario());
            stmt.setDouble(2, supervisor.getMetaMensal());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERRO AO INSERIR SUPERVISOR");
        }
    }

    public boolean deletarSupervisor(long id)
    {
        String querySQL = "DELETE FROM Supervisor WHERE id_supervisor = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, id);

            int linhasAF = stmt.executeUpdate();

            if(linhasAF > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }catch (SQLException e)
        {
            System.err.println("ERRO ao deletar supervisor com o ID: " + id);
            return false;
        }
    }

    public void updateMetaMensal(long id, double metaMensal)
    {
        String querySQL = "UPDATE FROM Supervisor s " +
                        "INNER JOIN Usuario u ON s.id_supervisor = u.id_usuario " +
                        "SET meta_mensal = ?" +
                        "WHERE id_usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setDouble(1, metaMensal);
            stmt.setLong(2, id);

            stmt.executeQuery();
        }catch (SQLException e)
        {
            System.err.println("ERRO ao atualizar meta mensal do supervisor");
        }
    }

}
