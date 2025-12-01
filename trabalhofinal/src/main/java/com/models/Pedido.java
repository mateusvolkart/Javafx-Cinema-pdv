package com.models;


public class Pedido {
    private Filme filmeSelecionado;
    private String lugarSelecionado;
    private Sala salaSelecionada;
    public static int numeroPedido = 0;
    private int idPedido;

    public Pedido() {
        numeroPedido++;
        this.idPedido = numeroPedido;
    }

    public void setLugarSelecionado(String lugar) {
        this.lugarSelecionado = lugar;
    }

    public String getLugarSelecionado() {
        return lugarSelecionado;
    }

    public void setSalaSelecionada(Sala sala) {
        this.filmeSelecionado = sala.getFilme();
        this.salaSelecionada = sala;
    }

    public Sala getSalaSelecionada() {
        return salaSelecionada;
    }

    public Filme getFilmeSelecionado() {
        return filmeSelecionado;
    }

    public int getNumeroPedido() {
        return idPedido;
    }

    

}
