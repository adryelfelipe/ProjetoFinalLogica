package Dominio.Maquina.Servicos;

import Dominio.Maquina.Exceptions.IdMaquinaException;
import Dominio.Maquina.Repositories.MaquinaRepositorio;

public class MaquinaServico {
    // -- Atributos -- //
    private final MaquinaRepositorio maquinaRepositorio;

    // -- Construtor -- //
    public MaquinaServico(MaquinaRepositorio maquinaRepositorio) {
        this.maquinaRepositorio = maquinaRepositorio;
    }

    // -- Métodos -- //
    public void idUtilizado(long idMaquina) {
        if(maquinaRepositorio.existeId(idMaquina)) {
            throw new IdMaquinaException("O ID da máquina informado já foi utilizado");
        }
    }
}
