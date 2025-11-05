package Views;

import Models.*;
import Models.joias.Especialidade;
import Models.joias.StatusMaquina;
import ProjetoBase.MaquinaService;
import ProjetoBase.SupervisorService;
import ProjetoBase.TecnicoService;
import Util.Ferramentas;
import ProjetoBase.GerenteService;

public class MenuCadastroGerente {
    // -- Atributos -- //
    private static final SupervisorService supervisorService = new SupervisorService();
    private static final MaquinaService maquinaService = new MaquinaService();
    private static final TecnicoService tecnicoService = new TecnicoService();

    public static void menuCadastroSupervisor(GerenteModel gerente) {
        System.out.println("|================================|");
        System.out.println("|       CADASTRO SUPERVISOR      |");
        System.out.println("|================================|\n");

        System.out.println();

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        String nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();
        // ----- Atribuição de caracteríscticas de um Supervisor ----- //
        double metaMensal = MenuSetSupervisor.MenuSetMetaMensal();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);


        try {
            SupervisorModel supervisor = new SupervisorModel(nome, cpf, senha, metaMensal);
            supervisorService.inserirSupervisor(gerente, supervisor);
            Ferramentas.limpaTerminal();
            System.out.println("SUPERVISOR CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
            Ferramentas.limpaTerminal();
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }

    public static void menuCadastroMaquina(GerenteModel gerente) {
        System.out.println("|================================|");
        System.out.println("|       CADASTRO  MÁQUINA        |");
        System.out.println("|================================|\n");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        String nome = MenuSetMaquina.MenuSetNomeMaquina();
        Ferramentas.limpaTerminal();

        String localizacao = MenuSetMaquina.MenuSetLocalizacao();
        Ferramentas.limpaTerminal();

        StatusMaquina idStatus = MenuSetMaquina.MenuSetStatusMaquina();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        try {
            MaquinaModel maquina = new MaquinaModel(nome, localizacao, idStatus);
            maquinaService.inserirMaquina(gerente, maquina);
            Ferramentas.limpaTerminal();
            System.out.println("MÁQUINA CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }

    public static void menuCadastroTecnico(GerenteModel gerente) {
        System.out.println(" ");
        System.out.println("|================================|");
        System.out.println("|       CADASTRO  TÉCNICO        |");
        System.out.println("|================================|");

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        String nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();
        // ----- Atribuição de caracteríscticas de um Técnico ----- //
        Especialidade especialidade = MenuSetTecnico.MenuSetEspecialidade();


        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        try {
            TecnicoModel tecnico = new TecnicoModel(nome, cpf, senha, especialidade);
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
