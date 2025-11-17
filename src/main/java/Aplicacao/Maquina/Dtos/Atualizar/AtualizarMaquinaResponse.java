package Aplicacao.Maquina.Dtos.Atualizar;

import Dominio.Maquina.ObjetosDeValor.NomeMaquina;

public record AtualizarMaquinaResponse(Long id, boolean status, String mensagem) {
}
