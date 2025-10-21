public class GerenteModel extends UsuarioModel{

    // -- Atributos -- //
    private String departamento;

    // -- Construtor com ID -- //
    public GerenteModel(long id, String nome, String cpf, String senha, String departamento) {
        super(id, nome, cpf, senha, NivelAcesso.Gerente);
        setDepartamento(departamento);
    }

    // -- Construtor sem ID -- //
    public GerenteModel(String nome, String cpf, String senha, String departamento) {
        this(0, nome, cpf, senha, departamento);
    }

    // -- Setters e Getters -- //
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
