package Views;

import Models.AdminModel;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;
import Repositories.GerenteDAO;
import Repositories.UsuarioDAO;
import Util.Ferramentas;
import ProjetoBase.GerenteValidator;
import ProjetoBase.GerenteService;

public class MenuAdminRemoverGerente {

        private static UsuarioService usuarioService = new UsuarioService();
        private static UsuarioDAO usuarioDAO = new UsuarioDAO();
        private static GerenteService gerenteService = new GerenteService();
        private static UsuarioValidator usuarioValidator = new UsuarioValidator();
        private static GerenteDAO gerenteDAO = new GerenteDAO();

        public static void removerGerente(AdminModel adm)
        {
            boolean verifica = false;
            Long idGerente;

            while (!verifica)
            {
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃         EXCLUIR GERENTE        ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println(" ");
                try
                {
                    idGerente = MenuEscolhaId.escolhaIdUpdate();
                    UsuarioValidator.verificaIntegridadeIdUsuario(idGerente);
                    UsuarioValidator.temNivelAcesso4(adm);
                    gerenteDAO.deletarGerente(idGerente);
                    usuarioDAO.deletarUsuario(idGerente);

                    Ferramentas.Delay(500);
                    System.out.println("| -----  GERENTE DELETADO  ----- |");
                    Ferramentas.Delay(1500);
                    verifica = true;
                }
                catch (RuntimeException e)
                {
                    Ferramentas.mensagemErro(e.getMessage());
                }
            }
        }
}
