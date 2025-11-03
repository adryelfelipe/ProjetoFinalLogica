package ProjetoBase;

import Models.MaquinaModel;
import Models.UsuarioModel;
import Repositories.MaquinaDAO;

public class MaquinaService {
    // -- Atributos -- //
    private final MaquinaDAO maquinaDAO = new MaquinaDAO();

    // -- Métodos -- //
    public void inserirMaquina(UsuarioModel usuarioInseridor, MaquinaModel maquina) {
        UsuarioValidator.temNivelAcesso3(usuarioInseridor);
        MaquinaValidator.verificaRegrasInsercaoMaquina(maquina);
        maquinaDAO.inserirMaquina(maquina);
    }

    public void isIdExistenteValidator(long id) {
        if(!maquinaDAO.verificarId(id)) {
            throw new IllegalStateException("ERRO! O ID DA MÁQUINA NÃO FOI ENCONTRADO");
        }
    }
}
