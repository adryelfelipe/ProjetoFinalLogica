package Aplicacao.Funcionario.Gerente.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;

public record CadastroGerenteResponse(Long id, NomeFuncionario nome,boolean status, String mensagem) {
}
