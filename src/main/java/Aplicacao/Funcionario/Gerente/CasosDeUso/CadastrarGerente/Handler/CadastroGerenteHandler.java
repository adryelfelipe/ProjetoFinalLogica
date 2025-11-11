package Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Handler;

import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Dtos.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Dtos.CadastroGerenteResponse;
import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Mapper.CadastroGerenteMapper;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;

public class CadastroGerenteHandler {
    // -- Atributos -- //
    private CadastroGerenteMapper cadastroGerenteMapper;
    private FuncionarioRepositorio funcionarioRepositorio;
    private FuncionarioServico funcionarioServico;

    // -- Construtor -- //
    public CadastroGerenteHandler(CadastroGerenteMapper cadastroGerenteMapper, FuncionarioRepositorio funcionarioRepositorio, FuncionarioServico funcionarioServico) {
        this.cadastroGerenteMapper = cadastroGerenteMapper;
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.funcionarioServico = funcionarioServico;
    }

    // -- Métodos -- //
    public CadastroGerenteResponse cadastrarGerente(CadastroGerenteRequest request) {
        try {
            Gerente gerente = cadastroGerenteMapper.paraEntidade(request);
            funcionarioServico.cpfUtilizado(gerente.getCpf());
            funcionarioServico.idUtilizado(gerente.getId());
            funcionarioRepositorio.salvar(gerente);
            return new CadastroGerenteResponse("Gerente cadastrado com sucesso!", gerente.getId());
        } catch (FuncionarioException e) {
            return new CadastroGerenteResponse(e.getMessage(), null);
        }
    }
}
