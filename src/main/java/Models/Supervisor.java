package Models;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.NivelAcesso;
import Service.Validator.SupervisorValidator;

import java.util.List;

public class Supervisor extends Funcionario {

    // -- Atributos -- /
    private double metaMensal;

    // Construtor com ID //
    public Supervisor(long id, String nome, String cpf, String senha, double metaMensal, List<Departamento> listaDepartamentos) {
        super(id,nome, cpf, senha, NivelAcesso.SUPERVISOR, listaDepartamentos);
        setMetaMensal(metaMensal);
    }

    // Construtor sem ID //
    public Supervisor(String nome, String cpf, String senha, double metaMensal, List<Departamento> listaDepartamentos) {
        this(0,nome,cpf,senha,metaMensal, listaDepartamentos);
    }

    public Supervisor(long id, String nome, String cpf, String senha, NivelAcesso nivelAcessoE, List<Departamento> listaDepartamentos, double metaMensal) {
    }

    // -- Setters e Getters -- //
    public double getMetaMensal() {
        return metaMensal;
    }

    public void setMetaMensal(double metaMensal) {
        SupervisorValidator.verificaIntegridadeMetaMensal(metaMensal);
        this.metaMensal = metaMensal;
    }
}
