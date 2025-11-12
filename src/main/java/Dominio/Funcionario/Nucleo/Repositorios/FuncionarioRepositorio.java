package Dominio.Funcionario.Nucleo.Repositorios;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;

public interface FuncionarioRepositorio {
    void salvar(Funcionario funcionario);
    void atualizar(Funcionario funcionario);
    void excluirPorId(long id);
    boolean existeCpf(CPF cpf);
    boolean existeId(long id);
    Funcionario buscarPorId(long id);
    NivelAcesso nivelAcessoPorID(long id);
    Funcionario buscarPorCpf(CPF cpf);
}
