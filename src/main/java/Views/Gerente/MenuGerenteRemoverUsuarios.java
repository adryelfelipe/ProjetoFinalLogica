package Views.Gerente;

import Dominio.Funcionario.Gerente.Gerente;
import ProjetoBase.*;
import Util.Ferramentas;
import Views.MenuEscolhaId;

public class MenuGerenteRemoverUsuarios {

    private static final UsuarioService usuarioService = new UsuarioService();
    private static final TecnicoService tecnicoService = new TecnicoService();
    private static final SupervisorService supervisorService = new SupervisorService();

    public static void menuRemoverEscolha(Gerente gerente) {
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
