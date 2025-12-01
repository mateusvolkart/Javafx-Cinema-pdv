package com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.DTO.PedidoDTO;
import com.models.ListaPedidos;

public class TelaPedidosController {

    @FXML private TableView<PedidoDTO> tabelaPedidos;
    @FXML private TableColumn<PedidoDTO, Integer> colNumero;
    @FXML private TableColumn<PedidoDTO, String> colFilme;
    @FXML private TableColumn<PedidoDTO, String> colSala;
    @FXML private TableColumn<PedidoDTO, String> colLugares;
    @FXML private TableColumn<PedidoDTO, Double> colTotal;


    @FXML
    public void initialize() {
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numeroPedido"));
        colFilme.setCellValueFactory(new PropertyValueFactory<>("filme"));  
        colSala.setCellValueFactory(new PropertyValueFactory<>("sala"));
        colLugares.setCellValueFactory(new PropertyValueFactory<>("lugares"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        

        tabelaPedidos.getItems().setAll(ListaPedidos.getPedidosDesnormalized());
    }

    @FXML
    public void voltar() {
       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/telaInicial.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) tabelaPedidos.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

}
