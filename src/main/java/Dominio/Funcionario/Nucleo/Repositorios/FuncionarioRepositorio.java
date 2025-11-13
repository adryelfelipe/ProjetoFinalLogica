package Dominio.Funcionario.Nucleo.Repositorios;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;

import java.util.List;

public interface FuncionarioRepositorio {
    void salvar(Funcionario funcionario);
    void atualizar(Funcionario funcionario);
    boolean excluir(long id);
    boolean existeCpf(CPF cpf);
    boolean existeId(long id);
    Funcionario buscar(long id);
    NivelAcesso nivelAcessoPorID(long id);
    Funcionario buscar(CPF cpf);
    List<Funcionario> listarFuncionarios();
}
