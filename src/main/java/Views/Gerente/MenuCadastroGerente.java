package Views.Gerente;

import Models.*;
import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.Especialidade;
import Models.Enumeracoes.StatusMaquina;
import Service.MaquinaService;
import Service.UsuarioService;
import Util.Ferramentas;
import Views.Administrador.MenuAtualizarADM;
import Views.Nucleo.MenuSetUsuario;

import java.util.Arrays;

public class MenuCadastroGerente {
    // -- Atributos -- //
    private static final MaquinaService maquinaService = new MaquinaService();
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void menuCadastroSupervisor(Gerente gerente) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                 CADASTRO SUPERVISOR               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println();

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        String nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuAtualizarADM.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        // ----- Atribuição de caracteríscticas de um Supervisor ----- //
        double metaMensal = MenuSetSupervisor.MenuSetMetaMensal();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("┃  PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);


        try {
            Supervisor supervisor = new Supervisor(nome, cpf, senha, metaMensal, Arrays.asList(departamento));
            usuarioService.salvarSupervisor(gerente, supervisor);
            Ferramentas.limpaTerminal();
            System.out.println("┃  SUPERVISOR CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
            Ferramentas.limpaTerminal();
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }

    public static void menuCadastroMaquina(Gerente gerente) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                  CADASTRO MÁQUINA                 ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        String nome = MenuAlteraMaquina.MenuSetNomeMaquina();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuAtualizarADM.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        StatusMaquina idStatus = MenuAlteraMaquina.MenuSetStatusMaquina();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("┃  PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        try {
            Maquina maquina = new Maquina(nome, departamento, idStatus);
            maquinaService.inserirMaquina(gerente, maquina);
            Ferramentas.limpaTerminal();
            System.out.println("┃  MÁQUINA CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }

    public static void menuCadastroTecnico(Gerente gerente) {
        System.out.println(" ");
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                  CADASTRO TÉCNICO                 ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        String nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuAtualizarADM.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        // ----- Atribuição de caracteríscticas de um Técnico ----- //
        Especialidade especialidade = MenuAtualizarGerente.MenuSetEspecialidade();


        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("┃  PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        try {
            Tecnico tecnico = new Tecnico(nome, cpf, senha, especialidade, Arrays.asList(departamento));
            usuarioService.salvarTecnico(gerente, tecnico);
            Ferramentas.limpaTerminal();
            System.out.println("┃  TÉCNICO CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }

        Ferramentas.limpaTerminal();
    }
}
