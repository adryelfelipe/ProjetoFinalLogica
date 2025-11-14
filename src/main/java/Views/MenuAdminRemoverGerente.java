package Views;

import Models.Administrador;
import Service.UsuarioService;
import Util.Ferramentas;

public class MenuAdminRemoverGerente {

    private static final UsuarioService usuarioService = new UsuarioService();

    public static void menuRemoverEscolha(Administrador administrador) {
        try {
            long id = MenuEscolhaId.escolhaIdUpdate();
            long nivelAcesso = usuarioService.getNivelAcessoById(administrador, id);

            if(nivelAcesso == 3) {
                usuarioService.excluirGerente(administrador,id);
            }
        } catch (IllegalStateException | IllegalArgumentException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
