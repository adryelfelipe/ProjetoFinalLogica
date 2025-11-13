package Infraestrutura.Persistencia.Implementacao.Funcionario.Tecnico.JDBC;

import Infraestrutura.Configuracao.ConnectionFactory;
import Dominio.Funcionario.Tecnico.Tecnico;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TecnicoJdbcRepositorio
{
    public void salvar(Tecnico tecnico)
    {

        String querySQL = "INSERT INTO Tecnico (id_tecnico, id_especialidade) VALUES (?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, tecnico.getId());
            stmt.setInt(2, tecnico.getEspecialidade().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERRO ao inserir tecnico");
        }
    }
    public boolean excluirPorId(long id)
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

    public void updateEspecialidadeTecnico(long id, Especialidade novaEspecialidade)
    {
        String querySQl = "UPDATE Tecnico SET id_especialidade = ? WHERE id_tecnico = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQl))
        {
            stmt.setInt(1, novaEspecialidade.getId());
            stmt.setLong(2, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar especialidade do tecnico");
        }
    }


}