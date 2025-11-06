package ProjetoBase;

import Models.UsuarioModel;
import Models.joias.NivelAcesso;
import Repositories.UsuarioDAO;

public class UsuarioService {

    // -- Atributos -- //
    UsuarioDAO usuarioDao = new UsuarioDAO();

    // -- Métodos -- //
    public void isCpfCadastradoValidator(String cpf) {
        if (usuarioDao.verificarCpf(cpf)) {
            throw new IllegalStateException("ERRO! CPF JÁ CADASTRADO");
        }
    }

    public void isIdCadastradorValidator(long id) {
        if (false) {
            throw new IllegalStateException("ERRO! ID JÁ CADASTRADO");
        }
    }

    public void isCpfExistenteValidator(String cpf) {
        if (!usuarioDao.verificarCpf(cpf)) {
            throw new IllegalStateException("ERRO! O CPF NÃO FOI ENCONTRADO");
        }
    }

    public void isIdExistenteValidator(long id) {
        if (!usuarioDao.verificarId(id)) {
            throw new IllegalStateException("ERRO! O ID NÃO FOI ENCONTRADO");
        }
    }

    public UsuarioModel loginUsuario(String cpf, String senha) {
        isCpfExistenteValidator(cpf);
        return usuarioDao.loginUsuario(cpf, senha);
    }

    public UsuarioModel findById(long id) {
        return usuarioDao.findById(id);
    }

    public void updateSenhaUsuario(UsuarioModel usuario, long id, String senha) {
        UsuarioValidator.temNivelAcesso3(usuario);
        UsuarioValidator.verificarRegrasSenha(senha);
        UsuarioValidator.verificaIntegridadeSenha(senha);
        usuarioDao.updateSenhaUsuario(id, senha);

        if (UsuarioValidator.isAutoUpdate(usuario.getIdUsuario(), id)) {
            usuario.setSenha(senha);
        }
    }

    public void updateNomeUsuario(UsuarioModel usuario, long id, String nome) {
        UsuarioValidator.temNivelAcesso3(usuario);
        UsuarioValidator.verificaIntegridadeNome(nome);
        UsuarioValidator.verificaRegrasNome(nome);
        usuarioDao.updateNomeUsuario(id, nome);

        if (UsuarioValidator.isAutoUpdate(usuario.getIdUsuario(), id)) {
            usuario.setNome(nome);
        }
    }

    public void updateCpfUsuario(UsuarioModel usuario, long id, String cpf) {
        UsuarioValidator.temNivelAcesso3(usuario);
        UsuarioValidator.verificaIntegridadeCpf(cpf);
        UsuarioValidator.verificarRegrasCpf(cpf);
        usuarioDao.updateCpfUsuario(id, cpf);

        if (UsuarioValidator.isAutoUpdate(usuario.getIdUsuario(), id)) {
            usuario.setCpf(cpf);
        }
    }

    public long getNivelAcessoById(UsuarioModel usuario, long idUsuario) {
        UsuarioValidator.temNivelAcesso3(usuario);
        isIdExistenteValidator(idUsuario);
        return usuarioDao.getNivelAcessoByID(idUsuario);
    }
}

