package ProjetoBase;

import Models.UsuarioModel;
import Models.joias.NivelAcesso;
import Util.Ferramentas;

public class UsuarioValidator {

    // -- Construtor -- //
    public UsuarioValidator() {

    }

    // -- Métodos de Verificação -- //
    public static boolean isAutoUpdate(long idInsersor, long idInserido){
        if(idInsersor == idInserido)
        {
            return true;
        }

        return false;
    }

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

        if(cpf.contains(" ")) {
            throw new IllegalArgumentException("ERRO! O CPF NÃO PODE CONTER ESPAÇOS");
        }

        // -- VALIDAÇÃO DE MAIUSCULAS E ESPECIAIS -- //
        boolean verificaMaiuscula = FerramentaValidator.isContemMaiuscula(cpf);
        boolean verificaMinuscula = FerramentaValidator.isContemMinuscula(cpf);
        boolean verificaCaractereEspecial = FerramentaValidator.isContemCaractereEspecial(cpf);

        if(verificaMaiuscula || verificaMinuscula || verificaCaractereEspecial) {
            throw new IllegalArgumentException("ERRO! O CPF DEVE CONTER SOMENTE DÍGITOS");
        }
    }

    public static void verificaIntegridadeSenha(String senha) {
        if(senha.isBlank()) {
            throw new IllegalArgumentException("ERRO! A SENHA NÃO PODE SER VAZIA");
        }
    }

    public static void verificaIntegridadeIdUsuario(long idUsuario) {
        if(idUsuario < 0) {
            throw new IllegalArgumentException("ERRO! O ID NÃO PODE SER NEGATIVO");
        }
    }

    public static void verificaIntegridadeNivelAcesso(NivelAcesso nivelAcesso){
        if(nivelAcesso.getId() < 0) {
            throw new IllegalArgumentException("ERRO! O ID NÃO PODE SER NEGATIVO");
        }
    }

    // -- Métodos de Regras de Negócio -- //
    public static void verificaRegrasInsercaoUsuario(UsuarioModel usuario) {
        verificarRegrasSenha(usuario.getSenha());
        verificaRegrasNome(usuario.getNome());
        verificarRegrasCpf(usuario.getCpf());
        verificaRegrasNivelAcesso(usuario.getNivelAcesso());
        verificaRegrasObjeto(usuario);
    }

    public static void verificaRegrasObjeto(UsuarioModel usuario) {
        if(usuario == null) {
            throw new IllegalStateException("ERRO! O OBJETO NÃO PODE SER NULO");
        }
    }

    public static void verificaRegrasNome(String nome) {
        if(nome == null) {
            throw new IllegalStateException("ERRO! O NOME NÃO PODE SER NULO");
        }

        if(nome.length() < 2) {
            throw new IllegalStateException("ERRO! O NOME DEVE CONTER MAIS DE 1 CARACTER");
        }

        // -- VALIDAÇÃO DE CARACTERES ESPECIAIS -- //
        boolean verificaEspecial = false;

        for(String caractereEspecial : Ferramentas.listaEspeciais) {
            if(nome.contains(caractereEspecial)) {
                verificaEspecial = true;
                break;
            }
        }

        if(verificaEspecial) {
            throw new IllegalStateException("ERRO! O NOME NÃO PODE CONTER UM CARACTERE ESPECIAL");
        }
    }

    public static void verificarRegrasCpf(String cpf) {
        if(cpf == null) {
            throw new IllegalStateException("ERRO! O CPF NÃO PODE SER NULO");
        }
    }

    public static void verificarRegrasSenha(String senha) {
        if(senha == null) {
            throw new IllegalStateException("ERRO! A SENHA NÃO PODE SER NULA");
        }

        if(senha.contains(" ")) {
            throw new IllegalStateException("ERRO! A SENHA NÃO PODE CONTER ESPAÇOS");
        }

        if(senha.length() < 6) {
            throw new IllegalStateException("ERRO! A SENHA DEVE CONTER MAIS DE 5 CARACTERES");
        }


        // -- VALIDAÇÃO DE MAIUSCULAS E ESPECIAIS -- //
        boolean verificaMaiuscula = FerramentaValidator.isContemMaiuscula(senha);
        boolean verificaEspecial = FerramentaValidator.isContemCaractereEspecial(senha);
        boolean verificaNumeros = FerramentaValidator.isContemNumero(senha);

        if(!verificaMaiuscula) {
            throw new IllegalStateException("ERRO! A SENHA DEVE CONTER UMA LETRA MAIÚSCULA");
        }

        if(!verificaEspecial) {
            throw new IllegalStateException("ERRO! A SENHA DEVE CONTER UM CARACTERE ESPECIAL");
        }

        if(!verificaNumeros) {
            throw new IllegalStateException("ERRO! A SENHA DEVE CONTER UM NÚMERO");
        }
    }

    public static void verificaRegrasNivelAcesso(NivelAcesso nivelAcesso) {
        if(nivelAcesso == null) {
            throw new IllegalStateException("ERRO! O NÍVEL DE ACESSO NÃO PODE SER NULO");
        }

        if(nivelAcesso.getId() > 3) {
            throw new IllegalStateException("ERRO! ID DE NÍVEL DE ACESSO INVÁLIDO");
        }
    }

    public static void temNivelAcesso4(UsuarioModel usuario) {
        if (!(usuario.getNivelAcesso().getId() == 4)) {
            throw new IllegalStateException("ERRO! FALTA DE PERMISSÃO");
        }
    }

    public static void temNivelAcesso3(UsuarioModel usuario) {
        if (!(usuario.getNivelAcesso().getId() == 3)) {
            throw new IllegalStateException("ERRO! FALTA DE PERMISSÃO");
        }
    }

    public static void temNivelAcesso2(UsuarioModel usuario) {
        if (!(usuario.getNivelAcesso().getId() == 2)) {
            throw new IllegalStateException("ERRO! FALTA DE PERMISSÃO");
        }
    }

    public static void temNivelAcesso1(UsuarioModel usuario) {
        if (!(usuario.getNivelAcesso().getId() == 1)) {
            throw new IllegalStateException("ERRO! FALTA DE PERMISSÃO");
        }
    }
}
