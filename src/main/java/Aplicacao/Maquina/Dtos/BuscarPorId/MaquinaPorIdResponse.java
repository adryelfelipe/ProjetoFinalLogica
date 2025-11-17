package Aplicacao.Maquina.Dtos.BuscarPorId;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;

public record MaquinaPorIdResponse(Long id, NomeMaquina nomeMaquina, StatusMaquina statusMaquina, Departamento departamento, boolean status, String mensagem) {
}
