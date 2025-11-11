package Aplicacao.Funcionario.Nucleo.Handler;

import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Exceptions.UsuarioNaoEncontradoException;
import Aplicacao.Funcionario.Nucleo.Mapper.FuncionarioMapper;
import Dominio.Funcionario.Nucleo.Exceptions.CpfInvalidoException;
import Dominio.Funcionario.Nucleo.Exceptions.SenhaInvalidaException;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioQueriesRepositorio;

public class FuncionarioHandler {
    // -- Atributos -- //
    private FuncionarioQueriesRepositorio funcionarioQueriesRepositorio;
    private FuncionarioMapper funcionarioMapper;

    // -- Construtor -- //
    public FuncionarioHandler(FuncionarioQueriesRepositorio funcionarioQueriesRepositorio, FuncionarioMapper funcionarioMapper) {
        this.funcionarioQueriesRepositorio = funcionarioQueriesRepositorio;
        this.funcionarioMapper = funcionarioMapper;
    }

    // -- Métodos -- //
    public LoginFuncionarioResponse login(LoginFuncionarioRequest request) {
        try {
            CPF cpf = new CPF(request.cpf());
            Senha senha = new Senha(request.senha());
            Funcionario funcionario = funcionarioQueriesRepositorio.buscarPorCpf(cpf);

            if(funcionario == null) {
                return funcionarioMapper.paraLoginResponse("Cpf ou senha inválidos");
            }

            if(!funcionario.igualMinhaSenha(senha)) {
                return funcionarioMapper.paraLoginResponse("Cpf ou senha inválidos");
            }

            return funcionarioMapper.paraLoginResponse(funcionario);
        } catch (CpfInvalidoException | SenhaInvalidaException e) {
            return funcionarioMapper.paraLoginResponse(e.getMessage());
        }
    }
}
