package Dominio.Maquina.Repositorios;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.Maquina;

import java.util.List;

public interface MaquinaRepositorio {
    boolean existeId(long id);
    void salvar(Maquina maquina);
    void excluir(long id);
    Maquina buscar(long id);
    void atualizar(Maquina maquina);
    List<Maquina> listaMaquinas();
    Departamento maquinaParaDepartamento(long idMaquina);
}
