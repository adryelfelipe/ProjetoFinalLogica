package Views.Nucleo;

import Service.OrdemDeServicoService;
import Service.UsuarioService;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuEscolhaId
{
    public static long escolhaIdUpdate()
    {
        UsuarioService usuarioService = new UsuarioService();

        while(true) {
            System.out.print(Ferramentas.AQUA_BLUE+"┃ ➤ Digite o ID: "+Ferramentas.AQUA_BLUE);

            try {
                long id = Ferramentas.lInteiro();
                usuarioService.isIdExistenteValidator(id);
                return id;
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            } catch (IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    public static long escolhaIdOs()
    {
        OrdemDeServicoService ordemDeServicoService = new OrdemDeServicoService();

        while(true) {
            System.out.print(Ferramentas.AQUA_BLUE+"┃ ➤ Digite o ID: "+Ferramentas.AQUA_BLUE);

            try {
                long id = Ferramentas.lInteiro();
                ordemDeServicoService.isIdExistenteValidator(id); //A fzr - preciso da service
                return id;
            } catch (InputMismatchException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
