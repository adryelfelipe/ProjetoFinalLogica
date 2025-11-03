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
}
