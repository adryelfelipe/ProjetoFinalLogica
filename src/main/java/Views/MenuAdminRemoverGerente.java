package Views;

import Models.AdminModel;
import Models.GerenteModel;
import ProjetoBase.*;
import Repositories.GerenteDAO;
import Repositories.UsuarioDAO;
import Util.Ferramentas;

public class MenuAdminRemoverGerente {

    private static final UsuarioService usuarioService = new UsuarioService();
    private static final GerenteService gerenteService = new GerenteService();

    public static void menuRemoverEscolha(AdminModel administrador) {
        try {
            long id = MenuEscolhaId.escolhaIdUpdate();
            long nivelAcesso = usuarioService.getNivelAcessoById(administrador, id);

            if(nivelAcesso == 3) {
                gerenteService.removerGerente(administrador,id);
            }
        } catch (IllegalStateException | IllegalArgumentException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
