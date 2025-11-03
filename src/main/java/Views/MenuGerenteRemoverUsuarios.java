package Views;

import Models.AdminModel;
import Models.GerenteModel;
import ProjetoBase.GerenteService;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;
import Repositories.GerenteDAO;
import Repositories.SupervisorDAO;
import Repositories.TecnicoDAO;
import Repositories.UsuarioDAO;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuGerenteRemoverUsuarios {

    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static TecnicoDAO tecnicoDAO = new TecnicoDAO();
    private static SupervisorDAO supervisorDAO = new SupervisorDAO();

    public static void menuRemoverEscolha(GerenteModel gerente) {
        // Menu
        boolean verifica = false;
        int opRemover = 0;

        while(true)
        {

            while(!verifica) {
                System.out.println("|================================|");
                System.out.println("|======== MENU REMOVER  =======|");
                System.out.println("|================================|");

                System.out.print("\n\n"); // pula linhas

                System.out.println("|  1 - REMOVER TÉCNICO           |");
                System.out.println("|  2 - REMOVER SUPERVISOR        |");
                System.out.println("|  3 - SAIR DO MENU              |");
                System.out.println("|  Escolha: ");

                try
                {
                    opRemover = Ferramentas.lInteiro();
                    verifica = true;
                }
                catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch(opRemover) {
                case 1 ->removerTecnico(gerente);
                case 2 -> removerSupervisor(gerente);
                case 3 -> {return;}

                default -> Ferramentas.mensagemErro("ERRO! TENTE NOVAMENTE!");
            }
        }
    }

    public static void removerTecnico(GerenteModel gerente) {
        boolean verifica = false;
        long id;
        Ferramentas.limpaTerminal();

        System.out.println("[EXCLUIR]");

        while (!verifica) {
            System.out.print("--- REMOVER TÉCNICO ---");
            try {
                id = MenuEscolhaId.escolhaIdUpdate();
                UsuarioValidator.verificaIntegridadeIdUsuario(id);
                UsuarioValidator.temNivelAcesso3(gerente);
                usuarioDAO.deletarUsuario(id);
                tecnicoDAO.deletarTecnico(id);

                Ferramentas.Delay(500);
                System.out.println("Técnico deletado");
                Ferramentas.Delay(1500);
                verifica = true;

            } catch (RuntimeException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    public static void removerSupervisor(GerenteModel gerente) {
        boolean verifica = false;
        long id;
        Ferramentas.limpaTerminal();

        System.out.println("[EXCLUIR]");

        while (!verifica) {
            System.out.print("--- REMOVER SUPERVISOR ---");
            try {
                id = MenuEscolhaId.escolhaIdUpdate();
                UsuarioValidator.verificaIntegridadeIdUsuario(id);
                UsuarioValidator.temNivelAcesso3(gerente);
                usuarioDAO.deletarUsuario(id);
                supervisorDAO.deletarSupervisor(id);

                Ferramentas.Delay(500);
                System.out.println("Supervisor deletado");
                Ferramentas.Delay(1500);
                verifica = true;

            } catch (RuntimeException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
