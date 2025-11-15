package Aplicacao.Maquina.Dtos.Exclusao;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public record ExcluirMaquinaRequest(NivelAcesso nivelAcesso, long idMaquina) {
}
