package Views;

import Models.GerenteModel;
import Models.SupervisorModel;
import Util.Ferramentas;
import ProjetoBase.SupervisorService;

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
}
