package Infraestrutura.Persistencia.Implementacao.Maquina.Mapper;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.Enumeracoes.StatusMaquina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaquinaJdbcMapper
{
    public Departamento mapearDepartamento(int id) {
        return switch (id) {
            case 1 -> Departamento.ELETRICA;
            case 2 -> Departamento.MECANICA;
            default -> Departamento.MECANICA;
        };
    }

    public StatusMaquina mapearStatus(int id) {
        return switch (id) {
            case 1 -> StatusMaquina.FUNCIONANDO;
            case 2 -> StatusMaquina.DEFEITO;
            case 3 -> StatusMaquina.EM_MANUTENCAO;
            default -> StatusMaquina.FUNCIONANDO;
        };
    }
    public String paraNomePorId(Connection conn, long idMaquina) throws SQLException {
        String sql = "SELECT nome FROM Maquinas WHERE id_maquina = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, idMaquina);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nome");
                }
            }
        }
        return "Máquina Desconhecida"; // Retorno padrão caso não ache o ID
    }

    public long paraIdPorNome(Connection conn, String nomeMaquina) throws SQLException {
        String sql = "SELECT id_maquina FROM Maquinas WHERE nome = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeMaquina);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong("id_maquina");
                }
            }
        }
        return 0L; // Retorna 0 se a máquina não existir mais (foi excluída)
    }
}
