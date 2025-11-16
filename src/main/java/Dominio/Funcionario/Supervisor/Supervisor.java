package Dominio.Funcionario.Supervisor;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Supervisor.Exceptions.MetaMensalExeption;
import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;

public class Supervisor extends Funcionario {

    // -- Atributos -- /
    private MetaMensal metaMensal;

    // Construtor com ID //
    public Supervisor(long id, NomeFuncionario nome, CPF cpf, Senha senha, ListaDepartamentos departamentos, MetaMensal metaMensal) {
        super(id,nome, cpf, senha, NivelAcesso.SUPERVISOR, departamentos);
        alteraMetaMensal(metaMensal);
    }

    // Construtor sem ID //
    public Supervisor(NomeFuncionario nome, CPF cpf, Senha senha, ListaDepartamentos departamentos, MetaMensal metaMensal) {
        this(0,nome,cpf,senha,departamentos, metaMensal);
    }

    // -- Getters -- //
    public MetaMensal getMetaMensal() {
        return metaMensal;
    }

    // -- Alteradores -- //
    public void alteraMetaMensal(MetaMensal metaMensal) {
        if(metaMensal == null) {
            throw new MetaMensalExeption("O supervisor deve possuir uma meta mensal bem definida");
        }

        this.metaMensal = metaMensal;
    }

    public boolean igualMinhaMetaMensal(MetaMensal metaMensal) {
        return this.metaMensal.getValorMetaMensal() == metaMensal.getValorMetaMensal();
    }
}
