package Aplicacao.Funcionario.Tecnico.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;

public record CadastroTecnicoResponse(long id, NomeFuncionario nome, boolean status, String mensagem) {
}
