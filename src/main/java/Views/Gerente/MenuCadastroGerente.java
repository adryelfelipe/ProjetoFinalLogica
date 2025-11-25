package Views.Gerente;

import Models.*;
import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.Especialidade;
import Models.Enumeracoes.StatusMaquina;
import Service.MaquinaService;
import Service.UsuarioService;
import Util.Ferramentas;
import Views.Administrador.MenuAlteraADM;
import Views.Nucleo.MenuAlteraUsuario;

import java.util.Arrays;

public class MenuCadastroGerente {
    //                    ATRIBUTOS                    //
    private static final MaquinaService maquinaService = new MaquinaService();
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void menuCadastroSupervisor(Gerente gerente) {
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                 "+Ferramentas.ORANGE_DARK+"CADASTRO SUPERVISOR"+Ferramentas.AQUA_BLUE+"               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println();

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UM USUÁRIO                    //
        String nome = MenuAlteraUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuAlteraUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuAlteraUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuAlteraADM.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UM SUPERVISOR                    //
        double metaMensal = MenuAlteraGerente.MenuSetMetaMensal();
        Ferramentas.limpaTerminal();

        //                    CRIAÇÃO DO OBJETO E INSERÇÃO NO BANCO DE DADOS                    //
        Ferramentas.limpaTerminal();
        System.out.println(Ferramentas.ITALIC+Ferramentas.DARK_CYAN+"┃  PROCESSANDO DADOS..."+Ferramentas.RESET+Ferramentas.AQUA_BLUE);
        Ferramentas.Delay(1000);


        try {
            Supervisor supervisor = new Supervisor(nome, cpf, senha, metaMensal, Arrays.asList(departamento));
            usuarioService.salvarSupervisor(gerente, supervisor);
            Ferramentas.limpaTerminal();
            System.out.println(Ferramentas.BOLD+Ferramentas.ORANGE_DARK+"┃  SUPERVISOR CADASTRADO COM SUCESSO!"+Ferramentas.RESET+Ferramentas.AQUA_BLUE);
            Ferramentas.Delay(800);
            Ferramentas.limpaTerminal();
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }

    public static void menuCadastroMaquina(Gerente gerente) {
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                  "+Ferramentas.ORANGE_DARK+"CADASTRO MÁQUINA"+Ferramentas.AQUA_BLUE+"                 ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UMA MÁQUINA                    //
        String nome = MenuAlteraMaquina.MenuSetNomeMaquina();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuAlteraADM.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        StatusMaquina idStatus = MenuAlteraMaquina.MenuSetStatusMaquina();
        Ferramentas.limpaTerminal();

        //                    CRIAÇÃO DO OBJETO E INSERÇÃO NO BANCO DE DADOS                    //
        Ferramentas.limpaTerminal();
        System.out.println(Ferramentas.ITALIC+Ferramentas.DARK_CYAN+"┃  PROCESSANDO DADOS..."+Ferramentas.RESET+Ferramentas.AQUA_BLUE);
        Ferramentas.Delay(1000);

        try {
            Maquina maquina = new Maquina(nome, departamento, idStatus);
            maquinaService.inserirMaquina(gerente, maquina);
            Ferramentas.limpaTerminal();
            System.out.println(Ferramentas.ITALIC+Ferramentas.ORANGE_DARK+"┃  MÁQUINA CADASTRADO COM SUCESSO!"+Ferramentas.RESET+Ferramentas.AQUA_BLUE);
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }

    public static void menuCadastroTecnico(Gerente gerente) {
        System.out.println(" ");
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                  "+Ferramentas.ORANGE_DARK+"CADASTRO TÉCNICO"+Ferramentas.AQUA_BLUE+"                 ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UM USUÁRIO                    //
        String nome = MenuAlteraUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuAlteraUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuAlteraUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuAlteraADM.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UM TÉCNICO                    //
        Especialidade especialidade = MenuAlteraGerente.MenuSetEspecialidade();


        //                    CRIAÇÃO DO OBJETO E INSERÇÃO NO BANCO DE DADOS                    //
        Ferramentas.limpaTerminal();
        System.out.println(Ferramentas.ITALIC+Ferramentas.AQUA_BLUE+"┃  PROCESSANDO DADOS..."+Ferramentas.RESET+Ferramentas.AQUA_BLUE);
        Ferramentas.Delay(1000);

        try {
            Tecnico tecnico = new Tecnico(nome, cpf, senha, especialidade, Arrays.asList(departamento));
            usuarioService.salvarTecnico(gerente, tecnico);
            Ferramentas.limpaTerminal();
            System.out.println(Ferramentas.BOLD+Ferramentas.ORANGE_DARK+"┃  TÉCNICO CADASTRADO COM SUCESSO!"+Ferramentas.RESET+Ferramentas.AQUA_BLUE);
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }

        Ferramentas.limpaTerminal();
    }
}
