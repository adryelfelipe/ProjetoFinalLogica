package ProjetoBase;

import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Funcionario;
import Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Repositories.GerenteDAO;
import Repositories.FuncionarioDAO;

public class GerenteService {

    // -- Atributos -- //
    private final FuncionarioDAO funcionarioDao = new FuncionarioDAO();
    private final GerenteDAO gerenteDAO = new GerenteDAO();
    private final UsuarioService usuarioService = new UsuarioService();

    // -- Métodos -- //
    public void inserirGerente(Funcionario funcionarioInseridor, Gerente gerenteInserido) {
        UsuarioValidator.temNivelAcesso4(funcionarioInseridor);
        GerenteValidator.verificaRegrasInsercaoGerente(gerenteInserido);
        usuarioService.isCpfCadastradoValidator(gerenteInserido.getCpf().getCpf());
        funcionarioDao.salvar(gerenteInserido);
        gerenteDAO.salvar(gerenteInserido);
    }

    public void updateDepartamento(Funcionario funcionario, long id, ListaDepartamentos departamento) {
        UsuarioValidator.temNivelAcesso4(funcionario);
        gerenteDAO.updateDepartamento(id, departamento);
    }

    public void removerGerente(Funcionario funcionarioExecutor, long idGerenteARemover) {
        UsuarioValidator.temNivelAcesso4(funcionarioExecutor);
        usuarioService.isIdExistenteValidator(idGerenteARemover);
        gerenteDAO.excluirPorID(idGerenteARemover);
        funcionarioDao.excluirPorId(idGerenteARemover);
    }
}
