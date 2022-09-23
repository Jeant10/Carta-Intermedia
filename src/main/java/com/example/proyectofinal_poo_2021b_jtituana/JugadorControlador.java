package com.example.proyectofinal_poo_2021b_jtituana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.JOptionPane;


public class JugadorControlador {

    @FXML
    private TextField txtnickname;


    @FXML
    private Button btnsiguiente;

    public static String nombre;




    @FXML
    void salir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void siguiente(ActionEvent event) {

        try{
            nombre = txtnickname.getText();
            JOptionPane.showMessageDialog(null,"Jugador añadido");
            Stage stagebye = (Stage) this.btnsiguiente.getScene().getWindow();
            stagebye.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CartasVista.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root,781,554);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Juego Carta Intermedia");
            stage.setScene(scene);
            stage.showAndWait();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"A ocurrido un error");
        }


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
