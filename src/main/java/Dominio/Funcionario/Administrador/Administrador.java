package Dominio.Funcionario.Administrador;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;

public class Administrador extends Funcionario {

    // -- Construtor -- //
    public Administrador(long id, NomeFuncionario nome, CPF cpf, Senha senha, ListaDepartamentos listaDepartamentos) {
        super(id, nome, cpf, senha, NivelAcesso.ADMIN, listaDepartamentos);
    }
}
