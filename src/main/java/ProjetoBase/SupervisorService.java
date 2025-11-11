package ProjetoBase;

import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Nucleo.Funcionario;
import Repositories.SupervisorDAO;
import Repositories.FuncionarioDAO;

public class SupervisorService {
    // -- Atributos -- //
    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private final SupervisorDAO supervisorDAO = new SupervisorDAO();
    private final UsuarioService usuarioService = new UsuarioService();

    // -- Métodos -- //
    public void inserirSupervisor(Funcionario funcionarioInseridor, Supervisor supervisorInserido) {
        UsuarioValidator.temNivelAcesso3(funcionarioInseridor);
        SupervisorValidator.verificarRegrasInsercaoSupervisor(supervisorInserido);
        usuarioService.isCpfCadastradoValidator(supervisorInserido.getCpf().getCpf());
        funcionarioDAO.salvar(supervisorInserido);
        supervisorDAO.salvar(supervisorInserido);
    }

    public void updateMetaMensal(Funcionario funcionario, long id, double metaMensal) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        SupervisorValidator.verificaRegrasMetaMensal(metaMensal);
        SupervisorValidator.verificaIntegridadeMetaMensal(metaMensal);
        supervisorDAO.updateMetaMensal(id, metaMensal);
    }

    public void removerSupervisor(Funcionario funcionarioExecutor, long idSupervisorARemover) {
        UsuarioValidator.temNivelAcesso3(funcionarioExecutor);
        usuarioService.isIdExistenteValidator(idSupervisorARemover);
        supervisorDAO.excluirPorID(idSupervisorARemover);
        funcionarioDAO.excluirPorId(idSupervisorARemover);
    }
}
