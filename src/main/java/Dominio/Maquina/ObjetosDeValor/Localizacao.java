package Dominio.Maquina.ObjetosDeValor;

import Dominio.Maquina.Exceptions.LocalizacaoInvalidaException;

public final class Localizacao {
    private final String localizacao;

    public Localizacao(String localizacao) {
        validaLocalizacao(localizacao);
        this.localizacao = localizacao;
    }

    private void validaLocalizacao(String localizacao) {
        if (localizacao.length() < 4) {
            throw new LocalizacaoInvalidaException("A localização deve possuir no mínimo 4 caracteres");
        }
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
