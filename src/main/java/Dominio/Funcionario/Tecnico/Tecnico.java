package Dominio.Funcionario.Tecnico;

import Dominio.Funcionario.Funcionario.ObjetosDeValor.CPF;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.Senha;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Dominio.Funcionario.Funcionario.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Funcionario.Funcionario;
import Dominio.Funcionario.Tecnico.Exceptions.EspecialidadeException;

public class Tecnico extends Funcionario {
    private Especialidade especialidade;

    // Construtor com ID //
    public Tecnico(long id, NomeFuncionario nome, CPF cpf, Senha senha, ListaDepartamentos listaDepartamentos, Especialidade especialidade) {
        super(id, nome, cpf, senha, NivelAcesso.TECNICO, listaDepartamentos);
        alteraEspecialidade(especialidade);
    }

    // Construtor sem ID //
    public Tecnico(NomeFuncionario nome, CPF cpf, Senha senha,ListaDepartamentos listaDepartamentos, Especialidade especialidade) {
        this(0, nome, cpf, senha,listaDepartamentos,especialidade);
    }

    // -- Getters -- //
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    // -- Alteradores -- //
    public void alteraEspecialidade(Especialidade especialidade) {
        if(especialidade == null) {
            throw new EspecialidadeException("O técnico deve possuir uma especialidade bem definida");
        }

        this.especialidade = especialidade;
    }
}
