package ProjetoBase;

public class TecnicoValidator {

    // -- Métodos de Regras de Negócio -- //
    public void verificaRegrasFormacao(String formacao) {
        if(formacao == null) {
            throw new IllegalStateException("ERRO! A FORMAÇÃO NÃO PODE SER NULA");
        }

        if(formacao.length() < 6) {
            throw new IllegalStateException("ERRO! A FORMAÇÃO DEVE CONTER MAIS DE 5 DÍGITOS");
        }
    }

    // -- Métodos de Integridade -- //
    public static void verificaIntegridadeFormacao(String formacao) {
        if(formacao.isBlank()) {
            throw new IllegalArgumentException("ERRO! FORMAÇÃO NÃO PODE SER VAZIA");
        }
    }
}
