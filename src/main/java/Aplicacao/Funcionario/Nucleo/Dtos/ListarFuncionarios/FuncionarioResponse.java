package Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;

public record FuncionarioResponse(long id, NomeFuncionario nome, NivelAcesso nivelAcesso) {
}
