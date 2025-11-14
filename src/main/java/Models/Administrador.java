package Models;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.NivelAcesso;

import java.util.List;

public class Administrador extends Funcionario {

    // -- Construtor -- //
    public Administrador(long id, String nome, String cpf, String senha, List<Departamento> listaDepartamentos) {
        super(id, nome, cpf, senha, NivelAcesso.ADMIN, listaDepartamentos);
    }
}
