package com.controllers;
import com.models.ListaPedidos;
import com.models.Pedido;

import com.models.Sala; 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TelaAssentosController {

    @FXML
    private GridPane gridAssentos;

    private List<String> assentosSelecionados = new ArrayList<>();

    private int LINHAS;
    private int COLUNAS;

    private Sala salaAtual;

    public void setSala(Sala sala) {
        this.salaAtual = sala;
        this.LINHAS = sala.getLinhas();
        this.COLUNAS = sala.getColunas();
        gerarAssentos();
    }


    private void gerarAssentos() {
        char letra = 'A';

        for (int linha = 0; linha < LINHAS; linha++) {
            for (int coluna = 0; coluna < COLUNAS; coluna++) {

                String codigo = "" + letra + (coluna + 1);

                Button btn = new Button(codigo);
                btn.setStyle("-fx-pref-width: 60px; -fx-pref-height: 40px;");

                if (salaAtual.isOcupado(linha, coluna)) {
                    btn.setDisable(true);
                    btn.setStyle("-fx-background-color: #d9534f; -fx-text-fill: white; -fx-pref-width: 60px; -fx-pref-height: 40px;");
                } else {
                    btn.setOnAction(e -> selecionarAssento(btn));
                }

                gridAssentos.add(btn, coluna, linha);
            }
            letra++;
        }
    }

    private void selecionarAssento(Button btn) {
        String codigo = btn.getText();

        if (assentosSelecionados.contains(codigo)) {
            assentosSelecionados.remove(codigo);
            btn.setStyle("-fx-background-color: lightgray; -fx-pref-width: 60px; -fx-pref-height: 40px;");
        } else {
            assentosSelecionados.add(codigo);
            btn.setStyle("-fx-background-color: #5cb85c; -fx-text-fill: white; -fx-pref-width: 60px; -fx-pref-height: 40px;");
        }
    }

    @FXML
    public void confirmarAssentos() {
        try{
        for (String codigo : assentosSelecionados) {

            char letra = codigo.charAt(0);
            int linha = letra - 'A';
            int coluna = Integer.parseInt(codigo.substring(1)) - 1;

            salaAtual.reservarAssento(linha, coluna);
        }

        System.out.println("Assentos confirmados: " + assentosSelecionados);
        Pedido pedido = new Pedido();
        pedido.setSalaSelecionada(salaAtual);
        pedido.setLugarSelecionado(String.join(", ", assentosSelecionados));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/telaFinal.fxml"));
        Parent root = loader.load();
        TelaFinalController controller = loader.getController();
        controller.setDados(pedido);
        ListaPedidos.adicionar(pedido);

        Stage stage = (Stage) gridAssentos.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
