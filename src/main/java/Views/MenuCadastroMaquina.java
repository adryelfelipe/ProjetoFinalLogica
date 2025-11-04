package Views;

import Util.Ferramentas;
import Models.GerenteModel;
import Models.MaquinaModel;
import ProjetoBase.MaquinaService;

public class MenuCadastroMaquina {
    private static final MaquinaService maquinaService = new MaquinaService();

    public static void menuCadastroMaquina(GerenteModel gerente) {
        System.out.println("|================================|");
        System.out.println("|       CADASTRO  MÁQUINA        |");
        System.out.println("|================================|\n");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        String nome = MenuSetMaquina.MenuSetNomeMaquina();
        Ferramentas.limpaTerminal();

        String localizacao = MenuSetMaquina.MenuSetLocalizacao();
        Ferramentas.limpaTerminal();

        int idStatus = MenuSetMaquina.MenuSetStatusMaquina();
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
}

