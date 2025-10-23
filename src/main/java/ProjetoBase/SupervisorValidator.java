package ProjetoBase;

public class SupervisorValidator {

    // -- Verificações de Regras de Negócio -- //
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
