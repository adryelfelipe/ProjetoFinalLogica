package Service;

import Models.Enumeracoes.Departamento;
import Models.Maquina;
import Models.Funcionario;
import DAO.MaquinaDAO;
import Service.Validator.MaquinaValidator;
import Service.Validator.UsuarioValidator;

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
        if(!maquinaDAO.verificarIdMaquina(id)) {
            throw new IllegalStateException("ERRO! O ID DA MÁQUINA NÃO FOI ENCONTRADO");
        }
    }

    public Departamento maquinaParaDepartamento(long idMaquina) {
        if(maquinaDAO.maquinaParaDepartamento(idMaquina) == null) {
            throw new IllegalStateException("ERRO! MÁQUINA NÃO ENCONTRADA");
        }

        return maquinaDAO.maquinaParaDepartamento(idMaquina);
    }
}
