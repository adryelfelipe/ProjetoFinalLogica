package Aplicacao.Funcionario.Nucleo.Dtos.Login;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public record LoginFuncionarioResponse(Long id, NivelAcesso nivelAcesso, String mensagem, boolean operacao) {
}
