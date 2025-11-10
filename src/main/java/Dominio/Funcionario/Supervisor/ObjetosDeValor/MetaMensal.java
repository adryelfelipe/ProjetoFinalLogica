package Dominio.Funcionario.Supervisor.ObjetosDeValor;

import Dominio.Funcionario.Supervisor.Exceptions.MetaMensalExeption;

public final class MetaMensal {
    private final double valorMetaMensal;

    public MetaMensal(double valorMetaMensal) {
        validaMetaMensal(valorMetaMensal);
        this.valorMetaMensal = valorMetaMensal;
    }

    private void validaMetaMensal(double valorMetaMensal) {
        if(valorMetaMensal < 1000) {
            throw new MetaMensalExeption("A meta mensal deve ser superior a 1000 reais");
        }
    }

    public double getValorMetaMensal() {
        return this.valorMetaMensal;
    }
}
