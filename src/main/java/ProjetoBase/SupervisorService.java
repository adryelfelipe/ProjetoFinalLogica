package ProjetoBase;

import Dominio.Entidades.Supervisor;
import Dominio.Entidades.Usuario;
import Repositories.SupervisorDAO;
import Repositories.UsuarioDAO;

public class SupervisorService {
    // -- Atributos -- //
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final SupervisorDAO supervisorDAO = new SupervisorDAO();
    private final UsuarioService usuarioService = new UsuarioService();

    // -- Métodos -- //
    public void inserirSupervisor(Usuario usuarioInseridor, Supervisor supervisorInserido) {
        UsuarioValidator.temNivelAcesso3(usuarioInseridor);
        SupervisorValidator.verificarRegrasInsercaoSupervisor(supervisorInserido);
        usuarioService.isCpfCadastradoValidator(supervisorInserido.getCpf());
        usuarioDAO.inserirUsuario(supervisorInserido);
        supervisorDAO.inserirSupervisor(supervisorInserido);
    }

    public void updateMetaMensal(Usuario usuario, long id, double metaMensal) {
        UsuarioValidator.temNivelAcesso3(usuario);
        SupervisorValidator.verificaRegrasMetaMensal(metaMensal);
        SupervisorValidator.verificaIntegridadeMetaMensal(metaMensal);
        supervisorDAO.updateMetaMensal(id, metaMensal);
    }

    public void removerSupervisor(Usuario usuarioExecutor, long idSupervisorARemover) {
        UsuarioValidator.temNivelAcesso3(usuarioExecutor);
        usuarioService.isIdExistenteValidator(idSupervisorARemover);
        supervisorDAO.deletarSupervisor(idSupervisorARemover);
        usuarioDAO.deletarUsuario(idSupervisorARemover);
    }
}
