package Infraestrutura.Persistencia.Implementacao.Ocorrencias.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Aplicacao.Ocorrencia.Mapper.OcorrenciaMapper;
import Dominio.Ocorrencia.Ocorrencia;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;
import Dominio.Ocorrencia.Repositories.OcorrenciaRepositorio;
import Infraestrutura.Configuracao.ConnectionFactory;
import Infraestrutura.Persistencia.Implementacao.Ocorrencias.JDBC.Mapper.OcorrenciaMappers;

public class OcorrenciasJDBCRepositorio implements OcorrenciaRepositorio {

    private final OcorrenciaMappers mapper = new OcorrenciaMappers();

    @Override
    public void salvar(Ocorrencia ocorrencia) {
        String query = "INSERT INTO OcorrenciasAtivas (id_maquina, id_departamento, status_oc_codigo) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, ocorrencia.getIdMaquina());
            stmt.setInt(2, ocorrencia.getDepartamento().getId());
            stmt.setLong(3, ocorrencia.getStatusOc().getId());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        ocorrencia.alteraIdOcorrencia(rs.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO SALVAR OCORRENCIA ATIVA");
        }
    }

    @Override
    public void excluirPorId(long id) {
        String query = "DELETE FROM OcorrenciasAtivas WHERE id_oa = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERRO AO EXCLUIR OCORRENCIA");
        }
    }

    @Override
    public void atualizar(Ocorrencia ocorrencia) {
        String query = "UPDATE OcorrenciasAtivas SET id_maquina = ?, id_departamento = ?, status_oc_codigo = ? WHERE id_oa = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setLong(1, ocorrencia.getIdMaquina());
            stmt.setInt(2, ocorrencia.getDepartamento().getId());
            stmt.setLong(3, ocorrencia.getStatusOc().getId());
            stmt.setLong(4, ocorrencia.getIdOcorrencia());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERRO AO ATUALIZAR OCORRENCIA");
        }
    }

    @Override
    public List<Ocorrencia> listarOcAtivas() {
        List<Ocorrencia> ocorrencias = new ArrayList<>();
        String query = "SELECT id_oa, id_maquina, id_departamento, status_oc_codigo FROM OcorrenciasAtivas";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                long idOcorrencia = resultSet.getLong("id_oa");
                long idMaquina = resultSet.getLong("id_maquina");
                int idDepto = resultSet.getInt("id_departamento");
                int statusOcCodigo = resultSet.getInt("status_oc_codigo");

                Departamento departamento = mapper.mapearDepartamento(idDepto);
                StatusOc statusOc = mapper.mapearStatus(statusOcCodigo);

                Ocorrencia ocorrencia = new Ocorrencia(idOcorrencia, idMaquina, departamento, statusOc);
                ocorrencias.add(ocorrencia);
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO LISTAR OCORRENCIAS ATIVAS");
        }
        return ocorrencias;
    }

    @Override
    public List<Ocorrencia> listarOcGerais() {
        List<Ocorrencia> ocorrencias = new ArrayList<>();
        String query = "SELECT id_og, id_maquina, id_departamento, status_oc_codigo FROM OcorrenciasGerais";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                long idOcorrencia = resultSet.getLong("id_og");
                long idMaquina = resultSet.getLong("id_maquina");
                int idDepto = resultSet.getInt("id_departamento");
                int statusOcCodigo = resultSet.getInt("status_oc_codigo");

                Departamento departamento = mapper.mapearDepartamento(idDepto);
                StatusOc statusOc = mapper.mapearStatus(statusOcCodigo);

                Ocorrencia ocorrencia = new Ocorrencia(idOcorrencia, idMaquina, departamento, statusOc);
                ocorrencias.add(ocorrencia);
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO LISTAR OCORRENCIAS GERAIS");
        }
        return ocorrencias;
    }

    @Override
    public Ocorrencia buscarPorId(long idOc) {
        String query = "SELECT id_oa, id_maquina, id_departamento, status_oc_codigo FROM OcorrenciasAtivas WHERE id_oa = ?";
        Ocorrencia ocorrencia = null;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setLong(1, idOc);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    long idOcorrencia = resultSet.getLong("id_oa");
                    long idMaquina = resultSet.getLong("id_maquina");
                    int idDepto = resultSet.getInt("id_departamento");
                    int statusOcCodigo = resultSet.getInt("status_oc_codigo");

                    Departamento departamento = mapper.mapearDepartamento(idDepto);
                    StatusOc statusOc = mapper.mapearStatus(statusOcCodigo);

                    ocorrencia = new Ocorrencia(idOcorrencia, idMaquina, departamento, statusOc);
                }
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO BUSCAR OCORRENCIA POR ID");
        }
        return ocorrencia;
    }

    @Override
    public boolean existeOcorrenciaMaquina(long idMaquina) {
        String query = "SELECT count(*) FROM OcorrenciasAtivas WHERE id_maquina = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, idMaquina);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO VERIFICAR EXISTENCIA OCORRENCIA");
        }
        return false;
    }

    @Override
    public Ocorrencia ocorrenciaPorIdMaquina(long idMaquina) {
        String query = "SELECT id_oa, id_maquina, id_departamento, status_oc_codigo FROM OcorrenciasAtivas WHERE id_maquina = ? LIMIT 1";
        Ocorrencia ocorrencia = null;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setLong(1, idMaquina);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    long idOcorrencia = resultSet.getLong("id_oa");
                    int idDepto = resultSet.getInt("id_departamento");
                    int statusOcCodigo = resultSet.getInt("status_oc_codigo");

                    Departamento departamento = mapper.mapearDepartamento(idDepto);
                    StatusOc statusOc = mapper.mapearStatus(statusOcCodigo);

                    ocorrencia = new Ocorrencia(idOcorrencia, idMaquina, departamento, statusOc);
                }
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO BUSCAR OCORRENCIA POR ID MAQUINA");
        }
        return ocorrencia;
    }
    public void salvarGeral(Ocorrencia ocorrencia) {
        String query = "INSERT INTO OcorrenciasGerais (id_maquina, id_departamento) VALUES (?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, ocorrencia.getIdMaquina());
            stmt.setInt(2, ocorrencia.getDepartamento().getId());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        ocorrencia.alteraIdOcorrencia(rs.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO SALVAR OCORRENCIA GERAL");
        }
    }

    public void excluirGeralPorId(long id) {
        String query = "DELETE FROM OcorrenciasGerais WHERE id_og = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERRO AO EXCLUIR OCORRENCIA GERAL");
        }
    }

    public void atualizarGeral(Ocorrencia ocorrencia) {
        String query = "UPDATE OcorrenciasGerais SET id_maquina = ?, id_departamento = ? WHERE id_og = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setLong(1, ocorrencia.getIdMaquina());
            stmt.setInt(2, ocorrencia.getDepartamento().getId());
            stmt.setLong(3, ocorrencia.getIdOcorrencia());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERRO AO ATUALIZAR OCORRENCIA GERAL");
        }
    }

    public Ocorrencia buscarGeralPorId(long idOc) {
        String query = "SELECT id_og, id_maquina, id_departamento FROM OcorrenciasGerais WHERE id_og = ?";
        Ocorrencia ocorrencia = null;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setLong(1, idOc);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    long idOcorrencia = resultSet.getLong("id_og");
                    long idMaquina = resultSet.getLong("id_maquina");
                    int idDepto = resultSet.getInt("id_departamento");

                    Departamento departamento = mapper.mapearDepartamento(idDepto);
                    StatusOc statusOc = mapper.getStatusParaGeral();

                    ocorrencia = new Ocorrencia(idOcorrencia, idMaquina, departamento, statusOc);
                }
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO BUSCAR OCORRENCIA GERAL POR ID");
        }
        return ocorrencia;
    }

}