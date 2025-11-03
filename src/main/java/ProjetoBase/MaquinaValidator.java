package ProjetoBase;

import Models.MaquinaModel;

public class MaquinaValidator {

    // -- Verifica regras de negócio -- //
    public static void verificaRegrasInsercaoMaquina(MaquinaModel maquina) {
        verificaRegrasNome(maquina.getNome());
        verificaRegrasLocalizacao(maquina.getLocalizacao());
        verificaRegrasStatus(maquina.getStatus());
    }

    public static void verificaRegrasNome(String nome) {
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

    public static void verificaRegrasLocalizacao(String localizacao) {
        if(localizacao == null) {
            throw new IllegalStateException("ERRO! A LOCALIZAÇÃO NÃO PODE SER NULA");
        }
    }

    // -- Verifica integridade de dados -- //
    public static void verificaIntegridadeNome(String nome) {
        if(nome.isBlank()) {
            throw new IllegalArgumentException("ERRO! O NOME NÃO PODE SER VAZIO");
        }
    }

    public static void verificaIntegridadeLocalizacao(String localizacao) {
        if(localizacao.isBlank()) {
            throw new IllegalArgumentException("ERRO! A LOCALIZAÇÃO NÃO PODE SER VAZIA");
        }
    }

    public static void verificaIntegridadeStatus(int idNivelAcesso){
        if(idNivelAcesso < 0) {
            throw new IllegalArgumentException("ERRO! O ID_STATUS NÃO PODE SER NEGATIVO");
        }
    }
}
