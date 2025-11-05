package Models;

import Models.joias.Especialidade;
import ProjetoBase.TecnicoValidator;

public class TecnicoModel extends UsuarioModel{
    private Especialidade especialidade;

    // Construtor com ID //
    public TecnicoModel(long id, String nome, String cpf, String senha, Especialidade especialidade) {
        super(id, nome, cpf, senha, 1);
        setEspecialidade(especialidade);
    }

    // Construtor sem ID //
    public TecnicoModel(String nome, String cpf, String senha, Especialidade especialidade) {
        this(0, nome, cpf, senha, especialidade);
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        TecnicoValidator.verificaIntegridadeEspecialidade(especialidade);
        this.especialidade = especialidade;
    }
}
