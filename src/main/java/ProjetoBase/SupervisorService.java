package ProjetoBase;

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
}
