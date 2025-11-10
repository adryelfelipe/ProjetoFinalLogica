package Dominio.Funcionario.Funcionario.Repositorios;

import Dominio.Funcionario.Funcionario.Funcionario;

public interface FuncionarioRepositorio {
    void salvar(Funcionario funcionario);
    void atualizar(Funcionario funcionario);
    void excluirPorID(long id);
}
