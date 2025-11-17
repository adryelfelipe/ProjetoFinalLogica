package Aplicacao.OrdemDeServico.Dtos.Listar;

import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Dominio.OrdemDeServico.Enumeracoes.TipoOS;
import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;

import java.util.List;

public record ListarOsResponse(List<OrdemServicoResponse> listaResponse) {
}
