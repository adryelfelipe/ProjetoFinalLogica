package Repositories;

import Database.ConnectionFactory;
import Models.OrdemDeServicoModel;
import Models.joias.StatusOS;

import java.sql.*;

public class OrdemDeServicoDAO
{
    // Comando para inserir uma ordem de serviço dentro do Banco de Dados
    public void inserirOrdemDeServico(OrdemDeServicoModel ordemDeServico)
    {
        String querySQL = "INSERT INTO OrdemServicos (id_os, descricao, status_ordem, custo) VALUES (?, ?, ?, ?)";
        long idGerado = -1;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(2, ordemDeServico.getDescricao());
            stmt.setInt(3, ordemDeServico.getStatusDaOrdem().getId());
            stmt.setDouble(4, ordemDeServico.getValorDaOrdemDeServico());

            int linhasAF = stmt.executeUpdate();

            if(linhasAF > 0)
            {
                try(ResultSet rs = stmt.getGeneratedKeys())
                {
                    if(rs.next())
                    {
                        idGerado = rs.getLong(1);
                        ordemDeServico.setIdOrdemDeServico(idGerado);
                    }
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("ERRO AO INSERIR A ORDEM DE SERVIÇO");
        }
    }

    // Comando para excluir uma ordem de serviço existente do Banco de Dados caso necessário
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

    // Comando para atualizar a descrição de uma ordem de serviço existente do Banco de Dados
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

    // Comando para atualizar os status de uma ordem de serviço existente do Banco de Dados
    public void updateStatusOrdemDeServicos (long id, StatusOS novoStatus)
    {
        String querySQL = "UPDATE OrdemServicos" + "SET status_ordem = ?" + "WHERE id_os";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setInt(1, novoStatus.getId());
            stmt.setLong(2, id);

            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("ERRO ao atualizar o status da ordem de serviços");
        }
    }

    // Comando para atualizar o custo de uma ordem de serviço existente do Banco de Dados
    public void updateCustoOrdemDeServicos (long id, double novoValor)
    {
        String querySQL = "UPDATE OrdemServicos" + "SET custo = ?" + "WHERE id_os";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setDouble(1, novoValor);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("ERRO ao atualizar o valor da ordem de serviços");
        }
    }

    // Comando para atualizar o id de máquina que referencia uma ordem de serviço existente do Banco de Dados
    public void updateIdMaquina (long id, long novoIdMaquina)
    {
        String querySQL = "UPDATE OrdemServicos" + "SET id_maquina = ?" + "WHERE id_os";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, novoIdMaquina);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("ERRO ao atualizar o id da maquina da ordem de serviços");
        }
    }

    // Comando para atualizar o id de supervisor que referencia uma ordem de serviço existente do Banco de Dados
    public void updateIdSupervisor (long id, long novoIdSupervisor)
    {
        String querySQL = "UPDATE OrdemServicos" + "SET id_maquina = ?" + "WHERE id_os";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, novoIdSupervisor);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("ERRO ao atualizar o id do supervisor da ordem de serviços");
        }
    }

    // Comando para atualizar o id de técnico que referencia uma ordem de serviço existente do Banco de Dados
    public void updateIdTecnico (long id, long novoIdTecnico)
    {
        String querySQL = "UPDATE OrdemServicos" + "SET id_maquina = ?" + "WHERE id_os";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, novoIdTecnico);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("ERRO ao atualizar o id do tecnico da ordem de serviços");
        }
    }
    public OrdemDeServicoModel findByIdOS(long idOS) {
        String querySQL = "SELECT * FROM OrdemServicos WHERE id_os = ?";

        OrdemDeServicoModel os = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {

            stmt.setLong(1, idOS);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                {
                    long id = rs.getLong("id_os");
                    String descricao = rs.getString("descricao");
                    int StatusOrdem = rs.getInt("status_ordem");
                    double custo = rs.getDouble("custo");
                    long idMaquina = (rs.getLong("id_maquina"));
                    long idTecnico = rs.getLong("id_tecnico");
                    StatusOS statusOS = switch (StatusOrdem) {
                        case 1 -> StatusOS.EM_ANDAMENTO;
                        case 2 -> StatusOS.ATRASADA;
                        default -> StatusOS.FECHADA;
                    };
                    os = new OrdemDeServicoModel(id, idTecnico, idMaquina, statusOS, descricao, custo);
                }
            }
            return os;
        } catch (SQLException e) {
            System.err.println("ERRO ao buscar OS com ID: " + idOS);
        }
        return os;
    }

    public boolean verificarIdOS(long id)
    {
        // Consulta MYSQL.
        String querySql = "SELECT * FROM OrdemServico WHERE id_os = ? LIMIT 1";

        // Pega a conexão
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySql))
        {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            //Se o id for lido, ou seja, existe. Retorna true.
            if(rs.next()) {
                return true;
            }
            //Caso contrario, retorna false.
            else {
                return false;
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao verificar ID da ordem de servico: " + id);
        }
        return false;
    }
}
