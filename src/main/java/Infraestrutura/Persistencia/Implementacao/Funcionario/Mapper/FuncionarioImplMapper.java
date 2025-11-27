package Infraestrutura.Persistencia.Implementacao.Funcionario.Mapper;

import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Dominio.Funcionario.Tecnico.Tecnico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioImplMapper
{

    public Funcionario paraEntidadePorId(ResultSet rs, Connection conn) throws SQLException {

        long id = rs.getLong("id_usuario");
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        String senha = rs.getString("senha");
        int nivelAcesso = rs.getInt("id_na");

        ListaDepartamentos listaDepartamentos = paraDepartamentosPorId(conn, id);

        switch(nivelAcesso)
        {
            case 1:
                int idEspecialidade = rs.getInt("id_especialidade");
                Especialidade especialidade = switch(idEspecialidade) {
                    case 1 -> Especialidade.TECNICO_ELETROTECNICA;
                    case 2 -> Especialidade.ELETRICISTA_FABRIL;
                    case 3 -> Especialidade.SOLDADOR;
                    case 4 -> Especialidade.TECNICO_ELETROMECANICA;
                    default -> Especialidade.PINTOR_INDUSTRIAL;
                };

                return new Tecnico(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha),
                        listaDepartamentos, especialidade);

            case 2: // SUPERVISOR
                double metaMensal = rs.getDouble("meta_mensal");

                return new Supervisor(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha),
                        listaDepartamentos, new MetaMensal(metaMensal));

            case 3: // GERENTE

                return new Gerente(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha),
                        listaDepartamentos);

            case 4: // ADMIN
                return new Administrador(id, new NomeFuncionario(nome), new CPF(cpf), new Senha(senha),
                        listaDepartamentos);
        }

        return null;
    }

    public NivelAcesso paraNivelAcesso(ResultSet rs) throws SQLException {
        int nivelAcesso = rs.getInt("id_na");

        return switch(nivelAcesso) {
            case 1 -> NivelAcesso.TECNICO;
            case 2 -> NivelAcesso.SUPERVISOR;
            case 3 -> NivelAcesso.GERENTE;
            default -> NivelAcesso.ADMIN;
        };
    }

    public Funcionario paraEntidadePorCpf(ResultSet rs, Connection conn) throws SQLException{
        long id = rs.getLong("id_usuario");
        String nome = rs.getString("nome");
        String cpfUsuario = rs.getString("cpf");
        String senha = rs.getString("senha");
        int nivelAcesso = rs.getInt("id_na");

        ListaDepartamentos listaDepartamentos = paraDepartamentosPorId(conn, id);

        return switch (nivelAcesso) {
            case 1 -> { // Técnico
                int idEspecialidade = rs.getInt("id_especialidade");
                Especialidade especialidade = switch (idEspecialidade) {
                    case 1 -> Especialidade.TECNICO_ELETROTECNICA;
                    case 2 -> Especialidade.ELETRICISTA_FABRIL;
                    case 3 -> Especialidade.SOLDADOR;
                    case 4 -> Especialidade.TECNICO_ELETROMECANICA;
                    default -> Especialidade.PINTOR_INDUSTRIAL;
                };

                yield new Tecnico(id, new NomeFuncionario(nome),
                        new CPF(cpfUsuario),
                        new Senha(senha),
                        listaDepartamentos,
                        especialidade);
            }

            case 2 -> { // Supervisor
                double metaMensal = rs.getDouble("meta_mensal");
                yield new Supervisor(id,
                        new NomeFuncionario(nome),
                        new CPF(cpfUsuario),
                        new Senha(senha),
                        listaDepartamentos,
                        new MetaMensal(metaMensal));
            }

            case 3 -> // Gerente
                    new Gerente(id,
                            new NomeFuncionario(nome),
                            new CPF(cpfUsuario),
                            new Senha(senha),
                            listaDepartamentos);

            case 4 -> // Administrador
                    new Administrador(id,
                            new NomeFuncionario(nome),
                            new CPF(cpfUsuario),
                            new Senha(senha),
                            listaDepartamentos);

            default -> throw new IllegalArgumentException("Nível de acesso desconhecido: " + nivelAcesso);
        };
    }

    public ListaDepartamentos paraDepartamentosPorId(Connection conn, long idUsuario) throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();

        String sql = "SELECT id_departamento FROM UsuarioDepartamento WHERE id_usuario = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idDepartamento = rs.getInt("id_departamento");

                    Departamento departamento = switch (idDepartamento) {
                        case 1 -> Departamento.ELETRICA;
                        default -> Departamento.MECANICA;
                    };

                    departamentos.add(departamento);
                }
            }
        }

        return new ListaDepartamentos(departamentos);
    }


    public String buscarNomePorId(long id, Connection conn) {
        String sql = "SELECT nome FROM Usuario WHERE id_usuario = ?";
        String nome = "Desconhecido"; // Valor padrão caso não ache

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nome = rs.getString("nome");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar nome do funcionário ID " + id);
        }
        return nome;
    }
    public long paraIdPorNome(Connection conn, String nomeFuncionario) throws SQLException {
        String sql = "SELECT id_usuario FROM Usuario WHERE nome = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeFuncionario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong("id_usuario");
                }
            }
        }
        return 0L;
    }
}
