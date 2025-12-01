package com.models;

public class Filme {
    private int id;
    private String nome;
    private String imagem;
    private int classificacao;

    public Filme(String nome, String imagem, int classificacao, int id) {
        this.nome = nome;
        this.imagem = imagem;
        this.id = id;
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public int getId() {
        return id;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public static Filme getFilmeById(int id) {
        for (Filme filme : com.App.filmes) {
            if (filme.getId() == id) {
                return filme;
            }
        }
        return null;
    }

}
