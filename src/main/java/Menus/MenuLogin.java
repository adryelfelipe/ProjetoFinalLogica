package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.UsuarioService;

public class MenuLogin
{
    public static void login(UsuarioService usuarioService)
    {
        boolean continuar = true;

        String cpfLogin = "1";
        String senhaLogin = "1";

        while(continuar) {
            System.out.println("|================================|");
            System.out.println("|             LOGIN            |");
            System.out.println("|================================|\n");

            System.out.print("|     Digite seu CPF: ");
            try
            {
                cpfLogin = Ferramentas.lString();
                try
                {
                    System.out.print("|     Digite sua senha: ");
                    senhaLogin = Ferramentas.lString();

                    usuarioService.isCpfCadastradoValidator(cpfLogin);
                } catch (IllegalArgumentException e)
                {

                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("ERRO! SENHA OU CPF INVÁLIDOS");
            }
        }

    }
}
