package ProjetoBase;

import Models.SupervisorModel;
import Models.UsuarioModel;
import Repositories.SupervisorDAO;
import Repositories.UsuarioDAO;

public class SupervisorService {
    // -- Atributos -- //
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final SupervisorDAO supervisorDAO = new SupervisorDAO();
    private final UsuarioService usuarioService = new UsuarioService();

    // -- Métodos -- //
    public void inserirSupervisor(UsuarioModel usuarioInseridor, SupervisorModel supervisorInserido) {
        UsuarioValidator.temNivelAcesso3(usuarioInseridor);
        SupervisorValidator.verificarRegrasInsercaoSupervisor(supervisorInserido);
        usuarioService.isCpfCadastradoValidator(supervisorInserido.getCpf());
        usuarioDAO.inserirUsuario(supervisorInserido);
        supervisorDAO.inserirSupervisor(supervisorInserido);
    }

    public void updateMetaMensal(UsuarioModel usuario, long id, double metaMensal) {
        UsuarioValidator.temNivelAcesso3(usuario);
        SupervisorValidator.verificaRegrasMetaMensal(metaMensal);
        SupervisorValidator.verificaIntegridadeMetaMensal(metaMensal);
        supervisorDAO.updateMetaMensal(id, metaMensal);
    }

    public void removerSupervisor(UsuarioModel usuarioExecutor, long idSupervisorARemover) {
        UsuarioValidator.temNivelAcesso3(usuarioExecutor);
        usuarioService.isIdExistenteValidator(idSupervisorARemover);
        supervisorDAO.deletarSupervisor(idSupervisorARemover);
        usuarioDAO.deletarUsuario(idSupervisorARemover);
    }
}
