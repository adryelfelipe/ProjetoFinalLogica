package Menus;

import ProjetoBase.*;

public class MenuCadastroSupervisor
{
    // -- Atributos -- //
    private static final SupervisorService supervisorService = new SupervisorService();

    public static void menuCadastroSupervisor(GerenteModel gerente)
    {
        System.out.println("================================");
        System.out.println("|      CADASTRO SUPERVISOR     |");
        System.out.println("================================\n");

        System.out.println();

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        String nome = MenuSetUsuario.MenuSetNome();
        String cpf = MenuSetUsuario.MenuSetCpf();
        String senha = MenuSetUsuario.MenuSetSenha();

        // ----- Atribuição de caracteríscticas de um Supervisor ----- //
        double metaMensal = MenuSetSupervisor.MenuSetMetaMensal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);
        Ferramentas.limpaTerminal();

        try {
            SupervisorModel supervisor = new SupervisorModel(nome, cpf, senha, metaMensal);
            supervisorService.inserirSupervisor(gerente, supervisor);
            System.out.println("SUPERVISOR CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("ERRO AO INSERIR O USUÁRIO");
        }
    }
}
