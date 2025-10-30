package ProjetoBase;

public class GerenteService {

    // -- Atributos -- //
    private final UsuarioDAO usuarioDao = new UsuarioDAO();
    private final GerenteDAO gerenteDAO = new GerenteDAO();
    private final UsuarioService usuarioService = new UsuarioService();

    // -- Métodos -- //
    public void inserirGerente(UsuarioModel usuarioInseridor, GerenteModel gerenteInserido) {
        UsuarioValidator.temNivelAcesso4(usuarioInseridor);
        GerenteValidator.verificaRegrasInsercaoGerente(gerenteInserido);
        usuarioService.isCpfCadastradoValidator(gerenteInserido.getCpf());
        usuarioDao.inserirUsuario(gerenteInserido);
        gerenteDAO.inserirGerente(gerenteInserido);
    }
}
