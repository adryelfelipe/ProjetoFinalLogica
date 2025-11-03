package Views;
import Database.*;
import Models.*;
import Repositories.*;
import ProjetoBase.*;
import Util.Ferramentas;
import java.util.InputMismatchException;

public class MenuUpdateGerente {
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final TecnicoService tecnicoService = new TecnicoService();
    private static final SupervisorService supervisorService = new SupervisorService();
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static void menuUpdateEscolha(GerenteModel gerente) {
        // Menu
        boolean verifica = false;
        int opUpdate = 0;

        while(true)
        {

            while(!verifica) {
                System.out.println("|================================|");
                System.out.println("|======== MENU ATUALIZAR  =======|");
                System.out.println("|================================|");

                System.out.print("\n\n"); // pula linhas

                System.out.println("|  1 - Alterar Técnico           |");
                System.out.println("|  2 - Alterar Supervisor        |");
                System.out.println("|  3 - Sair do Menu              |");
                System.out.println("|  Escolha: ");

                try
                {
                    opUpdate = Ferramentas.lInteiro();
                    verifica = true;
                }
                catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch(opUpdate) {
                case 1 -> menuUpdateTecnico(gerente);
                case 2 -> menuUpdateSupervisor(gerente);
                case 3 -> {return;}

                default -> Ferramentas.mensagemErro("ERRO! TENTE NOVAMENTE!");
            }
        }
    }

    public static void menuUpdateTecnico(GerenteModel gerente) {
            // -- Garantia de inicialização -- //
        long idTecnico;
        int UpdateT = 0;
        boolean verifica = false;

        try
        {
            idTecnico = MenuEscolhaId.escolhaIdUpdate();
        } catch (InputMismatchException e)
        {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        TecnicoModel tecnico = ((TecnicoModel) usuarioService.findById(idTecnico));

        while(true)
        {

            while(!verifica)
            {

                System.out.print("\n\n"); // pula linhas
                System.out.println("          |================================|          ");
                System.out.println("          |======  ATUALIZAR TECNICO  =====|          ");
                System.out.println("          |================================|          ");
                System.out.println("");
                System.out.println("|--------------------|         |--------------------|");
                System.out.println("|  EDITAR   TÉCNICO  |         |        ATUAL       |");
                System.out.println("|--------------------|         |--------------------|");
                System.out.println("|  1 - Nome          |         |Nome: " + tecnico.getNome());
                System.out.println("|  2 - CPF           |         |CPF: " + tecnico.getCpf());
                System.out.println("|  3 - Senha         |         |Senha: " + tecnico.getSenha());
                System.out.println("|  5 - Especialidade |         |Especialidade: " + tecnico.getEspecialidade());
                System.out.println("|  6 - Sair do Menu  |");
                System.out.println("|  Escolha:  ");

                try
                {
                    UpdateT = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch(UpdateT) {
                case 1 -> {
                    String nome = MenuSetUsuario.MenuSetNome();
                    usuarioService.updateNomeUsuario(gerente, idTecnico, nome);
                    tecnico.setNome(nome);
                }

                case 2 -> {
                    String cpf = MenuSetUsuario.MenuSetCpf();
                    usuarioService.updateCpfUsuario(gerente, idTecnico, cpf);
                    tecnico.setCpf(cpf);
                }

                case 3 -> {
                    String senha = MenuSetUsuario.MenuSetSenha();
                    usuarioService.updateSenhaUsuario(gerente, idTecnico, senha);
                    tecnico.setSenha(senha);
                }
                case 4 -> {
                    int especialidade = MenuSetTecnico.MenuSetEspecialidade();
                    tecnicoService.updateEspecialidade(gerente, idTecnico, especialidade);
                    tecnico.setEspecialidade(especialidade);
                }
                case 5 ->
                {
                    return;
                }
                default -> Ferramentas.menuDefault();
            }
        }
    }
    public static void menuUpdateSupervisor(GerenteModel gerenteModel)
    {
        long idSupervisor;
        int UpdateS = 0;
        boolean verifica = false;

        try
        {
            idSupervisor = MenuEscolhaId.escolhaIdUpdate();
        }
        catch (InputMismatchException e)
        {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        SupervisorModel supervisor = ((SupervisorModel) usuarioService.findById(idSupervisor));

        while(true)
        {
            while(!verifica)
            {
                System.out.println("\n\n");
                System.out.println("             |================================|            ");
                System.out.println("             |====  ATUALIZAR SUPERVISOR  ====|            ");
                System.out.println("             |================================|            ");
                System.out.println("");
                System.out.println("|-----------------------|         |-----------------------|");
                System.out.println("|  EDITAR   SUPERVISOR  |         |         ATUAL         |");
                System.out.println("|-----------------------|         |-----------------------|");
                System.out.println("|  1 - Nome             |         |Nome: " + supervisor.getNome());
                System.out.println("|  2 - CPF              |         |CPF: " + supervisor.getCpf());
                System.out.println("|  3 - Senha            |         |Senha: " + supervisor.getSenha());
                System.out.println("|  5 - Meta Mensal      |         |Meta Mensal: " + supervisor.getMetaMensal());
                System.out.println("|  6 - Sair do Menu     |");
                System.out.println("|  Escolha:  ");

                try
                {
                    UpdateS = Ferramentas.lInteiro();
                    verifica = true;
                }
                catch (InputMismatchException e)
                {
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch(UpdateS)
            {
                case 1 -> {
                    String nome = MenuSetUsuario.MenuSetNome();
                    usuarioService.updateNomeUsuario(gerenteModel, idSupervisor, nome);
                    supervisor.setNome(nome);
                }

                case 2 -> {
                    String cpf = MenuSetUsuario.MenuSetCpf();
                    usuarioService.updateCpfUsuario(gerenteModel, idSupervisor, cpf);
                    supervisor.setCpf(cpf);
                }

                case 3 -> {
                    String senha = MenuSetUsuario.MenuSetSenha();
                    usuarioService.updateSenhaUsuario(gerenteModel, idSupervisor, senha);
                    supervisor.setSenha(senha);
                }
                case 4 -> {
                    double metaMensal = MenuSetSupervisor.MenuSetMetaMensal();
                    supervisorService.updateMetaMensal(gerenteModel, idSupervisor, metaMensal);
                    supervisor.setMetaMensal(metaMensal);
                }
                case 5 ->
                {
                    return;
                }

                default -> Ferramentas.menuDefault();
            }
        }
    }
}
