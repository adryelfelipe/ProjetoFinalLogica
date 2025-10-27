package ProjetoBase;

public class SupervisorValidator {

    // -- Atributos -- //
    private static final UsuarioValidator usuarioValidator = new UsuarioValidator();

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
    public static void verificaIntegridadeMetaMensal(double mentaMensal) {
        if(mentaMensal < 0) {
            throw new IllegalArgumentException("ERRO! A META MENSAL NÃO PODE SER NEGATIVA");
        }
    }
}
