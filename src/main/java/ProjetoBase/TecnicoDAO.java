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
    public void deletarTecnico(long id)
    {
        String querySQL = "DELETE FROM Tecnico WHERE id_tecnico = ?";

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
        }catch(SQLException e)
        {
            System.err.println("ERRO ao deletar tecnico com o ID: " + id);
            return false;
        }
    }

    public void updateEspecialidadeTecnico(long id, int novaEspecialidade)
    {
        String querySQl = "UPDATE Tecnico t " +
                        "INNER JOIN Usuario u ON t.id_tecnico = u.id_usuario" +
                        "SET especialidade = ?" +
                        "WHERE id_usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQl))
        {
            stmt.setInt(1, novaEspecialidade);
            stmt.setLong(2, id);

            stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar especialidade do tecnico");
        }
    }

}
