package Infraestrutura.Persistencia.Implementacao.OrdemDeServico.JDBC;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Dominio.OrdemDeServico.Enumeracoes.TipoOS;
import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;
import Dominio.OrdemDeServico.OrdemDeServico;
import Dominio.OrdemDeServico.Repositorios.OrdemDeServicoRepositorio;
import Infraestrutura.Configuracao.ConnectionFactory;
import Infraestrutura.Persistencia.Implementacao.OrdemDeServico.Mapper.OrdemDeServicoImplMapper;
import Infraestrutura.Persistencia.Implementacao.Maquina.Mapper.MaquinaImplMapper;
import Infraestrutura.Persistencia.Implementacao.Funcionario.Mapper.FuncionarioImplMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoRepositorioImpl implements OrdemDeServicoRepositorio {

    private final OrdemDeServicoImplMapper mapper;
    private final MaquinaImplMapper maquinaMapper = new MaquinaImplMapper();
    private final FuncionarioImplMapper funcionarioMapper = new FuncionarioImplMapper();

    public OrdemServicoRepositorioImpl(OrdemDeServicoImplMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void salvar(OrdemDeServico ordemDeServico) {

        String sqlAtiva = "INSERT INTO OrdemServicos (descricao, statusOS, valorOS, id_tipoOS, id_maquina, id_tecnico, id_supervisor, id_departamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlGeral = "INSERT INTO OrdemDeServicosGerais (descricao, statusOS, valorOS, id_tipoOS, nome_maquina, nome_tecnico, nome_supervisor, id_departamento, id_os_referencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection()) {

            try (PreparedStatement stmt = conn.prepareStatement(sqlAtiva, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, ordemDeServico.getDescricao().getDescricao());
                stmt.setInt(2, mapper.paraIdStatus(ordemDeServico.getStatusOS()));
                stmt.setDouble(3, ordemDeServico.getValorOS().getValorOS());
                stmt.setInt(4, mapper.paraIdTipo(ordemDeServico.getTipoOS()));
                stmt.setLong(5, ordemDeServico.getIdMaquina());
                stmt.setLong(6, ordemDeServico.getIdTecnico());
                stmt.setLong(7, ordemDeServico.getIdSupervisor());
                stmt.setInt(8, mapper.paraIdDepartamento(ordemDeServico.getDepartamento()));

                int linhasAF = stmt.executeUpdate();

                if (linhasAF > 0) {
                    try (ResultSet rs = stmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            ordemDeServico.alteraIdOS(rs.getLong(1));
                        }
                    }
                }
            }

            try (PreparedStatement stmt = conn.prepareStatement(sqlGeral)) {
                String nomeMaquina = maquinaMapper.paraNomePorId(conn, ordemDeServico.getIdMaquina());
                String nomeTecnico = funcionarioMapper.buscarNomePorId(ordemDeServico.getIdTecnico(), conn );
                String nomeSupervisor = funcionarioMapper.buscarNomePorId(ordemDeServico.getIdSupervisor(), conn );

                stmt.setString(1, ordemDeServico.getDescricao().getDescricao());
                stmt.setInt(2, mapper.paraIdStatus(ordemDeServico.getStatusOS()));
                stmt.setDouble(3, ordemDeServico.getValorOS().getValorOS());
                stmt.setInt(4, mapper.paraIdTipo(ordemDeServico.getTipoOS()));
                stmt.setString(5, nomeMaquina);
                stmt.setString(6, nomeTecnico);
                stmt.setString(7, nomeSupervisor);
                stmt.setInt(8, mapper.paraIdDepartamento(ordemDeServico.getDepartamento()));

                stmt.setLong(9, ordemDeServico.getIdOs());

                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println("ERRO AO SALVAR ORDEM DE SERVIÇO: " + e.getMessage());
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

        String sqlAtiva = "UPDATE OrdemServicos SET " +
                "descricao = ?, " +
                "statusOS = ?, " +
                "valorOS = ?, " +
                "id_tipoOS = ?, " +
                "id_maquina = ?, " +
                "id_tecnico = ?, " +
                "id_supervisor = ?, " +
                "id_departamento = ? " +
                "WHERE id_os = ?";

        String sqlGeral = "UPDATE OrdemDeServicosGerais SET " +
                "descricao = ?, " +
                "statusOS = ?, " +
                "valorOS = ?, " +
                "id_tipoOS = ?, " +
                "nome_maquina = ?, " +
                "nome_tecnico = ?, " +
                "nome_supervisor = ?, " +
                "id_departamento = ? " +
                "WHERE id_os_referencia = ?";

        try (Connection conn = ConnectionFactory.getConnection()) {

            try (PreparedStatement stmt = conn.prepareStatement(sqlAtiva)) {
                stmt.setString(1, ordemServico.getDescricao().getDescricao());
                stmt.setInt(2, mapper.paraIdStatus(ordemServico.getStatusOS()));
                stmt.setDouble(3, ordemServico.getValorOS().getValorOS());
                stmt.setInt(4, mapper.paraIdTipo(ordemServico.getTipoOS()));
                stmt.setLong(5, ordemServico.getIdMaquina());
                stmt.setLong(6, ordemServico.getIdTecnico());
                stmt.setLong(7, ordemServico.getIdSupervisor());
                stmt.setInt(8, mapper.paraIdDepartamento(ordemServico.getDepartamento()));
                stmt.setLong(9, ordemServico.getIdOs());

                stmt.executeUpdate();
            }

            try (PreparedStatement stmt = conn.prepareStatement(sqlGeral)) {
                String nomeMaquina = maquinaMapper.paraNomePorId(conn, ordemServico.getIdMaquina());
                String nomeTecnico = funcionarioMapper.buscarNomePorId(ordemServico.getIdTecnico(), conn);
                String nomeSupervisor = funcionarioMapper.buscarNomePorId(ordemServico.getIdSupervisor(), conn);

                stmt.setString(1, ordemServico.getDescricao().getDescricao());
                stmt.setInt(2, mapper.paraIdStatus(ordemServico.getStatusOS()));
                stmt.setDouble(3, ordemServico.getValorOS().getValorOS());
                stmt.setInt(4, mapper.paraIdTipo(ordemServico.getTipoOS()));
                stmt.setString(5, nomeMaquina);
                stmt.setString(6, nomeTecnico);
                stmt.setString(7, nomeSupervisor);
                stmt.setInt(8, mapper.paraIdDepartamento(ordemServico.getDepartamento()));

                stmt.setLong(9, ordemServico.getIdOs());

                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar Ordem de Serviço (Ativa e Geral): " + e.getMessage());
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
        String querySQL = "SELECT * FROM OrdemServicos WHERE statusOS != 3";
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
        int statusInt = rs.getInt("statusOS");
        double custo = rs.getDouble("valorOS");
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