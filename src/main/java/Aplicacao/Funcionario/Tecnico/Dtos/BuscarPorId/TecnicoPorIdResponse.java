package Aplicacao.Funcionario.Tecnico.Dtos.BuscarPorId;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;

public record TecnicoPorIdResponse(long id, NomeFuncionario nome, CPF cpf, ListaDepartamentos listaDepartamentos,
                                   Especialidade especialidade, boolean status, String mensagem) {
}
