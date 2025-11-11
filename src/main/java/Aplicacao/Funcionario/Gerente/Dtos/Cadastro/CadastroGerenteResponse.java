package Aplicacao.Funcionario.Gerente.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;

public record CadastroGerenteResponse(long id, NomeFuncionario nome,boolean status, String mensagem) {
}
