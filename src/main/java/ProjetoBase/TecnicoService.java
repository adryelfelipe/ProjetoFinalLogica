package ProjetoBase;

import Dominio.Funcionario.Tecnico.Tecnico;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Repositories.TecnicoDAO;
import Repositories.FuncionarioDAO;

public class TecnicoService {

    // -- Atributos -- //
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    UsuarioService usuarioService = new UsuarioService();


    public void inserirTecnico(Funcionario funcionarioInseridor, Tecnico tecnicoInserido) {
        UsuarioValidator.temNivelAcesso3(funcionarioInseridor);
        TecnicoValidator.verificaRegrasInsercaoTecnico(tecnicoInserido);
        usuarioService.isCpfCadastradoValidator(tecnicoInserido.getCpf().getCpf());
        funcionarioDAO.salvar(tecnicoInserido);
        tecnicoDAO.salvar(tecnicoInserido);
    }

    public void updateEspecialidade(Funcionario funcionario, long id, Especialidade especialidade) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        TecnicoValidator.verificaIntegridadeEspecialidade(especialidade);
        TecnicoValidator.verificaRegrasEspecialidade(especialidade);
        tecnicoDAO.updateEspecialidadeTecnico(id, especialidade);
    }

    public void removerTecnico(Funcionario funcionarioExecutor, long idTecnicoARemover) {
        UsuarioValidator.temNivelAcesso3(funcionarioExecutor);
        usuarioService.isIdExistenteValidator(idTecnicoARemover);
        tecnicoDAO.excluirPorID(idTecnicoARemover);
        funcionarioDAO.excluirPorID(idTecnicoARemover);
    }
}
