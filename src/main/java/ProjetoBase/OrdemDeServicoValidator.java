package ProjetoBase;

public class OrdemDeServicoValidator
{
    // -- Verifica regras de negócio -- //
    public static void verificaRegrasNomeFuncionario(String nome) {
        if (nome == null) {
            throw new IllegalStateException("ERRO! O NOME NÃO PODE SER NULO");
        }

        if (nome.length() < 2) {
            throw new IllegalStateException("ERRO! O NOME DEVE CONTER MAIS DE 1 CARACTER");
        }
    }

    public static void verificaRegrasStatus(int idStatus){
        if(idStatus > 3) {
            throw new IllegalArgumentException("ERRO! O ID_STATUS NÃO PODE SER MAIOR QUE 3");
        }
    }

    // -- Verifica integridade de dados -- //
    public static void verificaIntegridadeNomeFuncionario(String nome) {
        if(nome.isBlank()) {
            throw new IllegalArgumentException("ERRO! O NOME NÃO PODE SER VAZIO");
        }
    }

    public static void verificaIntegridadeStatus(int idNivelAcesso){
        if(idNivelAcesso < 0) {
            throw new IllegalArgumentException("ERRO! O ID_STATUS NÃO PODE SER NEGATIVO");
        }
    }
}
