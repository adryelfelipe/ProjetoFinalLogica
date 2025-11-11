package Views;

import Aplicacao.Funcionario.Gerente.Controller.GerenteController;
import Aplicacao.Funcionario.Nucleo.Controller.FuncionarioController;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Util.Ferramentas;
import Views.Administrador.MenuAdministrador;

public class MenuLogin
{
    // -- Atributos -- //
    private GerenteController gerenteController;
    private FuncionarioController funcionarioController;
    private MenuAdministrador menuAdministrador;
    // -- Construtor -- //
    public MenuLogin(GerenteController gerenteController, FuncionarioController funcionarioController) {
        this.gerenteController = gerenteController;
        this.funcionarioController = funcionarioController;
        this.menuAdministrador = new MenuAdministrador(this.gerenteController);
    }

    public void login() {
        // Menu interativo
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃             LOGIN              ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.print("┃ ➤ Digite seu CPF: ");
        String cpf = Ferramentas.lString();

        System.out.print("┃ ➤ Digite sua senha: ");
        String senhaLogin = Ferramentas.lString();

        LoginFuncionarioRequest request = new LoginFuncionarioRequest(cpf, senhaLogin);
        LoginFuncionarioResponse response = funcionarioController.login(request);
        Ferramentas.mensagemErro(response.mensagem());

        if(response.operacao()) {
            if(response.nivelAcesso().equals(NivelAcesso.ADMIN)) {
                menuAdministrador.menuInicial(response.nivelAcesso());
            }
        }
    }
}