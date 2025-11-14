package Models;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.Especialidade;
import Models.Enumeracoes.NivelAcesso;
import Service.Validator.TecnicoValidator;

import java.util.List;

public class Tecnico extends Funcionario {
    private Especialidade especialidade;

    // Construtor com ID //
    public Tecnico(long id, String nome, String cpf, String senha, Especialidade especialidade, List<Departamento> listaDepartamentos) {
        super(id, nome, cpf, senha, NivelAcesso.TECNICO, listaDepartamentos);
        setEspecialidade(especialidade);
    }

    // Construtor sem ID //
    public Tecnico(String nome, String cpf, String senha, Especialidade especialidade, List<Departamento> listaDepartamentos) {
        this(0, nome, cpf, senha, especialidade, listaDepartamentos);
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        TecnicoValidator.verificaIntegridadeEspecialidade(especialidade);
        this.especialidade = especialidade;
    }
}
