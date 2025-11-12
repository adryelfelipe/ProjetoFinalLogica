package Aplicacao.Maquina.Dtos.Cadastro;

import Dominio.Maquina.ObjetosDeValor.NomeMaquina;

public record CadastroMaquinaResponse(Long id, NomeMaquina nome, boolean status, String mensagem) {
}
