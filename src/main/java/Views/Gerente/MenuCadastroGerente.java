package Views.Gerente;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;
import Dominio.Maquina.Maquina;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Tecnico.Tecnico;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Dominio.Maquina.ObjetosDeValor.Localizacao;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;
import ProjetoBase.MaquinaService;
import ProjetoBase.SupervisorService;
import ProjetoBase.TecnicoService;
import Util.Ferramentas;
import Views.MenuSetMaquina;
import Views.MenuSetSupervisor;
import Views.MenuSetTecnico;
import Views.MenuSetUsuario;

import java.util.Arrays;

public class MenuCadastroGerente {
    // -- Atributos -- //
    private static final SupervisorService supervisorService = new SupervisorService();
    private static final MaquinaService maquinaService = new MaquinaService();
    private static final TecnicoService tecnicoService = new TecnicoService();

    public static void menuCadastroSupervisor(Gerente gerente) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       CADASTRO SUPERVISOR      ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        System.out.println();

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        NomeFuncionario nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        CPF cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        Senha senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();
        // ----- Atribuição de caracteríscticas de um Supervisor ----- //
        MetaMensal metaMensal = MenuSetSupervisor.MenuSetMetaMensal();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);


        try {
            Supervisor supervisor = new Supervisor(nome, cpf, senha, metaMensal);
            supervisorService.inserirSupervisor(gerente, supervisor);
            Ferramentas.limpaTerminal();
            System.out.println("SUPERVISOR CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
            Ferramentas.limpaTerminal();
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }

    public static void menuCadastroMaquina(Gerente gerente) {
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
            maquinaService.inserirMaquina(gerente, maquina);
            Ferramentas.limpaTerminal();
            System.out.println("MÁQUINA CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }

    public static void menuCadastroTecnico(Gerente gerente) {
        System.out.println(" ");
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       CADASTRO  TÉCNICO        ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        NomeFuncionario nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        CPF cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        Senha senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        Departamento departamento = MenuSetGerente.menuSetDepartamento();
        ListaDepartamentos departamentos = new ListaDepartamentos(Arrays.asList(departamento));

        // ----- Atribuição de caracteríscticas de um Técnico ----- //
        Especialidade especialidade = MenuSetTecnico.MenuSetEspecialidade();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        try {
            Tecnico tecnico = new Tecnico(nome, cpf, senha, departamentos, especialidade);
            tecnicoService.inserirTecnico(gerente, tecnico);
            Ferramentas.limpaTerminal();
            System.out.println("TÉCNICO CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }

        Ferramentas.limpaTerminal();
    }
}
