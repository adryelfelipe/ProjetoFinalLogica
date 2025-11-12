package Aplicacao.Funcionario.Tecnico.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;

public record CadastroTecnicoResponse(Long id, NomeFuncionario nome, boolean status, String mensagem) {
}
