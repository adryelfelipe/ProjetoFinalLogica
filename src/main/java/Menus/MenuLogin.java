package Menus;

import UsuarioValidator.*;

public class MenuLogin {
    private static final UsuarioService usuarioService = new usuarioService();
    public static void login(){
        boolean continuar = true;

        String cpf = "1";
        String senha = "1";

        while(continuar){
            System.out.println("=====================");
            System.out.println("        LOGIN        ");
            System.out.println("=====================\n");

            System.out.print("Digite seu CPF: ");
            cpf = Ferramentas.lString();
            System.out.print("Digite sua senha: ");
            senha = Ferramentas.lString();

            try{
                Usuario usuario = usuarioService.loginUsuario(cpf, senha);
            }catch (SenhaInvalidaException | CpfInvalidoException e){
                System.out.println("ERRO! SENHA OU CPF INVÁLIDOS");
            }
        }
    }
}
