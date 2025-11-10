package Dominio.Maquina.Repositories;

import Dominio.Maquina.Maquina;

public interface MaquinaRepositorio {
    boolean existeID(long id);
    void salvar();
    void excluirPorId();
    Maquina buscarPorId();
    void atualizar();
}
