package Infraestrutura.Persistencia.Implementacao.Ocorrencias.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Aplicacao.Ocorrencia.Mapper.OcorrenciaMapper;
import Dominio.Ocorrencia.Ocorrencia;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;
import Infraestrutura.Configuracao.ConnectionFactory;
import Infraestrutura.Persistencia.Implementacao.Ocorrencias.JDBC.Mapper.OcorrenciasMapper;

public class OcorrenciasJDBCRepositorio {

    private final OcorrenciasMapper statusMapper = new OcorrenciasMapper();

    public List<Ocorrencia> listarOcGerais()
    {
        List<Ocorrencia> ocorrencias = new ArrayList<>();
        String query = "SELECT id_ocorrencia, id_maquina, departamento, status_oc_codigo FROM ocorrencias";

        // Abre e fecha conexão
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next())
            {
                // Pega os IDs
                long idOcorrencia = resultSet.getLong("id_ocorrencia");
                long idMaquina = resultSet.getLong("id_maquina");

                String departamentoStr = resultSet.getString("departamento");
                Departamento departamento = Departamento.valueOf(departamentoStr);

                int statusOcCodigo = resultSet.getInt("status_oc_codigo");

                StatusOc statusOc = statusMapper.mapStatus(statusOcCodigo, idOcorrencia);

                // Cria o objeto Ocorrencia
                Ocorrencia ocorrencia = new Ocorrencia(
                        idOcorrencia,
                        idMaquina,
                        departamento,
                        statusOc
                );

                ocorrencias.add(ocorrencia);
            }
        } catch (SQLException e)
        {
            System.err.println("Erro no DB ao listar ocorrências.");
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("Erro ao mapear dados de ocorrências.");
        }
        return ocorrencias;
    }
}