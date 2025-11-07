package ProjetoBase;

import Models.TecnicoModel;
import Models.UsuarioModel;
import Models.joias.Especialidade;
import Repositories.TecnicoDAO;
import Repositories.UsuarioDAO;

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

    public void updateEspecialidade(UsuarioModel usuario, long id, Especialidade especialidade) {
        UsuarioValidator.temNivelAcesso3(usuario);
        TecnicoValidator.verificaIntegridadeEspecialidade(especialidade);
        TecnicoValidator.verificaRegrasEspecialidade(especialidade);
        tecnicoDAO.updateEspecialidadeTecnico(id, especialidade);
    }

    public void removerTecnico(UsuarioModel usuarioExecutor, long idTecnicoARemover) {
        UsuarioValidator.temNivelAcesso3(usuarioExecutor);
        usuarioService.isIdExistenteValidator(idTecnicoARemover);
        tecnicoDAO.deletarTecnico(idTecnicoARemover);
        usuarioDAO.deletarUsuario(idTecnicoARemover);
    }
}
