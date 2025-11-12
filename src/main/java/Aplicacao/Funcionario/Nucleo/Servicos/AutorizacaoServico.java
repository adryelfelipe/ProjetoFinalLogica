package Aplicacao.Funcionario.Nucleo.Servicos;

import Aplicacao.Funcionario.Nucleo.Exceptions.AutorizacaoException;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public class AutorizacaoServico {
    public void temAcessoAdmin(NivelAcesso nivelAcesso) {
        if (!(nivelAcesso == NivelAcesso.ADMIN)) {
            throw new AutorizacaoException("Acesso não liberado para esta operação");
        }
    }

    public void temAcessoGerente(NivelAcesso nivelAcesso) {
        if (!(nivelAcesso == NivelAcesso.GERENTE)) {
            throw new AutorizacaoException("Acesso não liberado para esta operação");
        }
    }

    public void temAcessoSupervisor(NivelAcesso nivelAcesso) {
        if (!(nivelAcesso == NivelAcesso.SUPERVISOR)) {
            throw new AutorizacaoException("Acesso não liberado para esta operação");
        }
    }

    public void temAcessoTecnico(NivelAcesso nivelAcesso) {
        if (!(nivelAcesso == NivelAcesso.TECNICO)) {
            throw new AutorizacaoException("Acesso não liberado para esta operação");
        }
    }
}
