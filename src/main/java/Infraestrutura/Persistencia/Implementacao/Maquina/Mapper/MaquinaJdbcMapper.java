package Infraestrutura.Persistencia.Implementacao.Maquina.Mapper;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.Enumeracoes.StatusMaquina;

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
}
