package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.GerenteModel;
import ProjetoBase.MaquinaModel;

public class MenuCadastroMaquina {
    public static void menuCadastroMaquina(GerenteModel gerente) {
        System.out.println("================================");
        System.out.println("|      CADASTRO  TÉCNICO        |");
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
            maquinaS.inserirTecnico(gerente, tecnico);
            System.out.println("TÉCNICO CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
}
