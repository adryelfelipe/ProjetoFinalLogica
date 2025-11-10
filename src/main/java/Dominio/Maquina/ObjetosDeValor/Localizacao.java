package Dominio.Maquina.ObjetosDeValor;

public final class Localizacao {
    private final String localizacao;

    public Localizacao(String localizacao) {
        validaLocalizacao(localizacao);
        this.localizacao = localizacao;
    }

    private void validaLocalizacao(String localizacao) {
        if (localizacao.length() < 4) {
            throw new IllegalStateException("A localização deve possuir no mínimo 4 caracteres");
        }
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
