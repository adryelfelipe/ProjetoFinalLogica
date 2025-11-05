package ProjetoBase;

import Models.GerenteModel;
import Models.UsuarioModel;
import Models.enumeracoes.Departamento;
import Repositories.GerenteDAO;
import Repositories.UsuarioDAO;

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

    public void updateDepartamento(UsuarioModel usuario, long id, Departamento departamento) {
        UsuarioValidator.temNivelAcesso4(usuario);
        GerenteValidator.verificaRegrasDepartamento(departamento);
        GerenteValidator.verificaIntegridadeDepartamento(departamento);
        gerenteDAO.updateDepartamento(id, departamento);
    }
}
