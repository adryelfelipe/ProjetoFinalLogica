package ProjetoBase;

import Dominio.Maquina.Maquina;
import Dominio.Funcionario.Funcionario.Funcionario;
import Repositories.MaquinaDAO;

public class MaquinaService {
    // -- Atributos -- //
    private final MaquinaDAO maquinaDAO = new MaquinaDAO();

    // -- Métodos -- //
    public void inserirMaquina(Funcionario funcionarioInseridor, Maquina maquina) {
        UsuarioValidator.temNivelAcesso3(funcionarioInseridor);
        MaquinaValidator.verificaRegrasInsercaoMaquina(maquina);
        maquinaDAO.inserirMaquina(maquina);
    }

    public void isIdExistenteValidator(long id) {
        if(!maquinaDAO.existeID(id)) {
            throw new IllegalStateException("ERRO! O ID DA MÁQUINA NÃO FOI ENCONTRADO");
        }
    }
}
