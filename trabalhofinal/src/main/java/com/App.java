package com;

import com.models.Filme;
import com.models.Sala;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static Filme filme1 = new Filme("Bugonia", "/com/images/filme1.png", 14, 1);
    public static Filme filme2 = new Filme("Wuthering Heights", "/com/images/filme2.png", 18, 2);
    public static Filme filme3 = new Filme("A Odisseia", "/com/images/filme3.png", 12, 3);
    public static Filme filme4 = new Filme("Wicked: for good", "/com/images/filme4.png", 0, 4);

    public static Filme[] filmes = {
            filme1,
            filme2,
            filme3,
            filme4
    };

    public static Sala[] salas = {
            new Sala(1, 5, 8, filme1),
            new Sala(2, 6, 10, filme2),
            new Sala(3, 5, 4, filme3),
            new Sala(4, 7, 9, filme4)
    };

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/com/views/telaInicial.fxml")
        );

        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Cinema");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
