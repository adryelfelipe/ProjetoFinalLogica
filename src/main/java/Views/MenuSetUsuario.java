package Views;

import Util.Ferramentas;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;

public class MenuSetUsuario
{
    private static UsuarioService usuarioService = new UsuarioService();

    //SET NOME DO USUÁRIO
    public static String MenuSetNome()
    {
        while(true)
        {
            System.out.print("| ➤ Digite o Nome: ");
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

    //SET CPF DO USUÁRIO
    public static String MenuSetCpf(){
        String CPF;

        while(true){
            System.out.print("| ➤ Digite o CPF: ");
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

    //SET SENHA DO USUÁRIO
    public static String MenuSetSenha(){
        String senha;

        while(true){
            System.out.print("| ➤ Digite a senha: ");
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
