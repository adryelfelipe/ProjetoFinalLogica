package Dominio.Funcionario.Funcionario.ObjetosDeValor;

import Dominio.Funcionario.Funcionario.Enumeracoes.Departamento;
import Dominio.Funcionario.Funcionario.Exceptions.DepartamentoException;
import java.util.List;

public final class ListaDepartamentos {
    private final List<Departamento> listaDepartamentos;

    public ListaDepartamentos(List<Departamento> listaDepartamentos) {
        validaListaDepartamento(listaDepartamentos);
        this.listaDepartamentos = listaDepartamentos;
    }

    private void validaListaDepartamento(List<Departamento> listaDepartamentos) {
        if(listaDepartamentos.isEmpty()) {
            throw new DepartamentoException("Uma lista de departamentos não pode ser vazia");
        }
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }
}
