package Infraestrutura.Persistencia.Implementacao.OrdemDeServico.JDBC;

import Aplicacao.OrdemDeServico.Mapper.OrdemDeServicoMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Dominio.OrdemDeServico.Enumeracoes.TipoOS;
import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;
import Dominio.OrdemDeServico.OrdemDeServico;
import Dominio.OrdemDeServico.Repositorios.OrdemDeServicoRepositorio;
import Infraestrutura.Configuracao.ConnectionFactory;
import Infraestrutura.Persistencia.Implementacao.OrdemDeServico.Mapper.OsJdbcMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OsJdbcRepositorio implements OrdemDeServicoRepositorio {

    private final OsJdbcMapper mapper = new OsJdbcMapper();

    @Override
    public void salvar(OrdemDeServico ordemDeServico) {
        String querySQL = "INSERT INTO OrdemServicos (descricao, status_ordem, custo, id_supervisor, id_maquina, id_tecnico) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, ordemDeServico.getDescricao().getDescricao());
            stmt.setInt(2, mapper.paraIdStatus(ordemDeServico.getStatusOS()));
            stmt.setDouble(3, ordemDeServico.getValorOS().getValorOS());
            stmt.setLong(4, ordemDeServico.getIdSupervisor());
            stmt.setLong(5, ordemDeServico.getIdMaquina());
            stmt.setLong(6, ordemDeServico.getIdTecnico());

            int linhasAF = stmt.executeUpdate();

            if (linhasAF > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        ordemDeServico.alteraIdOS(rs.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO INSERIR A ORDEM DE SERVIÇO");
        }
    }

    @Override
    public boolean excluirPorId(long id) {
        String querySQL = "DELETE FROM OrdemServicos WHERE id_os = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {
            stmt.setLong(1, id);

            int linhasAF = stmt.executeUpdate();

            return linhasAF > 0;
        } catch (SQLException e) {
            System.err.println("ERRO ao deletar a ordem de serviço com o ID: " + id);
            return false;
        }
    }

    @Override
    public void atualizar(OrdemDeServico ordemServico) {
        String querySQL = "UPDATE OrdemServicos SET " +
                "descricao = ?, " +
                "status_ordem = ?, " +
                "custo = ?, " +
                "id_maquina = ?, " +
                "id_supervisor = ?, " +
                "id_tecnico = ? " +
                "WHERE id_os = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {

            stmt.setString(1, ordemServico.getDescricao().getDescricao());
            stmt.setInt(2, mapper.paraIdStatus(ordemServico.getStatusOS()));
            stmt.setDouble(3, ordemServico.getValorOS().getValorOS());
            stmt.setLong(4, ordemServico.getIdMaquina());
            stmt.setLong(5, ordemServico.getIdSupervisor());
            stmt.setLong(6, ordemServico.getIdTecnico());
            stmt.setLong(7, ordemServico.getIdOs());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Ordem de Serviço atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma OS encontrada para atualizar com ID: " + ordemServico.getIdOs());
            }

        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar a Ordem de Serviços");
        }
    }

    @Override
    public OrdemDeServico buscarPorId(long idOS) {
        String querySQL = "SELECT * FROM OrdemServicos WHERE id_os = ?";
        OrdemDeServico os = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {

            stmt.setLong(1, idOS);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    os = montarOrdem(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("ERRO ao buscar OS com ID: " + idOS);
        }
        return os;
    }

    @Override
    public boolean existeId(long id) {
        String querySql = "SELECT * FROM OrdemServicos WHERE id_os = ? LIMIT 1";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySql)) {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Erro ao verificar ID da ordem de servico: " + id);
        }
        return false;
    }

    @Override
    public List<OrdemDeServico> listarOsAtivas() {
        String querySQL = "SELECT * FROM OrdemServicos WHERE status_ordem != 3";
        List<OrdemDeServico> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(montarOrdem(rs));
            }

        } catch (SQLException e) {
            System.err.println("ERRO ao listar OS ativas: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<OrdemDeServico> listarOsTodas() {
        String querySQL = "SELECT * FROM OrdemServicos";
        List<OrdemDeServico> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next())
            {
                lista.add(montarOrdem(rs));
            }

        } catch (SQLException e) {
            System.err.println("ERRO ao listar todas as OS: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public int numeroOrdensMaquina(long idMaquina) {
        String querySQL = "SELECT COUNT(*) FROM OrdemServicos WHERE id_maquina = ?";
        int total = 0;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {

            stmt.setLong(1, idMaquina);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    total = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("ERRO ao contar ordens da máquina ID " + idMaquina + ": " + e.getMessage());
        }
        return total;
    }

    private OrdemDeServico montarOrdem(ResultSet rs) throws SQLException {
        long id = rs.getLong("id_os");
        String descricao = rs.getString("descricao");
        int statusInt = rs.getInt("status_ordem");
        double custo = rs.getDouble("custo");
        long idMaquina = rs.getLong("id_maquina");
        long idTecnico = rs.getLong("id_tecnico");
        long idSupervisor = rs.getLong("id_supervisor");
        int idTipo = rs.getInt("id_tipoOS");
        int idDepartamento = rs.getInt("id_departamento");

        StatusOS status = mapper.mapearStatus(statusInt);
        TipoOS tipo = mapper.mapearTipo(idTipo);
        Departamento depto = mapper.mapearDepartamento(idDepartamento);

        return new OrdemDeServico(
                id,
                idTecnico,
                idSupervisor,
                idMaquina,
                status,
                new Descricao(descricao),
                new ValorOS(custo),
                depto,
                tipo
        );
    }
}


