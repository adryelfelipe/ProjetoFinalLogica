package Menus;



public class MenuLogin
{
    //private static final UsuarioService usuarioService = new usuarioService();
    public static void login(){
        boolean continuar = true;

        String cpfLogin = "1";
        String senhaLogin = "1";

        while(continuar){
            System.out.println("================================");
            System.out.println("|             LOGIN            |");
            System.out.println("================================\n");

            System.out.print("Digite seu CPF: ");
            cpfLogin = Ferramentas.lString();
            System.out.print("Digite sua senha: ");
            senhaLogin = Ferramentas.lString();

            try
            {
                //Usuario usuario = usuarioService.loginUsuario(cpfLogin, senhaLogin);
            }
            catch (/*SenhaInvalidaException | CpfInvalido*/ Exception e)
            {
                System.out.println("ERRO! SENHA OU CPF INVÁLIDOS");
            }


        }
    }
}
