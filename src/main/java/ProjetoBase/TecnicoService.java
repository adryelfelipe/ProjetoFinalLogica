package ProjetoBase;

import Dominio.Entidades.Tecnico;
import Dominio.Entidades.Usuario;
import Dominio.Enumeracoes.Especialidade;
import Repositories.TecnicoDAO;
import Repositories.UsuarioDAO;

public class TecnicoService {

    // -- Atributos -- //
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    UsuarioService usuarioService = new UsuarioService();


    public void inserirTecnico(Usuario usuarioInseridor, Tecnico tecnicoInserido) {
        UsuarioValidator.temNivelAcesso3(usuarioInseridor);
        TecnicoValidator.verificaRegrasInsercaoTecnico(tecnicoInserido);
        usuarioService.isCpfCadastradoValidator(tecnicoInserido.getCpf());
        usuarioDAO.inserirUsuario(tecnicoInserido);
        tecnicoDAO.inserirTecnico(tecnicoInserido);
    }

    public void updateEspecialidade(Usuario usuario, long id, Especialidade especialidade) {
        UsuarioValidator.temNivelAcesso3(usuario);
        TecnicoValidator.verificaIntegridadeEspecialidade(especialidade);
        TecnicoValidator.verificaRegrasEspecialidade(especialidade);
        tecnicoDAO.updateEspecialidadeTecnico(id, especialidade);
    }

    public void removerTecnico(Usuario usuarioExecutor, long idTecnicoARemover) {
        UsuarioValidator.temNivelAcesso3(usuarioExecutor);
        usuarioService.isIdExistenteValidator(idTecnicoARemover);
        tecnicoDAO.deletarTecnico(idTecnicoARemover);
        usuarioDAO.deletarUsuario(idTecnicoARemover);
    }
}
