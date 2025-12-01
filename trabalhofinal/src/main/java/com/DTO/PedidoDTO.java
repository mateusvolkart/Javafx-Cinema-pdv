package com.DTO;

public class PedidoDTO {
    
    private int numero;
    private String filme;
    private String sala;
    private String lugares;
    private Double total;

    public PedidoDTO(int numero, String filme, String sala, String lugares, Double total) {
        this.numero = numero;
        this.filme = filme;
        this.sala = sala;
        this.lugares = lugares;
        this.total = total;
    }

    public String getFilme() {
        return filme;
    }

    public String getSala() {
        return sala;
    }

    public String getLugares() {
        return lugares;
    }

    public int getNumeroPedido() {
        return numero;
    }

    public Double getValorTotal(){
        return total;
    }
}
