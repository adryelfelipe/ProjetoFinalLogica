package Views;

import Aplicacao.Funcionario.Gerente.GerenteController;
import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Tecnico.Tecnico;
import Util.Ferramentas;
import ProjetoBase.UsuarioService;
import Views.Administrador.MenuAdministrador;

public class MenuLogin
{
    // -- Atributos -- //
    private GerenteController gerenteController;
    private MenuAdministrador menuAdministrador = new MenuAdministrador(gerenteController);

    // -- Construtor -- //
    public MenuLogin(GerenteController gerenteController) {
        this.gerenteController = gerenteController;
    }

    public void login() {
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
    }
}