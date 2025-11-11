package Views;

import Aplicacao.Funcionario.Gerente.Controller.GerenteController;
import Aplicacao.Funcionario.Nucleo.Controller.FuncionarioController;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Util.Ferramentas;
import Views.Administrador.MenuAdministrador;
import testesProjeto.MainTestes;

public class MenuLogin
{
    public static void login() {
        // Menu interativo
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃             LOGIN              ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.print("┃ ➤ Digite seu CPF: ");
        String cpf = Ferramentas.lString();

        System.out.print("┃ ➤ Digite sua senha: ");
        String senhaLogin = Ferramentas.lString();

        LoginFuncionarioRequest request = new LoginFuncionarioRequest(cpf, senhaLogin);
        LoginFuncionarioResponse response = MainTestes.funcionarioController.login(request);
        Ferramentas.mensagemErro(response.mensagem());

        if(response.operacao()) {
            if(response.nivelAcesso().equals(NivelAcesso.ADMIN)) {
                MenuAdministrador.menuInicial(response.nivelAcesso());
            }

            if(response.nivelAcesso().equals(NivelAcesso.GERENTE)) {
                MenuGerente.menuInicial();
            }
        }
    }
}