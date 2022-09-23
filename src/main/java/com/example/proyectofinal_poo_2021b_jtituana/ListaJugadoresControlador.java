package com.example.proyectofinal_poo_2021b_jtituana;

import com.example.proyectofinal_poo_2021b_jtituana.Conexion.Conexion;
import com.example.proyectofinal_poo_2021b_jtituana.Modelo.Jugador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaJugadoresControlador implements Initializable {

    final String UPDATE = "UPDATE jugadores SET nickname = ?, monedas = ? WHERE id = ?";

    @FXML
    private TableColumn<Jugador, Integer> colmonedas;

    @FXML
    private TableColumn<Jugador, String> colnickname;

    @FXML
    private TableView<Jugador> tblPersonas;

    ObservableList<Jugador> listdeJugadores;

    Conexion conn = new Conexion();

    @FXML
    void cerrar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void seleccionar(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colnickname.setCellValueFactory(new PropertyValueFactory<Jugador,String>("username"));
        colmonedas.setCellValueFactory(new PropertyValueFactory<Jugador,Integer>("monedas"));

        listdeJugadores = conn.listadeJugadores();

        BurbujaColObj(listdeJugadores);

        tblPersonas.setItems(listdeJugadores);
    }

    public static void BurbujaColObj(ObservableList<Jugador> jugador) {
        Jugador aux;
        for(int i = 0;i < jugador.size()-1;i++){
            for(int j = 0;j < jugador.size()-i-1;j++){
                if(jugador.get(j+1).getMonedas() >  jugador.get(j).getMonedas()){
                    aux = jugador.get(j+1);
                    jugador.set(j+1,jugador.get(j));
                    jugador.set(j,aux);
                }
            }
        }
    }



}