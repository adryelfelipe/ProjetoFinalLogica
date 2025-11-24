package Dominio.Maquina.Repositorios;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.Maquina;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;

import java.util.List;

public interface MaquinaRepositorio {
    boolean existeId(long idMaquina);
    void salvar(Maquina maquina);
    boolean excluir(long id);
    Maquina buscar(long id);
    void atualizar(Maquina maquina);
    List<Maquina> listaMaquinas();
    Departamento maquinaParaDepartamento(long idMaquina);
    NomeMaquina buscarNome(long idMaquina);
}
