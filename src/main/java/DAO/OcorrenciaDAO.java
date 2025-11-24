package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.ConnectionFactory;
import Models.Ocorrencia;
import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.StatusOC;
public class OcorrenciaDAO
{
    public List<Ocorrencia> listarOcGerais()
    {
        List<Ocorrencia> ocorrencias = new ArrayList<>();

        String query = "SELECT id_ocorrencia, id_maquina, departamento, status_oc_codigo FROM ocorrencias";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next())
            {
                long idOcorrencia = resultSet.getLong("id_ocorrencia");
                long idMaquina = resultSet.getLong("id_maquina");

                int idDepartamento = resultSet.getInt("departamento");

                Departamento departamento = switch (idDepartamento) {
                    case 1 -> Departamento.ELETRICA;
                    // Se tiver outros IDs, adicione aqui
                    default -> Departamento.MECANICA;
                };

                int statusOcCodigo = resultSet.getInt("status_oc_codigo");

                StatusOC statusOc = switch (statusOcCodigo) {
                    case 1 -> StatusOC.ABERTA;
                    case 2 -> StatusOC.EM_ANDAMENTO;
                    case 3 -> StatusOC.FECHADA;
                    default -> throw new IllegalArgumentException(
                            "Status inválido para ID " + idOcorrencia + ": " + statusOcCodigo
                    );
                };

                Ocorrencia ocorrencia = new Ocorrencia(
                        idOcorrencia,
                        departamento,
                        idMaquina,
                        statusOc
                );

                ocorrencias.add(ocorrencia);
            }
        } catch (SQLException e)
        {
            System.err.println("Erro no DB ao listar ocorrências: " + e.getMessage());
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("Erro de conversão: " + e.getMessage());
        }
        return ocorrencias;
    }
}
