package Aplicacao.Funcionario.Nucleo.Servicos;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutorizacaoException;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public class        AutorizacaoServico {
    public void validaAcessoAdmin(NivelAcesso nivelAcesso) {
        if (nivelAcesso != NivelAcesso.ADMIN) {
            throw new AutorizacaoException();
        }
    }

    public void validaAcessoGerente(NivelAcesso nivelAcesso) {
        if (nivelAcesso != NivelAcesso.GERENTE) {
            throw new AutorizacaoException();
        }
    }

    public void validaAcessoSupervisor(NivelAcesso nivelAcesso) {
        if (nivelAcesso != NivelAcesso.SUPERVISOR) {
            throw new AutorizacaoException();
        }
    }

    public void validaAcessoTecnico(NivelAcesso nivelAcesso) {
        if (nivelAcesso != NivelAcesso.TECNICO) {
            throw new AutorizacaoException();
        }
    }

    public void validaAcessoExcluir(NivelAcesso nivelAcesso) {
        if(nivelAcesso != NivelAcesso.ADMIN && nivelAcesso != NivelAcesso.GERENTE) {
            throw new AutorizacaoException();
        }
    }

    public void validaExclusaoAdm(boolean ehAdministrador) {
       if(ehAdministrador) {
           throw new AutorizacaoException();
       }
    }

    public void validaAcessoListarFuncionarios(NivelAcesso nivelAcesso) {
        if(nivelAcesso != NivelAcesso.ADMIN && nivelAcesso != NivelAcesso.GERENTE) {
            throw new AutorizacaoException();
        }
    }
}
