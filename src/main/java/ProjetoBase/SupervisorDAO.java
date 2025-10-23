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
}
