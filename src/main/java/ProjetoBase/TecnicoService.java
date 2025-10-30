package ProjetoBase;

public class TecnicoService {

    // -- Atributos -- //
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    UsuarioService usuarioService = new UsuarioService();


    public void inserirTecnico(UsuarioModel usuarioInseridor, TecnicoModel tecnicoInserido) {
        UsuarioValidator.temNivelAcesso3(usuarioInseridor);
        TecnicoValidator.verificaRegrasInsercaoTecnico(tecnicoInserido);
        usuarioService.isCpfCadastradoValidator(tecnicoInserido.getCpf());
        usuarioDAO.inserirUsuario(tecnicoInserido);
        tecnicoDAO.inserirTecnico(tecnicoInserido);
    }
}
