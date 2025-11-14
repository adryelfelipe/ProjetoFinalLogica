package Views;

import Models.Gerente;
import Service.UsuarioService;
import Util.Ferramentas;

public class MenuGerenteRemoverUsuarios {

    private static final UsuarioService usuarioService = new UsuarioService();

    public static void menuRemoverEscolha(Gerente gerente) {
        try {
            long id = MenuEscolhaId.escolhaIdUpdate();
            long nivelAcesso = usuarioService.getNivelAcessoById(gerente, id);

           usuarioService.excluirFuncionarios(gerente, id);
        } catch (IllegalStateException | IllegalArgumentException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
