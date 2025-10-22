public class TecnicoModel extends UsuarioModel{
    private String especialidade;

    // Construtor com ID //
    public TecnicoModel(long id, String nome, String cpf, String senha, String especialidade) {
        super(id, nome, cpf, senha, NivelAcesso.TECNICO);
        this.especialidade = especialidade;
    }

    // Construtor sem ID //
    public TecnicoModel(String nome, String cpf, String senha, String especialidade) {
        this(0, nome, cpf, senha, especialidade);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
