package ProjetoBase;

import Connections.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TecnicoDAO
{
    public void inserirTecnico(TecnicoModel tecnico)
    {
        String querySQL = "INSERTO INTO Tecnico (id_tecnico, especialidade) VALUES (?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, tecnico.getIdUsuario());
            stmt.setInt(2, tecnico.getEspecialidade());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERRO AO INSERIR PACIENTE");
        }
    }

}
