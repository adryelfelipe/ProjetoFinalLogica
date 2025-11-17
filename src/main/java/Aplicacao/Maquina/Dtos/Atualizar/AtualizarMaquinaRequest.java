package Aplicacao.Maquina.Dtos.Atualizar;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;

public record AtualizarMaquinaRequest(long idMaquina, String nome, Departamento departamento, StatusMaquina status) {
}
