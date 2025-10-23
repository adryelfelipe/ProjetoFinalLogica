package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.UsuarioModel;

public class MenuLogin
{
    private static final ProjetoBase.UsuarioService usuarioService = new ProjetoBase.UsuarioService();
    public static void login()
    {
        boolean continuar = true;

        String cpfLogin = "1";
        String senhaLogin = "1";

        while(continuar)
        {
            System.out.println("================================");
            System.out.println("|             LOGIN            |");
            System.out.println("================================\n");

            System.out.print("|     Digite seu CPF: ");
            cpfLogin = Ferramentas.lString();
            System.out.print("|     Digite sua senha: ");
            senhaLogin = Ferramentas.lString();

            try
            {
                //Esse método ainda não existe
                //UsuarioModel usuario = usuarioService.loginUsuario(cpfLogin, senhaLogin);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("ERRO! SENHA OU CPF INVÁLIDOS");
            }
        }
    }
}
