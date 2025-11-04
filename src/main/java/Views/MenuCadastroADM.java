package Views;

import Models.AdminModel;
import Models.GerenteModel;
import ProjetoBase.GerenteService;
import ProjetoBase.GerenteValidator;
import Util.Ferramentas;

public class MenuCadastroADM {
    private static final GerenteService gerenteService = new GerenteService();

    public static void menuCadastroGerente(AdminModel adminModel) {
        System.out.println("|================================|");
        System.out.println("|       CADASTRO GERENTE         |");
        System.out.println("|================================|\n");
        System.out.println(" ");

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        String nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        // ----- Atribuição de caracteríscticas de um Gerente ----- //
        int idDepartamento = MenuSetGerente.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();

        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);
        Ferramentas.limpaTerminal();

        try {
            GerenteModel gerente = new GerenteModel(nome, cpf, senha, idDepartamento);
            gerenteService.inserirGerente(adminModel, gerente);
            System.out.println("GERENTE CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
