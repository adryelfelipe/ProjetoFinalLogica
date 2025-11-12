package Aplicacao.Funcionario.Gerente.Handler;

import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteResponse;
import Aplicacao.Funcionario.Gerente.Mapper.GerenteMapper;
import Aplicacao.Funcionario.Nucleo.Exceptions.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;

public class GerenteHandler {
    // -- Atributos -- //
    private GerenteMapper gerenteMapper;
    private FuncionarioRepositorio funcionarioRepositorio;
    private FuncionarioServico funcionarioServico;
    private AutorizacaoServico autorizacaoServico;

    // -- Construtor -- //
    public GerenteHandler(GerenteMapper gerenteMapper, FuncionarioRepositorio funcionarioRepositorio, FuncionarioServico funcionarioServico, AutorizacaoServico autorizacaoServico) {
        this.gerenteMapper = gerenteMapper;
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.funcionarioServico = funcionarioServico;
        this.autorizacaoServico = autorizacaoServico;
    }

    // -- Métodos -- //
    public CadastroGerenteResponse cadastrar(NivelAcesso nivelAcesso, CadastroGerenteRequest request) {
        try {
            autorizacaoServico.temAcessoAdmin(nivelAcesso);
            Gerente gerente = gerenteMapper.paraEntidade(request);
            funcionarioServico.cpfUtilizado(gerente.getCpf());
            funcionarioServico.idUtilizado(gerente.getId());
            funcionarioRepositorio.salvar(gerente);
            return gerenteMapper.paraResponseCadastro(gerente);
        } catch (AutorizacaoException | FuncionarioException e) {
            return gerenteMapper.paraResponseCadastro(e.getMessage());
        }
    }
}
