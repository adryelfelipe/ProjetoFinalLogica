package DAO;

import Models.*;
import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.Especialidade;
import Models.Enumeracoes.NivelAcesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuncionarioDaoMapper {
    public Funcionario paraEntidadePorId(ResultSet rs) throws SQLException {
        // Pega dados comuns...
        long id = rs.getLong("id_usuario");
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        String senha = rs.getString("senha");
        int nivelAcesso = rs.getInt("id_na");

        switch(nivelAcesso)
        {
            case 1:
                // Criando objeto de acordo com seu nivel_acesso.
                int idEspecialidade = rs.getInt("id_especialidade");

                Especialidade especialidade = switch(idEspecialidade) {
                    case 1 -> Especialidade.TECNICO_ELETROTECNICA;
                    case 2 -> Especialidade.ELETRICISTA_FABRIL;
                    case 3 -> Especialidade.SOLDADOR;
                    case 4 -> Especialidade.TECNICO_ELETROMECANICA;
                    default -> Especialidade.PINTOR_INDUSTRIAL;
                };
                int idDepartamentoTe = rs.getInt("id_departamento");

                Departamento departamentoTe = switch (idDepartamentoTe) {
                    case 1 -> Departamento.ELETRICA;
                    default -> Departamento.MECANICA;
                };

                return new Tecnico(id, nome, cpf, senha, especialidade, Arrays.asList(departamentoTe));

            case 2:
                int idDepartamentoSs = rs.getInt("id_departamento");

                Departamento departamentoSs = switch (idDepartamentoSs) {
                    case 1 -> Departamento.ELETRICA;
                    default -> Departamento.MECANICA;
                };
                double metaMensal = rs.getDouble("meta_mensal");
                return new Supervisor(id, nome, cpf, senha,metaMensal, Arrays.asList(departamentoSs));

            case 3:
                int idDepartamento = rs.getInt("id_departamento");

                Departamento departamento = switch (idDepartamento) {
                    case 1 -> Departamento.ELETRICA;
                    default -> Departamento.MECANICA;
                };

                return new Gerente(id, nome, cpf, senha, Arrays.asList(departamento));

            case 4:
                int idDepartamentoAd = rs.getInt("id_departamento");

                Departamento departamentoAd = switch (idDepartamentoAd) {
                    case 1 -> Departamento.ELETRICA;
                    default -> Departamento.MECANICA;
                };
                return new Administrador(id, nome, cpf, senha, Arrays.asList(departamentoAd));
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

        List<Departamento> listaDepartamentos = paraDepartamentosPorId(conn, id);

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

                yield new Tecnico(id, nome, cpfUsuario, senha, especialidade, listaDepartamentos);
            }

            case 2 -> { // Supervisor
                double metaMensal = rs.getDouble("meta_mensal");
                yield new Supervisor(id, nome, cpfUsuario, senha, metaMensal, listaDepartamentos);
            }

            case 3 -> // Gerente
                    new Gerente(id, nome, cpfUsuario, senha, listaDepartamentos);
            case 4 -> // Administrador
                    new Administrador(id, nome, cpfUsuario, senha, listaDepartamentos);

            default -> throw new IllegalArgumentException("Nível de acesso desconhecido: " + nivelAcesso);
        };
    }

    private List<Departamento> paraDepartamentosPorId(Connection conn, long idUsuario) throws SQLException {
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

        return departamentos;
    }
}
