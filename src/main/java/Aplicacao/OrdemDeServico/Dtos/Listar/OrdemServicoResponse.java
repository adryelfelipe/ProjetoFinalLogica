package Aplicacao.OrdemDeServico.Dtos.Listar;

import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Dominio.OrdemDeServico.Enumeracoes.TipoOS;
import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;

public record OrdemServicoResponse(Long idOs, StatusOS statusOs, Descricao descricao, TipoOS tipoOs, ValorOS valorOs) {
}
