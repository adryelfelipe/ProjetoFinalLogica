package Views;

import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Tecnico.Tecnico;
import Util.Ferramentas;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;

public class MenuLogin
{
    public static void login(UsuarioService usuarioService) {
        // Inicialização das variáveis
        Funcionario funcionario;

        // Menu interativo

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃             LOGIN              ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.print("┃ ➤ Digite seu CPF: ");
        String cpf = Ferramentas.lString();

        System.out.print("┃ ➤ Digite sua senha: ");
        String senhaLogin = Ferramentas.lString();

        try {
            funcionario = usuarioService.loginUsuario(new CPF(cpf), senhaLogin);
        } catch (IllegalStateException e) {
            Ferramentas.mensagemErro("ERRO! CPF OU SENHA INVÁLIDOS");
            return;
        }

        Ferramentas.limpaTerminal();
        if(funcionario instanceof Administrador){
            MenuAdministrador.menuInicial((Administrador) funcionario);
        } else if(funcionario instanceof Gerente) {
            MenuGerente.menuInicial((Gerente) funcionario);
        } else if(funcionario instanceof Supervisor) {
            MenuSupervisor.menuSupervisor((Supervisor) funcionario);
        } else if(funcionario instanceof Tecnico) {
            MenuTecnico.menuTecnico((Tecnico) funcionario);
        }
        else {
            Ferramentas.mensagemErro("ERRO! CPF OU SENHA INVÁLIDOS");
        }
    }
}