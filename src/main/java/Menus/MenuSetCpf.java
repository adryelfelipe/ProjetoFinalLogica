package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.UsuarioValidator;

public class MenuSetCpf {

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
}
