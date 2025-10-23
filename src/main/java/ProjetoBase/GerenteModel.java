package ProjetoBase;

public class GerenteModel extends UsuarioModel{

    // -- Atributos -- //
    private int idDepartamento;

    // -- Construtor com ID -- //
    public GerenteModel(long id, String nome, String cpf, String senha, int idDepartamento) {
        super(id, nome, cpf, senha, NivelAcesso.GERENTE);
        setDepartamento(idDepartamento);
    }

    // -- Construtor sem ID -- //
    public GerenteModel(String nome, String cpf, String senha, int idDepartamento) {
        this(0, nome, cpf, senha, idDepartamento);
    }

    // -- Setters e Getters -- //
    public int getDepartamento() {
        return idDepartamento;
    }

    public void setDepartamento(int departamento) {
        this.idDepartamento = departamento;
    }
}
