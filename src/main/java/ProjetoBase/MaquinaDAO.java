package ProjetoBase;

import Connections.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaquinaDAO
{
    //Comando para inserir as informações da máquina no Banco de Dados
    public void inserirMaquina(MaquinaModel maquina)
    {
        String querySQL = "INSERT INTO Maquinas (id_maquina, nome, localizacao) VALUES (?, ?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, maquina.getIdMaquina());
            stmt.setString(2, maquina.getNome());
            stmt.setString(3, maquina.getLocalizacao());

            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("ERRO AO INSERIR MÁQUINA");
        }
    }

    // Comando para excluir uma máquina existente do Banco de Dados caso necessário
    public boolean deletarMaquina(long id)
    {
        String querySQL = "DELETE FROM Maquinas WHERE id_maquina ";

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
        catch (SQLException e)
        {
            System.err.println("ERRO ao deletar máquina com o ID: "+id);
            return false;
        }
    }

    // Comando para atualizar o nome de uma máquina existente dentro do Banco de Dados
    public void updateNomeMaquina(long id, String novoNome)
    {
        String querySQL = "UPDATE Maquinas" + "SET nome = ?" + "WHERE id_maquina";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setString(1, novoNome);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("ERRO ao atualizar o nome da máquina");
        }
    }

    // Comando para atualizar a localização de uma máquina existente dentro do Banco de Dados
    public void updateLocalizacaoMaquina(long id, String novaLocalizacao)
    {
        String querySQL = "UPDATE Maquinas" + "SET localizacao = ?" + "WHERE id_maquina";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setString(1, novaLocalizacao);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("ERRO ao atualizar a localização da máquina");
        }
    }

    // Comando para atualizar o status de uma máquina existente dentro do Banco de Dados
    public void updateStatusMaquina(long id, String novoStatus)
    {
        String querySQL = "UPDATE Maquinas" + "SET id_sm = ?" + "WHERE id_maquina";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setString(1, novoStatus);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("ERRO ao atualizar o status da máquina");
        }
    }
}

