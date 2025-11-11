package Views;

import Util.Ferramentas;

public class MenuSetUsuario
{
    //SET NOME DO USUÁRIO
    public static String MenuSetNome()
    {
        System.out.print("┃ ➤ Digite o Nome: ");
        return Ferramentas.lString();
    }

    //SET CPF DO USUÁRIO
    public static String MenuSetCpf(){
        System.out.print("┃ ➤ Digite o CPF: ");
        return Ferramentas.lString();
    }

    //SET SENHA DO USUÁRIO
    public static String MenuSetSenha() {
        System.out.print("┃ ➤ Digite a senha: ");
        return Ferramentas.lString();
    }
}
