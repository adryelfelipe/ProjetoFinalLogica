package Service;

import DAO.FuncionarioDAO;
import Models.Funcionario;
import Service.Validator.UsuarioValidator;

public class UsuarioService {

    // -- Atributos -- //
    FuncionarioDAO usuarioDao = new FuncionarioDAO();

    // -- Métodos -- //
    public void isCpfCadastradoValidator(String cpf) {
        if (usuarioDao.existeCpf(cpf)) {
            throw new IllegalStateException("ERRO! CPF JÁ CADASTRADO");
        }
    }

    public void isIdCadastradorValidator(long id) {
        if (usuarioDao.existeId(id)) {
            throw new IllegalStateException("ERRO! ID JÁ CADASTRADO");
        }
    }

    public void isCpfExistenteValidator(String cpf) {
        if (!usuarioDao.existeCpf(cpf)) {
            throw new IllegalStateException("ERRO! O CPF NÃO FOI ENCONTRADO");
        }
    }

    public void isIdExistenteValidator(long id) {
        if (!usuarioDao.existeId(id)) {
            throw new IllegalStateException("ERRO! O ID NÃO FOI ENCONTRADO");
        }
    }

    public Funcionario loginUsuario(String cpf, String senha) {
        Funcionario funcionario = usuarioDao.buscar(cpf);
        if(funcionario == null) {
            throw new IllegalStateException("ERRO! SENHA OU CPF INVÁLIDOS");
        }

        if(funcionario.getSenha().equals(senha)) {
            return  funcionario;
        }

        throw new IllegalStateException("ERRO! SENHA OU CPF INVÁLIDOS");
    }

    public Funcionario findById(long id) {
        return usuarioDao.buscar(id);
    }

    public void atualizar(Funcionario funcionario, Funcionario funcionarioAtualizado) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        usuarioDao.atualizar(funcionarioAtualizado);
    }

    public long getNivelAcessoById(Funcionario funcionario, long idUsuario) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        isIdExistenteValidator(idUsuario);
        return usuarioDao.nivelAcessoPorID(idUsuario).getId();
    }

    public void salvarGerente(Funcionario funcionario, Funcionario cadastrado) {
        UsuarioValidator.temNivelAcesso4(funcionario);
        isCpfCadastradoValidator(cadastrado.getCpf());
        usuarioDao.salvar(cadastrado);
    }

    public void salvarTecnico(Funcionario funcionario, Funcionario cadastrado) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        isCpfCadastradoValidator(cadastrado.getCpf());
        usuarioDao.salvar(cadastrado);
    }

    public void salvarSupervisor(Funcionario funcionario, Funcionario cadastrado) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        isCpfCadastradoValidator(cadastrado.getCpf());;
        usuarioDao.salvar(cadastrado);
    }

    public boolean excluirGerente(Funcionario funcionario, long id) {
        UsuarioValidator.temNivelAcesso4(funcionario);
        return usuarioDao.excluir(id);
    }

    public boolean excluirFuncionarios(Funcionario funcionario, long id) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        return usuarioDao.excluir(id);
    }
}

