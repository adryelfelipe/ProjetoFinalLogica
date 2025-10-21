public class UsuarioValidator {

    // -- Métodos de Integridade -- //
    public static void verificaIntegridadeNome(String nome) {
        if(nome.isBlank()) {
            throw new IllegalArgumentException("ERRO! O NOME NÃO PODE SER VAZIO");
        }
    }

    public static void verificaIntegridadeCpf(String cpf) {
        if(cpf.isBlank()) {
            throw new IllegalArgumentException("ERRO! O CPF NÃO PODE SER VAZIO");
        }

        if(cpf.length() != 11) {
            throw  new IllegalArgumentException("ERRO! O CPF DEVE POSSUIR 11 DÍGITOS");
        }
    }

    public static void verificaIntegridadeSenha(String senha) {
        if(senha.isBlank()) {
            throw new IllegalArgumentException("ERRO! A SENHA NÃO PODE SER VAZIA");
        }
    }

    public static void verificaIntegridadeId(long idUsuario) {
        if(idUsuario < 0) {
            throw new IllegalArgumentException("ERRO! O ID NÃO PODE SER NEGATIVO");
        }
    }

    public static void verificaIntegridadeNivelAcesso(long idNivelAcesso){
        if(idNivelAcesso < 0) {
            throw new IllegalArgumentException("ERRO! O ID NÃO PODE SER NEGATIVO");
        }
    }
}
