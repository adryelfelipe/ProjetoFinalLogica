package Views;

import Models.AdminModel;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;
import Repositories.GerenteDAO;
import Util.Ferramentas;
import ProjetoBase.GerenteValidator;
import ProjetoBase.GerenteService;

public class MenuAdminRemoverGerente {

        private static UsuarioService usuarioService = new UsuarioService();
        private static GerenteService gerenteService = new GerenteService();
        private static UsuarioValidator usuarioValidator = new UsuarioValidator();
        private static GerenteDAO gerenteDAO = new GerenteDAO();

        public static void removerGerente(AdminModel adm) {
            boolean verifica = false;
            Long id;
            Ferramentas.limpaTerminal();

            System.out.println("[EXCLUIR]");

            while (!verifica) {
                System.out.print("--- REMOVER GERENTE ---");
                try {
                    id = MenuEscolhaId.escolhaIdUpdate();
                    UsuarioValidator.verificaIntegridadeIdUsuario(id);
                    gerenteDAO.deletarGerente(id);
                    Ferramentas.Delay(500);
                    System.out.println("Gerente deletado");
                    Ferramentas.Delay(1500);
                    verifica = true;

                } catch (RuntimeException e) {
                    Ferramentas.mensagemErro(e.getMessage());
                }
            }
        }
}
