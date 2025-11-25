package Infraestrutura.Persistencia.Implementacao.Maquina.JDBC;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;
import Dominio.Maquina.Repositorios.MaquinaRepositorio;
import Infraestrutura.Configuracao.ConnectionFactory;
import Dominio.Maquina.Maquina;
import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Infraestrutura.Persistencia.Implementacao.Maquina.Mapper.MaquinaJdbcMapper;

import java.sql.*;
import java.util.List;

public class MaquinaJdbcRepositorio implements MaquinaRepositorio {
    // ---- Atributos ---- //
    private MaquinaJdbcMapper maquinaMapper;

    // ---- Construtor ---- //
    public MaquinaJdbcRepositorio(MaquinaJdbcMapper mapper) {
        this.maquinaMapper = mapper;
    }

    //Comando para inserir as informações da máquina no Banco de Dados
    @Override
    public void salvar(Maquina maquina) {
        String querySQL = "INSERT INTO Maquinas (nome, id_departamento, id_sm) VALUES (?, ?, ?)";
        long idGerado = -1;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS)) {
            //Definindo parametros (PreparedStatement).
            stmt.setString(1, maquina.getNome().getNome());
            stmt.setInt(2, maquina.getDepartamento().getId());
            stmt.setLong(3, maquina.getStatus().getId());

            int linhasAF = stmt.executeUpdate();

            if (linhasAF > 0) {
                // Pega as chaves geradas.
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getLong(1);
                        maquina.alteraIdMaquina(idGerado);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO INSERIR MÁQUINA");
        }
    }

    // Comando para excluir uma máquina existente do Banco de Dados caso necessário
    @Override
    public boolean excluir(long id) {
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
    @Override
    public void atualizar(Maquina maquina) {

        String querySQL = "UPDATE Maquinas SET nome = ?, id_departamento = ?, id_sm = ? WHERE id_maquina = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {

            stmt.setString(1, maquina.getNome().getNome());
            stmt.setInt(2, maquina.getDepartamento().getId());
            stmt.setInt(3, maquina.getStatus().getId());

            stmt.setLong(4, maquina.getIdMaquina());

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas > 0) {
                System.out.println("Máquina atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma máquina encontrada com o ID: ");
            }

        } catch (SQLException e) {
            System.err.println("ERRO ao atualizar a máquina: ");
        }
    }
    @Override
    public boolean existeId(long id) {
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


    @Override
    public Maquina buscar(long id) {
        return null;
    }

    @Override
    public List<Maquina> listaMaquinas() {
        return List.of();
    }

    @Override
    public Departamento maquinaParaDepartamento(long idMaquina) {
        return null;
    }

    @Override
    public NomeMaquina buscarNome(long idMaquina) {
        return null;
    }
}

