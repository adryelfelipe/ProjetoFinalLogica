package Views.Funcionario.Nucleo;

import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Funcionario.Administrador.MenuAdministrador;
import Views.Funcionario.Gerente.MenuGerente;
import Views.Sistema.Main;

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
        LoginFuncionarioResponse response = Main.funcionarioController.login(request);
        Ferramentas.mensagemErro(response.mensagem());

        if(response.status()) {
            if(response.nivelAcesso().equals(NivelAcesso.ADMIN)) {
                MenuAdministrador.menuInicial(response.nivelAcesso());
            }

            if(response.nivelAcesso().equals(NivelAcesso.GERENTE)) {
                MenuGerente.menuInicial(response.nivelAcesso());
            }
        }
    }
}