package com.example.proyectofinal_poo_2021b_jtituana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("JugadorVista.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 412, 157);
        stage.setTitle("Bienvenida!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
