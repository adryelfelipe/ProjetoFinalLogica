package Aplicacao.OrdemDeServico.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;

public record CadastroOsResponse(Long idOs, boolean status, String mensagem) {
}
