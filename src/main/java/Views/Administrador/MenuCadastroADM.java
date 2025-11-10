package Views.Administrador;

import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Dtos.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Dtos.CadastroGerenteResponse;
import Aplicacao.Funcionario.Gerente.GerenteController;
import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Util.Ferramentas;
import Views.Gerente.MenuSetGerente;
import Views.MenuSetUsuario;

public class MenuCadastroADM {
    private GerenteController gerenteController;

    public MenuCadastroADM(GerenteController gerenteController) {
        this.gerenteController = gerenteController;
    }

    public void menuCadastroGerente(Administrador administrador) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       CADASTRO GERENTE         ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println(" ");

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        NomeFuncionario nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        CPF cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        Senha senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        // ----- Atribuição de caracteríscticas de um Gerente ----- //
        ListaDepartamentos listaDepartamentos = MenuSetGerente.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();

        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);
        Ferramentas.limpaTerminal();

        // -- Gerando request para cadastro de gerente -- //
        CadastroGerenteRequest gerenteRequest = new CadastroGerenteRequest(nome, cpf, senha, listaDepartamentos);
        CadastroGerenteResponse gerenteResponse = gerenteController.salvar(gerenteRequest);
        Ferramentas.mensagemErro(gerenteResponse.mensagem());
        Ferramentas.Delay(800);
    }
}
