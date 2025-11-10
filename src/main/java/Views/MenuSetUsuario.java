package Views;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Util.Ferramentas;
import ProjetoBase.UsuarioService;

public class MenuSetUsuario
{
    private static UsuarioService usuarioService = new UsuarioService();

    //SET NOME DO USUÁRIO
    public static NomeFuncionario MenuSetNome()
    {
        System.out.print("┃ ➤ Digite o Nome: ");
        String nome = Ferramentas.lString();
        return new NomeFuncionario(nome);
    }

    //SET CPF DO USUÁRIO
    public static CPF MenuSetCpf(){
        System.out.print("┃ ➤ Digite o CPF: ");
        String CPF = Ferramentas.lString();
        return new CPF(CPF);
    }

    //SET SENHA DO USUÁRIO
    public static Senha MenuSetSenha() {
        System.out.print("┃ ➤ Digite a senha: ");
        String senha = Ferramentas.lString();
        return new Senha(senha);
    }
}
