package Dominio.Funcionario.Funcionario.Repositorios;

import Dominio.Funcionario.Funcionario.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Funcionario.Funcionario;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.CPF;

import java.util.Optional;

public interface FuncionarioQueriesRepositorio {
    boolean existeCpf(CPF cpf);
    boolean existeID(long id);
    Funcionario buscarPorID(long id);
    NivelAcesso nivelAcessoPorId(long id);
}
