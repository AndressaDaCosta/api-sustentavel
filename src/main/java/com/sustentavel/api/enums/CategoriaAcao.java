package com.sustentavel.api.enums;

public enum CategoriaAcao {
    DOACAO("Doação"),
    RECICLAGEM("Reciclagem"),
    PLANTIO("Plantio"),
    EDUCACAO_AMBIENTAL("Educação Ambiental"),
    OUTROS("Outros");

    private final String descricao;

    CategoriaAcao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}