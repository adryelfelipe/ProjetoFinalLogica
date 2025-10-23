package ProjetoBase;

public class UsuarioService {

    // -- Métodos -- //
    public void isCpfCadastradoValidator(String cpf) {
        if(false) {  /// ALTERAR PARA VERIFICAÇÃO DE isCpfExistente da DAO
            throw new IllegalStateException("ERRO! CPF JÁ CADASTRADO");
        }
    }

    public void isIdCadastradorValidator(long id) {
        if(false) { /// ALTERAR PARA VERIFICAÇÃO DE isIdExistente da DAO
            throw new IllegalStateException("ERRO! ID JÁ CADASTRADO");
        }
    }
}
