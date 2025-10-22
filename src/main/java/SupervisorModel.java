public class SupervisorModel extends UsuarioModel{

    // -- Atributos -- /
    private double metaMensal;

    // Construtor com ID //
    public SupervisorModel( long id, String nome, String cpf, String senha, double metaMensal) {
        super(id,nome, cpf, senha, NivelAcesso.SUPERVISOR);
        setMetaMensal(metaMensal);
    }

    // Construtor sem ID //
    public SupervisorModel(String nome, String cpf, String senha, double metaMensal) {
        this(0,nome,cpf,senha,metaMensal);
    }

    // -- Setters e Getters -- //
    public double getMetaMensal() {
        return metaMensal;
    }

    public void setMetaMensal(double metaMensal) {
        this.metaMensal = metaMensal;
    }
}
