package Views.Administrador;

import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Gerente.MenuSetGerente;
import Views.Main;
import Views.MenuSetUsuario;

import java.util.List;

public class MenuCadastroADM {
    public static void menuCadastroGerente(NivelAcesso nivelAcesso) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       CADASTRO GERENTE         ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println(" ");

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        String nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        // ----- Atribuição de caracteríscticas de um Gerente ----- //
        List<Departamento> listaDepartamentos = MenuSetGerente.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();

        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);
        Ferramentas.limpaTerminal();

        // -- Gerando request para cadastro de gerente -- //
        CadastroGerenteRequest gerenteRequest = new CadastroGerenteRequest(nome, cpf, senha, listaDepartamentos);
        CadastroGerenteResponse gerenteResponse = Main.gerenteController.salvar(nivelAcesso,gerenteRequest);
        Ferramentas.mensagemErro(gerenteResponse.mensagem());
        Ferramentas.Delay(800);
    }
}
