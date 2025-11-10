package Dominio.Maquina;

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
    private Localizacao localizacao;
    private StatusMaquina status;


    // -- Construtor com ID -- //
    public Maquina(long id, NomeMaquina nome, Localizacao localizacao, StatusMaquina idStatus) {
        alteraNome(nome);
        alteraIdMaquina(id);
        alteraLocalizacao(localizacao);
        alteraStatus(idStatus);
    }

    // -- Construtor sem ID -- //
    public Maquina(NomeMaquina nome, Localizacao localizacao, StatusMaquina idStatus) {
        this(0, nome, localizacao, idStatus);
    }

    // --  Getters -- //
    public NomeMaquina getNome() {
        return nome;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }


    public StatusMaquina getStatus() {
        return status;
    }

    public long getIdMaquina() {
        return idMaquina;
    }

    // -- Alteradores -- //
    public void alteraIdMaquina(long idMaquina) {
        if(idMaquina < 0) {
            throw new IdMaquinaException("A máquina não pode possuir um ID negativo");
        }

        this.idMaquina = idMaquina;
    }

    public void alteraNome(NomeMaquina nome) {
        if(nome == null) {
            throw new NomeMaquinaException("A máquina deve possuir um nome bem definido");
        }

        this.nome = nome;
    }

    public void alteraStatus(StatusMaquina status) {
        if(status == null) {
            throw new StatusMaquinaException("O status da máquina deve ser bem definido");
        }

        this.status = status;
    }

    public void alteraLocalizacao(Localizacao localizacao) {
        if(localizacao == null) {
            throw new LocalizacaoInvalidaException("A máquina deve possuir sua localização bem definida");
        }

        this.localizacao = localizacao;
    }

}