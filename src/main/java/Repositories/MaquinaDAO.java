package Repositories;

import Database.ConnectionFactory;
import Models.MaquinaModel;
import Models.joias.StatusMaquina;

import java.sql.*;

public class MaquinaDAO {
    //Comando para inserir as informações da máquina no Banco de Dados
    public void inserirMaquina(MaquinaModel maquina) {
        String querySQL = "INSERT INTO Maquinas (nome, localizacao, id_sm) VALUES (?, ?, ?)";
        long idGerado = -1;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS)) {
            //Definindo parametros (PreparedStatement).
            stmt.setString(1, maquina.getNome());
            stmt.setString(2, maquina.getLocalizacao());
            stmt.setLong(3, maquina.getStatus().getId());

            int linhasAF = stmt.executeUpdate();

            if (linhasAF > 0) {
                // Pega as chaves geradas.
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getLong(1);
                        maquina.setIdMaquina(idGerado);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO INSERIR MÁQUINA");
        }
    }

    // Comando para excluir uma máquina existente do Banco de Dados caso necessário
    public boolean deletarMaquina(long id) {
        String querySQL = "DELETE FROM Maquinas WHERE id_maquina ";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {
            stmt.setLong(1, id);

            int linhasAF = stmt.executeUpdate();

            if (linhasAF > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println("ERRO ao deletar máquina com o ID: " + id);
            return false;
        }
    }

    // Comando para atualizar o nome de uma máquina existente dentro do Banco de Dados
    public void updateNomeMaquina(long id, String novoNome) {
        String querySQL = "UPDATE Maquinas" + "SET nome = ?" + "WHERE id_maquina";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {
            stmt.setString(1, novoNome);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar o nome da máquina");
        }
    }

    // Comando para atualizar a localização de uma máquina existente dentro do Banco de Dados
    public void updateLocalizacaoMaquina(long id, String novaLocalizacao) {
        String querySQL = "UPDATE Maquinas" + "SET localizacao = ?" + "WHERE id_maquina";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {
            stmt.setString(1, novaLocalizacao);
            stmt.setLong(2, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar a localização da máquina");
        }
    }

    // Comando para atualizar o status de uma máquina existente dentro do Banco de Dados
    public void updateStatusMaquina(long id, StatusMaquina novoStatus) {
        String querySQL = "UPDATE Maquinas" + "SET id_sm = ?" + "WHERE id_maquina";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {
            stmt.setInt(1, novoStatus.getId());
            stmt.setLong(2, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar o status da máquina");
        }
    }

    public boolean verificarIdMaquina(long id) {
        // Consulta MYSQL.
        String querySql = "SELECT * FROM Maquinas WHERE id_maquina = ? LIMIT 1";

        // Pega a conexão
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySql)) {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar ID da máquina: ");
        }
        return false;
    }
}

