package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;

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
                UsuarioValidator.verificaIntegridadeCpf(cpfLogin);
                //usuarioValidator.verii

                System.out.print("|     Digite sua senha: ");
                senhaLogin = Ferramentas.lString();



            }
            catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }

    }
}
