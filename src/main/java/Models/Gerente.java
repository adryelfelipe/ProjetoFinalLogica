package Models;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.NivelAcesso;

import java.util.List;

public class Gerente extends Funcionario {
    // -- Construtor com ID -- //
    public Gerente(long id, String nome, String cpf, String senha, List<Departamento> listaDepartamentos) {
        super(id, nome, cpf, senha, NivelAcesso.GERENTE, listaDepartamentos);
    }

    // -- Construtor sem ID -- //
    public Gerente(String nome, String cpf, String senha, List<Departamento> listaDepartamentos) {
        this(0, nome, cpf, senha, listaDepartamentos);
    }
}
