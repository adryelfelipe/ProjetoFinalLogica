package Views;

import Models.AdminModel;
import Models.GerenteModel;
import ProjetoBase.*;
import Repositories.GerenteDAO;
import Repositories.SupervisorDAO;
import Repositories.TecnicoDAO;
import Repositories.UsuarioDAO;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuGerenteRemoverUsuarios {

    private static final UsuarioService usuarioService = new UsuarioService();
    private static final TecnicoService tecnicoService = new TecnicoService();
    private static final SupervisorService supervisorService = new SupervisorService();

    public static void menuRemoverEscolha(GerenteModel gerente) {
        try {
            long id = MenuEscolhaId.escolhaIdUpdate();
            long nivelAcesso = usuarioService.getNivelAcessoById(gerente, id);

            if(nivelAcesso == 1) {
                tecnicoService.removerTecnico(gerente,id);
            } else if (nivelAcesso == 2) {
                supervisorService.removerSupervisor(gerente,id);
            }
        } catch (IllegalStateException | IllegalArgumentException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
