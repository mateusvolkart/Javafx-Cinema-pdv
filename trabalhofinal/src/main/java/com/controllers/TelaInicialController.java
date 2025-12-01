package com.controllers;

import com.models.Sala;
import com.models.Filme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TelaInicialController {

    @FXML
    private ImageView imgFilme1;

    @FXML
    private ImageView imgFilme2;

    @FXML
    private ImageView imgFilme3;

    @FXML
    private ImageView imgFilme4;


    @FXML
    public void initialize() {
        imgFilme1.setImage(new Image(getClass().getResource(Filme.getFilmeById(1).getImagem()).toString()));
        imgFilme2.setImage(new Image(getClass().getResource(Filme.getFilmeById(2).getImagem()).toString()));
        imgFilme3.setImage(new Image(getClass().getResource(Filme.getFilmeById(3).getImagem()).toString()));
        imgFilme4.setImage(new Image(getClass().getResource(Filme.getFilmeById(4).getImagem()).toString()));
    }

    @FXML
    public void clicouFilme(MouseEvent event) {
        try {
            ImageView img = (ImageView) event.getSource();
            String numeroSala = img.getUserData().toString();
            int numerosala = Integer.parseInt(numeroSala);
            Sala sala = Sala.getSalaByNumero(numerosala);

            System.out.println("Filme selecionado: " + numeroSala);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/telaAssentos.fxml"));
            Parent root = loader.load();

            TelaAssentosController controller = loader.getController();
            controller.setSala(sala);

            Stage stage = (Stage) img.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTelaPedidos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/telaPedidos.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) imgFilme1.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}