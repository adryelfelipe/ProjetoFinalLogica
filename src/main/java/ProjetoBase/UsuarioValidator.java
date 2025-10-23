package ProjetoBase;

public class UsuarioValidator {

    // -- Atributos -- //
    private final UsuarioService usuarioService;

    // -- Construtor -- //
    public UsuarioValidator(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
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

    public static void verificaIntegridadeNivelAcesso(long idNivelAcesso){
        if(idNivelAcesso < 0) {
            throw new IllegalArgumentException("ERRO! O ID NÃO PODE SER NEGATIVO");
        }
    }

    // -- Métodos de Regras de Negócio -- //
    public void verificaRegrasNome(String nome)
    {
        if(nome == null)
        {
            throw new IllegalStateException("ERRO! O NOME NÃO PODE SER NULO");
        }

        if(nome.length() < 2)
        {
            throw new IllegalStateException("ERRO! O NOME DEVE CONTER MAIS DE 1 CARACTER");
        }

        // -- VALIDAÇÃO DE CARACTERES ESPECIAIS -- //
        boolean verificaEspecial = false;

        for(String caractereEspecial : Ferramentas.listaEspeciais)
        {
            if(nome.contains(caractereEspecial))
            {
                verificaEspecial = true;
                break;
            }
        }

        if(verificaEspecial) {
            throw new IllegalStateException("ERRO! O NOME NÃO PODE CONTER UM CARACTERE ESPECIAL");
        }
    }

    public void verificarRegrasCpf(String cpf) {
        if(cpf == null) {
            throw new IllegalStateException("ERRO! O CPF NÃO PODE SER NULO");
        }
    }

    public void verificarRegrasSenha(String senha) {
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
        boolean verificaMaiuscula = false;
        boolean verificaEspecial = false;

        for(String maiuscula : Ferramentas.listaMaiusculos) {
            if (senha.contains(maiuscula)) {
                verificaMaiuscula = true;
                break;
            }
        }

        for(String caractereEspecial : Ferramentas.listaEspeciais) {
            if(senha.contains(caractereEspecial)) {
                verificaEspecial = true;
                break;
            }
        }

        if(!verificaMaiuscula) {
            throw new IllegalStateException("ERRO! A SENHA DEVE CONTER UMA LETRA MAIÚSCULA");
        }

        if(!verificaEspecial) {
            throw new IllegalStateException("ERRO! A SENHA DEVE CONTER UM CARACTERE ESPECIAL");
        }
    }

    public void verificaRegrasNivelAcesso(int idNivelAcesso) {
        if(idNivelAcesso > 3) {
            throw new IllegalStateException("ERRO! ID DE NÍVEL DE ACESSO INVÁLIDO");
        }
    }
}
