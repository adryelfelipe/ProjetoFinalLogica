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
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static void menuUpdateEscolha(GerenteModel gerente) {
        // Menu
        boolean verifica = false;
        int opUpdate = 0;

        while(true) {

            while(!verifica) {
                System.out.println("     -----------------------------");
                System.out.println("     ----      MENU UPDATE    ----");
                System.out.println("     -----------------------------");

                System.out.print("\n\n"); // pula linhas

                System.out.println("1 - Alterar Técnico");
                System.out.println("2 - Alterar Supervisor");
                System.out.println("3 - SAIR DO MENU");
                try {
                    opUpdate = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch(opUpdate) {
                case 1 -> menuUpdateTecnico(gerente);
                case 2 -> menuUpdateSupervisor(gerente);
                case 3 -> {return;}

                default -> Ferramentas.mensagemErro("ERRO, TENTE NOVAMENTE!");
            }
        }
    }

    public static void menuUpdateTecnico(GerenteModel gerente) {
            // -- Garantia de inicialização -- //
            long idTecnico;

            // Menu de escolha de ID
            Ferramentas.limpaTerminal();

            try {
                idTecnico = MenuEscolhaId.escolhaIdUpdate();
            } catch (InputMismatchException e) {
                Ferramentas.mensagemErro(e.getMessage());
                return;
            }

            try{
//                  TecnicoService(idTecnico);
            } catch (InputMismatchException e) {
                Ferramentas.mensagemErro(e.getMessage());
                return;
            }

            TecnicoModel tecnico = ((TecnicoModel) usuarioDAO.findById(idTecnico));

            // -- Menu de escolha da mudança -- //
            int UpdateT = 0;
            boolean verifica = false;

        while(true) {

            while(!verifica) {

                System.out.print("\n\n"); // pula linhas
                System.out.println("       -------------------           -----------------");
                System.out.println("       |EDITAR   TÉCNICO|                  |ATUAL|"    );
                System.out.println("       -------------------           -------------------");
                System.out.println(" [1] - Nome                          |Nome: " );
                System.out.println(" [2] - CPF                           |CPF: " );
                System.out.println(" [3] - Senha                         |Senha: " );
                System.out.println(" [4] - Email                         |Email: " );
                System.out.println(" [5] - Especialidade                 |Especialidade: ");
                System.out.println(" [6] - SAIR DO MENU");
                try {
                    UpdateT = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch(UpdateT) {
                case 1:{

                }
                case 2:{

                }
                case 3 :{

                }
                case 4:{

                }
                case 5 :{
                    return;
                }
            }
        }
    }
    public static void menuUpdateSupervisor(GerenteModel gerenteModel) {

    }
}
