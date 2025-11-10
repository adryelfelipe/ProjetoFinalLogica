package Dominio.OrdemDeServico.ObjetosDeValor;

import Dominio.OrdemDeServico.Exceptions.ValorOsException;

public final class ValorOS {
    private final double valorOS;

    public ValorOS(double valorOS) {
        this.valorOS = valorOS;
    }

    private void validaValorOS(double valorOS) {
        if (valorOS < 0) {
            throw new ValorOsException("O VALOR DA ORDEM DE SERVIÇO NAO PODE SER NEGATIVO");
        }
    }

    public double getValorOS() {
        return valorOS;
    }
}
