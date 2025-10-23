package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.UsuarioValidator;

public class MenuSetUsuario {

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
    }
}
