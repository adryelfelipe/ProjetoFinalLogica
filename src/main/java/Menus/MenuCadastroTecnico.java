package Menus;

import ProjetoBase.*;

public class MenuCadastroTecnico
{
    private static final TecnicoService tecnicoService = new TecnicoService();

    public static void menuCadastroTecnico(GerenteModel gerente) {
        System.out.println("================================");
        System.out.println("|      CADASTRO  TÉCNICO        |");
        System.out.println("================================\n");

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        String nome = MenuSetUsuario.MenuSetNome();
        String cpf = MenuSetUsuario.MenuSetCpf();
        String senha = MenuSetUsuario.MenuSetSenha();

        // ----- Atribuição de caracteríscticas de um Técnico ----- //
        int especialidade = MenuSetTecnico.MenuSetEspecialidade();


        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);
        Ferramentas.limpaTerminal();

        try {
            TecnicoModel tecnico = new TecnicoModel(nome, cpf, senha, especialidade);
            tecnicoService.inserirTecnico(gerente, tecnico);
            System.out.println("TÉCNICO CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("ERRO AO INSERIR O USUÁRIO");
        }
    }
}
