package Views.Nucleo;

import Util.Ferramentas;
import Service.UsuarioService;
import Service.Validator.UsuarioValidator;

public class MenuSetUsuario
{
    private static UsuarioService usuarioService = new UsuarioService();

    //                    ALTERA O NOME NO USUÁRIO                    //
    public static String MenuSetNome()
    {
        while(true)
        {
            System.out.print("┃ ➤ Digite o Nome: ");
            String nome = Ferramentas.lString();

            try {
                UsuarioValidator.verificaIntegridadeNome(nome);
                UsuarioValidator.verificaRegrasNome(nome);
                return nome;
            }
            catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    //                    ALTERA O CPF DO USUÁRIO                    //
    public static String MenuSetCpf(){
        String CPF;

        while(true){
            System.out.print("┃ ➤ Digite o CPF: ");
            CPF = Ferramentas.lString();

            try {
                UsuarioValidator.verificaIntegridadeCpf(CPF);
                UsuarioValidator.verificarRegrasCpf(CPF);
                usuarioService.isCpfCadastradoValidator(CPF);
                return CPF;
            }
            catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    //                    ALTERA A SENHA DO USUÁRIO                    //
    public static String MenuSetSenha(){
        String senha;

        while(true){
            System.out.print("┃ ➤ Digite a senha: ");
            senha = Ferramentas.lString();

            try
           {
                UsuarioValidator.verificaIntegridadeSenha(senha);
                UsuarioValidator.verificarRegrasSenha(senha);
                return senha;
            }
            catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
