package ProjetoBase;

import Connections.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenteDAO
{
    public void inserirGerente(GerenteModel gerente)
    {
        String querySQL = "INSERTO INTO Gerentes (id_gerente, departamento) VALUES (?, ?)";

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
}
