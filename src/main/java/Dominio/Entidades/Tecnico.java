package Dominio.Entidades;

import Dominio.Enumeracoes.Especialidade;
import Dominio.Enumeracoes.NivelAcesso;
import ProjetoBase.TecnicoValidator;

public class Tecnico extends Usuario {
    private Especialidade especialidade;

    // Construtor com ID //
    public Tecnico(long id, String nome, String cpf, String senha, Especialidade especialidade) {
        super(id, nome, cpf, senha, NivelAcesso.TECNICO);
        setEspecialidade(especialidade);
    }

    // Construtor sem ID //
    public Tecnico(String nome, String cpf, String senha, Especialidade especialidade) {
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
