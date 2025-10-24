package ProjetoBase;

public class SupervisorValidator {

    // -- Atributos -- //
    private final UsuarioValidator usuarioValidator;

    // -- Construtor -- //
    public SupervisorValidator(UsuarioValidator usuarioValidator) {
        this.usuarioValidator = usuarioValidator;
    }

    // -- Verificações de Regras de Negócio -- //
    public void verificarRegrasInsercaoSupervisor(SupervisorModel supervisor) {
        usuarioValidator.verificaRegrasInsercaoUsuario(supervisor);
        verificaIntegridadeMetaMensal(supervisor.getMetaMensal());
    }

    public void verificaRegrasMetaMensal(double mentaMensal) {
        if(mentaMensal < 50000) {
            throw new IllegalStateException("ERRO! A META MENSAL MÍNIMA É DE 50 MIL");
        }
    }

    // -- Verificações de Integridade -- //
    public void verificaIntegridadeMetaMensal(double mentaMensal) {
        if(mentaMensal < 0) {
            throw new IllegalArgumentException("ERRO! A META MENSAL NÃO PODE SER NEGATIVA");
        }
    }
}
