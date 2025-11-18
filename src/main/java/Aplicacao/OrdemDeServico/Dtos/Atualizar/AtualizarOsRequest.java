package Aplicacao.OrdemDeServico.Dtos.Atualizar;

import Dominio.OrdemDeServico.Enumeracoes.StatusOS;

public record AtualizarOsRequest(long idOs, String descricao, Double valorOs, StatusOS statusOS) {
}
