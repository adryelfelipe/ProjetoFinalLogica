package Dominio.Funcionario.Gerente;

import Dominio.Funcionario.Funcionario.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Funcionario.Funcionario;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.CPF;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.Senha;

public class Gerente extends Funcionario {

    // -- Construtor com ID -- //
    public Gerente(long id, NomeFuncionario nome, CPF cpf, Senha senha, ListaDepartamentos departamentos) {
        super(id, nome, cpf, senha, NivelAcesso.GERENTE, departamentos);
    }

    // -- Construtor sem ID -- //
    public Gerente(NomeFuncionario nome, CPF cpf, Senha senha, ListaDepartamentos departamentos) {
        this(0, nome, cpf, senha, departamentos);
    }
}
