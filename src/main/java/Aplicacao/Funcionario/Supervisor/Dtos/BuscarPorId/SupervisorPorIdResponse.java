package Aplicacao.Funcionario.Supervisor.Dtos.BuscarPorId;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;

public record SupervisorPorIdResponse(long id, NomeFuncionario nome, CPF cpf, ListaDepartamentos listaDepartamentos,
                                      MetaMensal metaMensal, boolean status, String mensagem) {
}
