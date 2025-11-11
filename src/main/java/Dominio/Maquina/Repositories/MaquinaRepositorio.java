package Dominio.Maquina.Repositories;

import Dominio.Maquina.Maquina;

public interface MaquinaRepositorio {
    boolean existeId(long id);
    void salvar(Maquina maquina);
    void excluirPorId(long id);
    Maquina buscarPorId(long id);
    void atualizar(Maquina maquina);
}
