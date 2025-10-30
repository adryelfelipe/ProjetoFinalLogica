package ProjetoBase;

public class SupervisorService {
    // -- Atributos -- //
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final SupervisorDAO supervisorDAO = new SupervisorDAO();
    private final UsuarioService usuarioService = new UsuarioService();
    private final UsuarioValidator usuarioValidator = new UsuarioValidator();
    private final SupervisorValidator supervisorValidator = new SupervisorValidator();


    public void inserirSupervisor(UsuarioModel usuarioInseridor, SupervisorModel supervisorInserido) {
        usuarioValidator.temNivelAcesso3(usuarioInseridor);
        supervisorValidator.verificarRegrasInsercaoSupervisor(supervisorInserido);
        usuarioService.isCpfCadastradoValidator(supervisorInserido.getCpf());
        usuarioDAO.inserirUsuario(supervisorInserido);
        supervisorDAO.inserirSupervisor(supervisorInserido);
    }
}
