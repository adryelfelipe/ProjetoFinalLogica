package ProjetoBase;

import Connections.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdemDeServicoDAO
{
    public void inserirOrdemDeServico(OrdemDeServicoModel ordemDeServico)
    {
        String querySQL = "INSERT INTO OrdemServicos (id_os, descricao, status_ordem, custo) VALUES (?, ?, ?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, ordemDeServico.getIdOrdemDeServico());
            stmt.setString(2, ordemDeServico.getDescricao());
            stmt.setInt(3, ordemDeServico.getStatusDaOrdem());
            stmt.setDouble(4, ordemDeServico.getValorDaOrdemDeServico());

            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("ERRO AO INSERIR A ORDEM DE SERVIÇO");
        }
    }

    public boolean deletarOrdemDeServico(long id)
    {
        String querySQL = "DELETE FROM OrdemServicos WHERE id_os";

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
        }
        catch(SQLException e)
        {
            System.err.println("ERRO ao deletar a ordem de serviço com o ID: "+id);
            return false;
        }
    }

    public void updateDescricaoOrdemDeServico (long id, String novaDescricao)
    {
        String querySQL = "UPDATE OrdemServicos" + "SET descricao = ?" + "WHERE id_os";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setString(1, novaDescricao);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("ERRO ao atualizar a descrição da ordem de serviços");
        }
    }
}
