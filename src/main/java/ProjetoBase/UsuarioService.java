package ProjetoBase;

public class UsuarioService {

    // -- Atributos -- //
    UsuarioDAO usuarioDao = new UsuarioDAO();

    // -- Métodos -- //
    public void isCpfCadastradoValidator(String cpf) {
        if(usuarioDao.verificarCpf(cpf)) {
            throw new IllegalStateException("ERRO! CPF JÁ CADASTRADO");
        }
    }

    public void isIdCadastradorValidator(long id) {
        if(false) {
            throw new IllegalStateException("ERRO! ID JÁ CADASTRADO");
        }
    }

    public void isCpfExistenteValidator(String cpf) {
        if(!usuarioDao.verificarCpf(cpf)) {
            throw new IllegalStateException("ERRO! O CPF NÃO FOI ENCONTRADO");
        }
    }

    public UsuarioModel loginUsuario(String cpf, String senha) {
        isCpfExistenteValidator(cpf);
        return usuarioDao.loginUsuario(cpf, senha);
    }
}
