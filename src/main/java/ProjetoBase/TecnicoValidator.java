package ProjetoBase;

public class TecnicoValidator {

    // -- Métodos de Regras de Negócio -- //
    public void verificaRegrasEspecialidade(String especialidade) {
        if(especialidade == null) {
            throw new IllegalStateException("ERRO! A ESPECIALIDADE NÃO PODE SER NULA");
        }

        if(especialidade.length() < 6) {
            throw new IllegalStateException("ERRO! A ESPECIALIDADE DEVE CONTER MAIS DE 5 DÍGITOS");
        }
    }

    // -- Métodos de Integridade -- //
    public static void verificaIntegridadeEspecialidade(String especialidade) {
        if(especialidade.isBlank()) {
            throw new IllegalArgumentException("ERRO! A ESPECIALIDADE NÃO PODE SER VAZIA");
        }
    }
}
