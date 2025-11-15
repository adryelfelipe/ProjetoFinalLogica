package Aplicacao.Maquina.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaRequest;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaResponse;
import Aplicacao.Maquina.Dtos.Listar.ListaMaquinasResponse;
import Aplicacao.Maquina.Mapper.MaquinaMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Maquina.Exceptions.MaquinaException;
import Dominio.Maquina.Maquina;
import Dominio.Maquina.Repositorios.MaquinaRepositorio;
import Dominio.Maquina.Servicos.MaquinaServico;

public class MaquinaHandler {

    // -- Atributos -- //
    private MaquinaServico maquinaServico;
    private MaquinaMapper maquinaMapper;
    private AutorizacaoServico autorizacaoServico;
    private MaquinaRepositorio maquinaRepositorio;

    // -- Construtor -- //
    public MaquinaHandler(MaquinaServico maquinaServico, MaquinaMapper maquinaMapper, AutorizacaoServico autorizacaoServico, MaquinaRepositorio maquinaRepositorio) {
        this.maquinaServico = maquinaServico;
        this.maquinaMapper = maquinaMapper;
        this.autorizacaoServico = autorizacaoServico;
        this.maquinaRepositorio = maquinaRepositorio;
    }

    // -- Métodos -- //
    public CadastroMaquinaResponse salvar(NivelAcesso nivelAcesso, CadastroMaquinaRequest request) {
        try {
            autorizacaoServico.validaAcessoGerente(nivelAcesso);
            Maquina maquina = maquinaMapper.paraEntidade(request);
            maquinaServico.idUtilizado(maquina.getIdMaquina());
            maquinaRepositorio.salvar(maquina);
            return maquinaMapper.paraResponseCadastro(maquina);
        } catch (AutorizacaoException | MaquinaException e) {
            return maquinaMapper.paraResponseCadastro(e.getMessage());
        }
    }

    public ListaMaquinasResponse listarMaquinas(NivelAcesso nivelAcesso) {
        try {
            autorizacaoServico.validaAcessoSupervisor(nivelAcesso);
            return maquinaMapper.paraListaResponse(maquinaRepositorio.listaMaquinas());
        } catch (AutorizacaoException e) {
            return maquinaMapper.paraListaResponse(e.getMessage());
        }
    }

    public
}
