package Dominio.Funcionario.Administrador;

import Dominio.Funcionario.Funcionario.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Funcionario.Funcionario;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.CPF;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.Senha;

public class Administrador extends Funcionario {

    // -- Construtor -- //
    public Administrador(long id, NomeFuncionario nome, CPF cpf, Senha senha, ListaDepartamentos listaDepartamentos) {
        super(id, nome, cpf, senha, NivelAcesso.ADMIN, listaDepartamentos);
    }
}
