package Aplicacao.Funcionario.Nucleo.Exceptions;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(CPF cpf) {
        super("Usuario não encontrado pelo cpf: " + cpf.getCpf());
    }
}
