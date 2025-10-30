package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;

public class MenuSetUsuario
{
    //SET NOME DO USUÁRIO
    public static String MenuSetNome()
    {
        boolean verifica = false;

        while(!verifica)
        {
            System.out.println("Digite o novo Nome: ");
            String nome = Ferramentas.lString();

            try
            {
                UsuarioValidator.verificaIntegridadeNome(nome);
                UsuarioValidator.verificaRegrasNome(nome);
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
    public static String MenuSetCpf(){
        boolean verifica = false;

        String CPF = "";

        while(!verifica){
            System.out.print("Digite seu CPF: ");
            CPF = Ferramentas.lString();

            try
            {
                UsuarioValidator.verificaIntegridadeCpf(CPF);
                UsuarioValidator.verificarRegrasCpf(CPF);

                verifica = true;
            }
            catch (IllegalArgumentException | IllegalStateException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
        return CPF;
    }

    //SET SENHA DO USUÁRIO
    public static String MenuSetSenha(){
        boolean verifica = false;

        String senha = " ";

        while(!verifica){
            System.out.print("Digite sua senha: ");
            senha = ProjetoBase.Ferramentas.lString();

            try
            {
                UsuarioValidator.verificaIntegridadeSenha(senha);
                UsuarioValidator.verificarRegrasSenha(senha);
                verifica = true;
            }
            catch (IllegalArgumentException | IllegalStateException e)
            {
                ProjetoBase.Ferramentas.mensagemErro(e.getMessage());
            }
        }
        return senha;
    }
}
