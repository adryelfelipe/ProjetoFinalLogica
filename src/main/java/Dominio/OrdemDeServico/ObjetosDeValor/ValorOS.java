package Dominio.OrdemDeServico.ObjetosDeValor;

import Dominio.OrdemDeServico.Exceptions.ValorOsException;

public final class ValorOS {
    private final double valorOS;

    public ValorOS(double valorOS) {
        validaValorOS(valorOS);
        this.valorOS = valorOS;
    }

    private void validaValorOS(double valorOS) {
        if (valorOS < 0) {
            throw new ValorOsException("O valor da ordem de serviço não pode ser negativo");
        }
    }

    public double getValorOS() {
        return valorOS;
    }
}
