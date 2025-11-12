package Aplicacao.Funcionario.Supervisor.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;

import java.util.List;

public record CadastroSupervisorRequest(String nome, String cpf, String senha, List<Departamento> listaDepartamentos, double metaMensal) {
}
