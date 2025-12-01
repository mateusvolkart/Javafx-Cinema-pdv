package com.models;

public class Sala {
    private int numero;
    private boolean[][] assentos;
    private Filme filme;

    public Sala(int numero, int linhas, int colunas, Filme filme) {
        this.numero = numero;
        this.assentos = new boolean[linhas][colunas];
        this.filme = filme;
    }

    public int getNumero() {
        return numero;
    }

    public void reservarAssento(int linha, int coluna) {
        if (linha >= 0 && linha < assentos.length && coluna >= 0 && coluna < assentos[0].length) {
            assentos[linha][coluna] = true;
        }
    }

    public boolean isOcupado(int linha, int coluna) {
        return assentos[linha][coluna];
    }

    public Filme getFilme() {
        return filme;
    }
    
    public static Sala getSalaByNumero(int numero) {
        for (Sala sala : com.App.salas) {
            if (sala.getNumero() == numero) {
                return sala;
            }
        }
        return null;
    }

    public int getLinhas() {
        return assentos.length;
    }

    public int getColunas() {
        return assentos[0].length;
    }
    
}