package ProjetoBase;

public class TecnicoService {

    // -- Atributos -- //
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    UsuarioService usuarioService = new UsuarioService();
    UsuarioValidator usuarioValidator = new UsuarioValidator(usuarioService);
    TecnicoValidator tecnicoValidator = new TecnicoValidator(usuarioValidator);
    NivelAcessoValidator nivelAcessoValidator = new NivelAcessoValidator();


    public void inserirTecnico(UsuarioModel usuarioInseridor, TecnicoModel tecnicoInserido) {
        nivelAcessoValidator.temNivelAcesso3(usuarioInseridor);
        tecnicoValidator.verificaRegrasInsercaoTecnico(tecnicoInserido);
        usuarioService.isCpfCadastradoValidator(tecnicoInserido.getCpf());
        usuarioDAO.inserirUsuario(tecnicoInserido);
        tecnicoDAO.inserirTecnico(tecnicoInserido);
    }
}
