package Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Handler;

import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Dtos.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Dtos.CadastroGerenteResponse;
import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Mapper.CadastroGerenteMapper;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;

public class CadastroGerenteHandler {
    // -- Atributos -- //
    private CadastroGerenteMapper cadastroGerenteMapper;
    private FuncionarioRepositorio funcionarioRepositorio;

    // -- Construtor -- //
    public CadastroGerenteHandler(CadastroGerenteMapper cadastroGerenteMapper, FuncionarioRepositorio funcionarioRepositorio) {
        this.cadastroGerenteMapper = cadastroGerenteMapper;
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    // -- Métodos -- //
    public CadastroGerenteResponse cadastrarGerente(CadastroGerenteRequest request) {
        try {
            Gerente gerente = cadastroGerenteMapper.paraEntidade(request);
            funcionarioRepositorio.salvar(gerente);
            return new CadastroGerenteResponse("Gerente cadastrado com sucesso!", gerente.getId());
        } catch (FuncionarioException e) {
            return new CadastroGerenteResponse(e.getMessage(), null);
        }
    }
}
