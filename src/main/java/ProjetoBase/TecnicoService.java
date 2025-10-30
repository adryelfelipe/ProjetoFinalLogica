package ProjetoBase;

public class TecnicoService {

    // -- Atributos -- //
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    UsuarioService usuarioService = new UsuarioService();
    UsuarioValidator usuarioValidator = new UsuarioValidator();
    TecnicoValidator tecnicoValidator = new TecnicoValidator();


    public void inserirTecnico(UsuarioModel usuarioInseridor, TecnicoModel tecnicoInserido) {
        usuarioValidator.temNivelAcesso3(usuarioInseridor);
        tecnicoValidator.verificaRegrasInsercaoTecnico(tecnicoInserido);
        usuarioService.isCpfCadastradoValidator(tecnicoInserido.getCpf());
        usuarioDAO.inserirUsuario(tecnicoInserido);
        tecnicoDAO.inserirTecnico(tecnicoInserido);
    }
}
