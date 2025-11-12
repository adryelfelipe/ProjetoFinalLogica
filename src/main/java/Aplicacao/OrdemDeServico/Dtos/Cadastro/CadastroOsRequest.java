package Aplicacao.OrdemDeServico.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;

public record CadastroOsRequest(long idTecnico, long idSupervisor, long idMaquina, StatusOS statusOS, String descricao, double valorOS, Departamento departamento) {
}
