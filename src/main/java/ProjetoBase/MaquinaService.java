package ProjetoBase;

import Dominio.Entidades.Maquina;
import Dominio.Entidades.Usuario;
import Repositories.MaquinaDAO;

public class MaquinaService {
    // -- Atributos -- //
    private final MaquinaDAO maquinaDAO = new MaquinaDAO();

    // -- Métodos -- //
    public void inserirMaquina(Usuario usuarioInseridor, Maquina maquina) {
        UsuarioValidator.temNivelAcesso3(usuarioInseridor);
        MaquinaValidator.verificaRegrasInsercaoMaquina(maquina);
        maquinaDAO.inserirMaquina(maquina);
    }

    public void isIdExistenteValidator(long id) {
        if(!maquinaDAO.verificarIdMaquina(id)) {
            throw new IllegalStateException("ERRO! O ID DA MÁQUINA NÃO FOI ENCONTRADO");
        }
    }
}
