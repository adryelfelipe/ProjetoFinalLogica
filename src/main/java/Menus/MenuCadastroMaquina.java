package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.GerenteModel;
import ProjetoBase.MaquinaModel;
import ProjetoBase.MaquinaService;

public class MenuCadastroMaquina {
    private static final MaquinaService maquinaService = new MaquinaService();

    public static void menuCadastroMaquina(GerenteModel gerente) {
        System.out.println("================================");
        System.out.println("|      CADASTRO  MÁQUINA       |");
        System.out.println("================================\n");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        String nome = MenuSetMaquina.MenuSetNomeMaquina();
        String localizacao = MenuSetMaquina.MenuSetLocalizacao();
        int idStatus = MenuSetMaquina.MenuSetStatusMaquina();


        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);
        Ferramentas.limpaTerminal();

        try {
            MaquinaModel maquina = new MaquinaModel(nome, localizacao, idStatus);
            maquinaService.inserirMaquina(gerente, maquina);
            System.out.println("MÁQUINA CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}

