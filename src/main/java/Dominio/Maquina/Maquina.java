package Dominio.Maquina;

import Aplicacao.Maquina.Exceptions.Handler.MesmoDepartamentoMaquinaException;
import Aplicacao.Maquina.Exceptions.Handler.MesmoNomeMaquinaException;
import Aplicacao.Maquina.Exceptions.Handler.MesmoStatusMaquinaException;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Dominio.Maquina.Exceptions.IdMaquinaException;
import Dominio.Maquina.Exceptions.LocalizacaoInvalidaException;
import Dominio.Maquina.Exceptions.NomeMaquinaException;
import Dominio.Maquina.Exceptions.StatusMaquinaException;
import Dominio.Maquina.ObjetosDeValor.Localizacao;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;

public class Maquina {
    // -- Atributos -- //
    private long idMaquina;
    private NomeMaquina nome;
    private Departamento departamento;
    private StatusMaquina status;

    // -- Construtor com ID -- //
    public Maquina(long id, NomeMaquina nome, Departamento departamento, StatusMaquina status) {
        alteraIdMaquina(id);
        alteraNome(nome);
        alteraDepartamento(departamento);
        alteraStatus(status);
    }

    // -- Construtor sem ID -- //
    public Maquina(NomeMaquina nome, Departamento departamento, StatusMaquina status) {
        this(0, nome, departamento, status);
    }

    // --  Getters -- //
    public NomeMaquina getNome() {
        return nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }


    public StatusMaquina getStatus() {
        return status;
    }

    public long getIdMaquina() {
        return idMaquina;
    }

    // -- Alteradores -- //
    public void alteraIdMaquina(Long idMaquina) {
        if(this.idMaquina != 0) {
            throw new IdMaquinaException("Não é possível alterar o ID de uma máquina");
        }

        if(idMaquina < 0) {
            throw new IdMaquinaException("O ID da máquina informado está inválido");
        }

        this.idMaquina = idMaquina;
    }

    public void alteraNome(NomeMaquina nome) {
        if(nome == null) {
            throw new NomeMaquinaException("A máquina deve possuir um nome bem definido");
        }

        if(this.nome != null) {
            if(igualMeuNome(nome)) {
                throw new MesmoNomeMaquinaException();
            }
        }

        this.nome = nome;
    }

    public void alteraStatus(StatusMaquina status) {
        if(status == null) {
            throw new StatusMaquinaException("O status da máquina deve ser bem definido");
        }

        if(this.status != null) {
            if(igualMeuStatus(status)) {
                throw new MesmoStatusMaquinaException();
            }
        }

        this.status = status;
    }

    public void alteraDepartamento(Departamento departamento) {
        if(departamento == null) {
            throw new LocalizacaoInvalidaException("A máquina deve possuir sua localização bem definida");
        }

        if(this.departamento != null) {
            if(igualMeuDepartamento(departamento)) {
                throw new MesmoDepartamentoMaquinaException();
            }

        }

        this.departamento = departamento;
    }

    private boolean igualMeuDepartamento(Departamento departamento) {
        return this.departamento == departamento;
    }

    private boolean igualMeuNome(NomeMaquina nomeMaquina) {
        return this.nome.equals(nomeMaquina);
    }

    private boolean igualMeuStatus(StatusMaquina status) {
        return this.status == status;
    }
}