package Views.Funcionario.Nucleo;

import Util.Ferramentas;

public class MenuSetFuncionario
{
    //SET NOME DO USUÁRIO
    public static String MenuSetNome()
    {
        System.out.print(Ferramentas.AQUA_BLUE+"┃ ➤ Digite o Nome: ");
        return Ferramentas.lString();
    }

    //SET CPF DO USUÁRIO
    public static String MenuSetCpf(){
        System.out.print(Ferramentas.AQUA_BLUE+"┃ ➤ Digite o CPF: ");
        return Ferramentas.lString();
    }

    //SET SENHA DO USUÁRIO
    public static String MenuSetSenha() {
        System.out.print(Ferramentas.AQUA_BLUE+"┃ ➤ Digite a senha: ");
        return Ferramentas.lString();
    }
}
