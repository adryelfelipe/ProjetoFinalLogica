package Views.Gerente;

import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorResponse;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Maquina.Maquina;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Dominio.Maquina.ObjetosDeValor.Localizacao;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;
import Util.Ferramentas;
import Views.*;

import java.util.ArrayList;

public class MenuCadastroGerente {
    // -- Atributos -- //
    public static void menuCadastroSupervisor(NivelAcesso nivelAcesso) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       CADASTRO SUPERVISOR      ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        System.out.println();

        // ----- Atribuição de caracteríscticas de um Funcionário ----- //
        String nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        ArrayList<Departamento> departamentos = MenuSetGerente.menuSetDepartamento();

        // ----- Atribuição de caracteríscticas de um Supervisor ----- //
        double metaMensal = MenuSetSupervisor.MenuSetMetaMensal();
        Ferramentas.limpaTerminal();

        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        // -- Gerando request para cadastro de Supervisor -- //
        CadastroSupervisorRequest request = new CadastroSupervisorRequest(nome, cpf, senha, departamentos, metaMensal);
        CadastroSupervisorResponse response = Main.supervisorController.salvar(nivelAcesso, request);
        Ferramentas.mensagemErro(response.mensagem());
    }

    public static void menuCadastroMaquina() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       CADASTRO  MÁQUINA        ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        NomeMaquina nome = MenuSetMaquina.MenuSetNomeMaquina();
        Ferramentas.limpaTerminal();

        Localizacao localizacao = MenuSetMaquina.MenuSetLocalizacao();
        Ferramentas.limpaTerminal();

        StatusMaquina idStatus = MenuSetMaquina.MenuSetStatusMaquina();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        try {
            Maquina maquina = new Maquina(nome, localizacao, idStatus);
            Ferramentas.limpaTerminal();
            System.out.println("MÁQUINA CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }

    public static void menuCadastroTecnico(NivelAcesso nivelAcesso) {
        System.out.println(" ");
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       CADASTRO  TÉCNICO        ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        // ----- Atribuição de caracteríscticas de um Funcionário ----- //
        String nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        ArrayList<Departamento> departamentos = MenuSetGerente.menuSetDepartamento();

        // ----- Atribuição de caracteríscticas de um Técnico ----- //
        Especialidade especialidade = MenuSetTecnico.MenuSetEspecialidade();

        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        // -- Gerando request para cadastro de Supervisor -- //
        CadastroTecnicoRequest request = new CadastroTecnicoRequest(nome, cpf, senha, departamentos, especialidade);
        CadastroTecnicoResponse response = Main.tecnicoController.salvar(nivelAcesso, request);
        Ferramentas.mensagemErro(response.mensagem());



        Ferramentas.limpaTerminal();
    }
}
