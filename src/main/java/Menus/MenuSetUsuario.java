package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.UsuarioValidator;

public class MenuSetUsuario
{

    //SET NOME DO USUÁRIO
    public static String MenuSetNome(UsuarioValidator usuarioValidator)
    {
        boolean verifica = false;

        while(!verifica)
        {
            System.out.println("Digite o novo Nome: ");
            String nome = Ferramentas.lString();

            try
            {
                UsuarioValidator.verificaIntegridadeNome(nome);
                usuarioValidator.verificaRegrasNome(nome);
                verifica = true;
            }
            catch (IllegalArgumentException | IllegalStateException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
        return " ";
    }

    //SET CPF DO USUÁRIO
    public static void MenuSetCpf(UsuarioValidator usuarioValidator){
        boolean verifica = false;

        while(!verifica){
            System.out.print("Digite seu CPF: ");
            String CPF = Ferramentas.lString();

            try
            {
                UsuarioValidator.verificaIntegridadeCpf(CPF);
                usuarioValidator.verificarRegrasCpf(CPF);

                verifica = true;
            }
            catch (IllegalArgumentException | IllegalStateException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    //SET SENHA DO USUÁRIO
    public static void MenuSetSenha(UsuarioValidator usuarioValidator){
        boolean verifica = false;

        while(!verifica){
            System.out.print("Digite sua senha: ");
            String senha = ProjetoBase.Ferramentas.lString();

            try
            {
                UsuarioValidator.verificaIntegridadeSenha(senha);
                usuarioValidator.verificarRegrasSenha(senha);
                verifica = true;
            }
            catch (IllegalArgumentException | IllegalStateException e)
            {
                ProjetoBase.Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
