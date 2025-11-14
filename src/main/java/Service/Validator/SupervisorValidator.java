package Service.Validator;

import Models.Supervisor;

public class SupervisorValidator {
    // -- Verificações de Regras de Negócio -- //
    public static void verificarRegrasInsercaoSupervisor(Supervisor supervisor) {
        UsuarioValidator.verificaRegrasInsercaoUsuario(supervisor);
        verificaIntegridadeMetaMensal(supervisor.getMetaMensal());
    }

    public static void verificaRegrasMetaMensal(double mentaMensal) {
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
