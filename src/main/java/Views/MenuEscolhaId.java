package Views;

import ProjetoBase.UsuarioService;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuEscolhaId
{
    public static long escolhaIdUpdate()
    {
        UsuarioService usuarioService = new UsuarioService();

        while(true) {
            System.out.print("DIGITE O ID: ");

            try {
                long id = Ferramentas.lInteiro();
                usuarioService.idExistenteValidator(id);
                return id;
            } catch (InputMismatchException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
