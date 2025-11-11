package Dominio.Funcionario.Nucleo.Repositorios;

import Dominio.Funcionario.Nucleo.Funcionario;

public interface FuncionarioRepositorio {
    void salvar(Funcionario funcionario);
    void atualizar(Funcionario funcionario);
    void excluirPorId(long id);
}
