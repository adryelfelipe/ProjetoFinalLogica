package Dominio.Funcionario.Nucleo.Repositorios;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;

public interface FuncionarioQueriesRepositorio {
    boolean existeCpf(CPF cpf);
    boolean existeId(long id);
    Funcionario buscarPorID(long id);
    NivelAcesso nivelAcessoPorId(long id);
    Funcionario buscarPorCpf(CPF cpf);
}
