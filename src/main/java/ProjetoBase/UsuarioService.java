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
        if(false) { /// ALTERAR PARA VERIFICAÇÃO DE isIdExistente da DAO
            throw new IllegalStateException("ERRO! ID JÁ CADASTRADO");
        }
    }
}
