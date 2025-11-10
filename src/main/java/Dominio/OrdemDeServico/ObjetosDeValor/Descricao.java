package Dominio.OrdemDeServico.ObjetosDeValor;

import Dominio.OrdemDeServico.Exceptions.DescricaoOsException;

public final class Descricao {
    private final String descricao;

    public Descricao(String descricao) {
        validaDescricao(descricao);
        this.descricao = descricao;
    }

    private void validaDescricao(String descricao) {
        if (descricao.length() < 5 || descricao.length() > 100) {
            throw new DescricaoOsException("A descrição deve conter no mínimo 5 caracteres no máximo 100");
        }
    }

    public String getDescricao() {
        return descricao;
    }
}
