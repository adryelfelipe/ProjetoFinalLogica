package Dominio.Funcionario.Gerente;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;

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
