package Dominio.Entidades;

import Dominio.Enumeracoes.NivelAcesso;

public class Administrador extends Usuario {

    // -- Construtor -- //
    public Administrador(long id, String nome, String cpf, String senha) {
        super(id, nome, cpf, senha, NivelAcesso.ADMIN);
    }
}
