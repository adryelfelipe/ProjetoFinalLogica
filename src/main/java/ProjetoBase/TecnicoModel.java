package ProjetoBase;

public class TecnicoModel extends UsuarioModel{
    private int especialidade;

    // Construtor com ID //
    public TecnicoModel(long id, String nome, String cpf, String senha, int especialidade) {
        super(id, nome, cpf, senha, NivelAcesso.TECNICO);
        this.especialidade = especialidade;
    }

    // Construtor sem ID //
    public TecnicoModel(String nome, String cpf, String senha, int especialidade) {
        this(0, nome, cpf, senha, especialidade);
    }

    public int getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(int especialidade) {
        this.especialidade = especialidade;
    }
}
