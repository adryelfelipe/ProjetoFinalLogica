package Menus;

import ProjetoBase.UsuarioValidator;

public class MenuSetSenha {
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
