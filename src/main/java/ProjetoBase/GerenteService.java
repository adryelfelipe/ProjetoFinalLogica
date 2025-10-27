package ProjetoBase;

public class GerenteService {

    // -- Atributos -- //
    private final UsuarioDAO usuarioDao = new UsuarioDAO();
    private final GerenteDAO gerenteDAO = new GerenteDAO();
    private final UsuarioService usuarioService = new UsuarioService();
    private final UsuarioValidator usuarioValidator = new UsuarioValidator();
    private final GerenteValidator gerenteValidator = new GerenteValidator();


    public void inserirGerente(UsuarioModel usuarioInseridor, GerenteModel gerenteInserido) {
        usuarioValidator.temNivelAcesso4(usuarioInseridor);
        gerenteValidator.verificaRegrasInsercaoGerente(gerenteInserido);
        usuarioService.isCpfCadastradoValidator(gerenteInserido.getCpf());
        usuarioDao.inserirUsuario(gerenteInserido);
        gerenteDAO.inserirGerente(gerenteInserido);
    }
}
