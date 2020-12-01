package com.bcopstein.Entidades;

public class SistLocacaoException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public enum Causa {
        MARCA_INEXISTENTE,
        MODELO_INEXISTENTE,
        CARRO_INDISPONIVEL,
        CARRO_NAO_ENCONTRADO,
        CLIENTE_NAO_ENCONTRADO,
        DATA_INVALIDA
    };
    private Causa causa;

    public SistLocacaoException(Causa causa) {
        super(causa.toString());
        this.causa = causa;
    }

    public Causa getCausa() {
        return causa;
    }
}
