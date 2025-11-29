package Views.Funcionario.Gerente;

import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorResponse;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoResponse;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaRequest;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Util.Ferramentas;
import Views.Sistema.Main;
import Views.Funcionario.Nucleo.MenuSetFuncionario;
import Views.Maquina.MenuSetMaquina;
import Views.Funcionario.Supervisor.MenuSetSupervisor;
import Views.Funcionario.Tecnico.MenuSetTecnico;

import java.util.ArrayList;

public class MenuCadastroGerente {
    // -- Atributos -- //
    public static void menuCadastroSupervisor(NivelAcesso nivelAcesso) {
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                  "+Ferramentas.ORANGE_DARK+"CADASTRO SUPERVISOR"+Ferramentas.AQUA_BLUE+"                   ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();

        // ----- Atribuição de caracteríscticas de um Funcionário ----- //
        String nome = MenuSetFuncionario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetFuncionario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetFuncionario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        ArrayList<Departamento> departamentos = MenuSetGerente.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        // ----- Atribuição de caracteríscticas de um Supervisor ----- //
        double metaMensal = MenuSetSupervisor.MenuSetMetaMensal();
        Ferramentas.limpaTerminal();

        Ferramentas.ProcessamentoDeDados.main();
        Ferramentas.Delay(2000);

        // -- Gerando request para cadastro de Supervisor -- //
        CadastroSupervisorRequest request = new CadastroSupervisorRequest(nome, cpf, senha, departamentos, metaMensal);
        CadastroSupervisorResponse response = Main.supervisorController.salvar(nivelAcesso, request);

        if(response.status()) {
            Ferramentas.mensagemSucesso(response.mensagem());
        } else {
            Ferramentas.mensagemErro(response.mensagem());
        }

        Ferramentas.limpaTerminal();
    }

    public static void menuCadastroMaquina(NivelAcesso nivelAcesso) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                   "+Ferramentas.ORANGE_DARK+"CADASTRO MÁQUINA"+Ferramentas.AQUA_BLUE+"                     ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        String nome = MenuSetMaquina.MenuSetNomeMaquina();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuSetGerente.menuSetDepartamento().getFirst();
        Ferramentas.limpaTerminal();

        StatusMaquina status = MenuSetMaquina.MenuSetStatusMaquina();
        Ferramentas.limpaTerminal();

        Ferramentas.limpaTerminal();
        System.out.print(Ferramentas.ITALIC+Ferramentas.DARK_CYAN+"┃  PROCESSANDO DADOS..."+Ferramentas.RESET+Ferramentas.AQUA_BLUE);
        Ferramentas.Delay(1000);

        // -- Gerando request para cadastro de Máquina -- //
        CadastroMaquinaRequest request = new CadastroMaquinaRequest(nome, departamento, status);
        CadastroMaquinaResponse response = Main.maquinaController.salvar(nivelAcesso, request);
        if(response.status()) {
            Ferramentas.mensagemSucesso(response.mensagem());
        } else {
            Ferramentas.mensagemErro(response.mensagem());
        }
        Ferramentas.Delay(800);
        Ferramentas.limpaTerminal();
    }

    public static void menuCadastroTecnico(NivelAcesso nivelAcesso) {
        System.out.println(" ");
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                   "+Ferramentas.ORANGE_DARK+"CADASTRO TÉCNICO"+Ferramentas.AQUA_BLUE+"                     ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        // ----- Atribuição de caracteríscticas de um Funcionário ----- //
        String nome = MenuSetFuncionario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetFuncionario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetFuncionario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        ArrayList<Departamento> departamentos = MenuSetGerente.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        // ----- Atribuição de caracteríscticas de um Técnico ----- //
        Especialidade especialidade = MenuSetTecnico.MenuSetEspecialidade();
        Ferramentas.limpaTerminal();

        System.out.print(Ferramentas.ITALIC+Ferramentas.DARK_CYAN+"┃  PROCESSANDO DADOS..."+Ferramentas.RESET+Ferramentas.AQUA_BLUE);
        Ferramentas.Delay(1000);

        // -- Gerando request para cadastro de Supervisor -- //
        CadastroTecnicoRequest request = new CadastroTecnicoRequest(nome, cpf, senha, departamentos, especialidade);
        CadastroTecnicoResponse response = Main.tecnicoController.salvar(nivelAcesso, request);

        if(response.status()) {
            Ferramentas.mensagemSucesso(response.mensagem());
        } else {
            Ferramentas.mensagemErro(response.mensagem());
        }

        Ferramentas.limpaTerminal();
    }
}
