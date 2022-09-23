package com.example.proyectofinal_poo_2021b_jtituana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ApuestaControlador {

    @FXML
    private Button btncontinuar;

    @FXML
    private Button btnsalir;

    @FXML
    private TextField txtcantidad;


    public static int cantidad;


    @FXML
    void continuar(ActionEvent event) {
        cantidad = Integer.parseInt(txtcantidad.getText());
        Stage stage = (Stage) this.btncontinuar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void salir(ActionEvent event) {
        Stage stage = (Stage) this.btnsalir.getScene().getWindow();
        stage.close();
    }

}