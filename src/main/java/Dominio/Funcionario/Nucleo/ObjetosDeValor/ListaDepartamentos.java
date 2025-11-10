package Dominio.Funcionario.Nucleo.ObjetosDeValor;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Exceptions.DepartamentoFuncionarioException;
import java.util.List;

public final class ListaDepartamentos {
    private final List<Departamento> listaDepartamentos;

    public ListaDepartamentos(List<Departamento> listaDepartamentos) {
        validaListaDepartamento(listaDepartamentos);
        this.listaDepartamentos = listaDepartamentos;
    }

    private void validaListaDepartamento(List<Departamento> listaDepartamentos) {
        if(listaDepartamentos.isEmpty()) {
            throw new DepartamentoFuncionarioException("Uma lista de departamentos não pode ser vazia");
        }
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }
}
