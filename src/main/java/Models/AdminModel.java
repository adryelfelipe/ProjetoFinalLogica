package Models;

import Models.joias.NivelAcesso;

public class AdminModel extends UsuarioModel {

    // -- Construtor -- //
    public AdminModel(long id, String nome, String cpf, String senha) {
        super(id, nome, cpf, senha, NivelAcesso.ADMIN);
    }
}
