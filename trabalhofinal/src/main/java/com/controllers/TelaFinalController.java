package com.controllers;

import com.models.Pedido;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaFinalController {

    @FXML
    private Label labelFilme;

    @FXML
    private Label labelAssentos;

    @FXML
    private Label labelTotal;

    @FXML
    private Label labelNumeroPedido;

    private String filme;
    private String assentos;
    private double total;
    private int numeroPedido;

    public void setDados(Pedido pedido) {
        this.filme = pedido.getFilmeSelecionado().getNome();
        this.assentos = pedido.getLugarSelecionado();
        this.total = pedido.getValorTotal();
        this.numeroPedido = pedido.getNumeroPedido();

        labelFilme.setText("Filme: " + filme);
        labelAssentos.setText("Assentos: " + assentos);
        labelTotal.setText(String.format("Total: R$ %.2f", total));
        labelNumeroPedido.setText("Número do Pedido: " + numeroPedido);
    }

    @FXML
    public void voltarInicio() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/telaInicial.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) labelFilme.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
