package Aplicacao.Maquina.Dtos.Cadastro;

import Dominio.Maquina.Enumeracoes.StatusMaquina;

public record CadastroMaquinaRequest(String nome, String localizacao, StatusMaquina status) {
}
