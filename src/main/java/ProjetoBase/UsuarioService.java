package ProjetoBase;

import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Repositories.FuncionarioDAO;

public class UsuarioService {

    // -- Atributos -- //
    FuncionarioDAO funcionarioDao = new FuncionarioDAO();

    // -- Métodos -- //
    public void isCpfCadastradoValidator(CPF cpf) {
        if (funcionarioDao.existeCpf(cpf)) {
            throw new IllegalStateException("ERRO! CPF JÁ CADASTRADO");
        }
    }

    public void isIdCadastradoValidator(long id) {
        if (false) {
            throw new IllegalStateException("ERRO! ID JÁ CADASTRADO");
        }
    }

    public void isCpfExistenteValidator(CPF cpf) {
        if (!funcionarioDao.existeCpf(cpf)) {
            throw new IllegalStateException("ERRO! O CPF NÃO FOI ENCONTRADO");
        }
    }

    public void isIdExistenteValidator(long id) {
        if (!funcionarioDao.existeId(id)) {
            throw new IllegalStateException("ERRO! O ID NÃO FOI ENCONTRADO");
        }
    }

    public Funcionario loginUsuario(CPF cpf, String senha) {
        isCpfExistenteValidator(cpf);
        return funcionarioDao.loginUsuario(cpf, senha);
    }

    public Funcionario findById(long id) {
        return funcionarioDao.buscarPorId(id);
    }

    public void updateSenhaUsuario(Funcionario funcionario, long id, Senha senha) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        funcionarioDao.updateSenhaUsuario(id, senha.getSenha());

        if (funcionario.igualMeuId(id)) {
            funcionario.alteraSenha(senha);
        }
    }

    public void updateNomeUsuario(Funcionario funcionario, long id, NomeFuncionario nome) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        funcionarioDao.alterarNomeUsuario(id, nome.getNome());

        if (funcionario.igualMeuId(id)) {
            funcionario.alteraNome(nome);
        }
    }

    public void updateCpfUsuario(Funcionario funcionario, long id, CPF cpf) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        funcionarioDao.updateCpfUsuario(id, cpf.getCpf());

        if (funcionario.igualMeuId(id)) {
            funcionario.alteraCpf(cpf);
        }
    }

    public long getNivelAcessoById(Funcionario funcionario, long idUsuario) {
        UsuarioValidator.temNivelAcesso3(funcionario);
        isIdExistenteValidator(idUsuario);
        return funcionarioDao.nivelAcessoPorID(idUsuario);
    }
}

