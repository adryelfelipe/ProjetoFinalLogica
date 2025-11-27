package Infraestrutura.Persistencia.Implementacao.OrdemDeServico.Mapper;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Dominio.OrdemDeServico.Enumeracoes.TipoOS;

public class OrdemDeServicoImplMapper
{
    // --- STATUS ---
    public StatusOS mapearStatus(int id) {
        return switch (id) {
            case 1 -> StatusOS.ABERTA;
            case 2 -> StatusOS.EM_ANDAMENTO;
            default -> StatusOS.FECHADA;
        };
    }

    public int paraIdStatus(StatusOS status) {
        return status.getId();
    }

    // --- TIPO ---
    public TipoOS mapearTipo(int id) {
        return switch (id) {
            case 1 -> TipoOS.CORRETIVA;
            default -> TipoOS.PREDITIVA;
        };
    }

    // ADICIONE ESTE:
    public int paraIdTipo(TipoOS tipo) {
        if (tipo == TipoOS.CORRETIVA) return 1;
        return 2;
    }

    // --- DEPARTAMENTO ---
    public Departamento mapearDepartamento(int id) {
        return switch (id) {
            case 1 -> Departamento.ELETRICA;
            default -> Departamento.MECANICA;
        };
    }

    // ADICIONE ESTE:
    public int paraIdDepartamento(Departamento departamento) {
        return departamento.getId();
    }
}