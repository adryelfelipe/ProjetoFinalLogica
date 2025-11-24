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
    //                    ATRIBUTOS                    //
    private static final MaquinaService maquinaService = new MaquinaService();
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void menuCadastroSupervisor(Gerente gerente) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                 CADASTRO SUPERVISOR               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println();

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UM USUÁRIO                    //
        String nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuAtualizarADM.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UM SUPERVISOR                    //
        double metaMensal = MenuAtualizarGerente.MenuSetMetaMensal();
        Ferramentas.limpaTerminal();

        //                    CRIAÇÃO DO OBJETO E INSERÇÃO NO BANCO DE DADOS                    //
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

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UMA MÁQUINA                    //
        String nome = MenuAlteraMaquina.MenuSetNomeMaquina();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuAtualizarADM.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        StatusMaquina idStatus = MenuAlteraMaquina.MenuSetStatusMaquina();
        Ferramentas.limpaTerminal();

        //                    CRIAÇÃO DO OBJETO E INSERÇÃO NO BANCO DE DADOS                    //
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

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UM USUÁRIO                    //
        String nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuAtualizarADM.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UM TÉCNICO                    //
        Especialidade especialidade = MenuAtualizarGerente.MenuSetEspecialidade();


        //                    CRIAÇÃO DO OBJETO E INSERÇÃO NO BANCO DE DADOS                    //
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
