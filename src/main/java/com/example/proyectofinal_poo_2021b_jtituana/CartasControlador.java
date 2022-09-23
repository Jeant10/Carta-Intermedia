package com.example.proyectofinal_poo_2021b_jtituana;

import com.example.proyectofinal_poo_2021b_jtituana.Conexion.Conexion;
import com.example.proyectofinal_poo_2021b_jtituana.Modelo.Baraja;
import com.example.proyectofinal_poo_2021b_jtituana.Modelo.Carta;
import com.example.proyectofinal_poo_2021b_jtituana.Modelo.Cuenta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.PreparedStatement;

public class CartasControlador {

    JugadorControlador jugador = new JugadorControlador();

    @FXML
    private ImageView imgcartados;

    @FXML
    private ImageView imgcartatres;

    @FXML
    private ImageView imgcartauno;

    @FXML
    private Label lbljugador;

    @FXML
    private TextField txtmonedas;

    @FXML
    private TextField txtmonedasmaquina;

    Baraja baraja = new Baraja();
    Baraja baraja2 = new Baraja();
    Baraja baraja3 = new Baraja();

    Cuenta apuesta;

    Conexion conn = new Conexion();

    PreparedStatement ps = null;

    ApuestaControlador saldo;

    public static int inicial = 50;
    public static int inicial2 = 50;

    int contador = 0;

    @FXML
    void iniciar(ActionEvent event) {

        boolean consent;
        boolean ok;

        lbljugador.setText(jugador.getNombre());
        txtmonedas.setText(inicial+"");

        txtmonedasmaquina.setText(inicial2+"");

        baraja.barajar();
        Carta sacada;
        sacada = baraja.sacar(1);


        baraja2.barajar();
        Carta sacada2;
        sacada2 = baraja2.sacar(1);


        baraja3.barajar();
        Carta sacada3;
        sacada3 = baraja3.sacar(1);

        apuesta = new Cuenta(inicial);

        if(contador == 1){

            Image myImage3 = new Image(getClass().getResourceAsStream(sacada3+".jpg"));
            imgcartatres.setImage(myImage3);
            if(sacada2.getNumero()> sacada3.getNumero() && sacada3.getNumero()>sacada.getNumero()){
                apuesta.depositar(saldo.cantidad);
                inicial = apuesta.getSaldo();
                inicial2 = apuesta.getSaldo()+5;
            }else{
                apuesta.retirar(saldo.cantidad);
                inicial = apuesta.getSaldo();
                inicial2 = apuesta.getSaldo();
                if(inicial < 0){
                    try {
                        ok = JOptionPane.showConfirmDialog(null,"Sin monedas! " +
                                "Has perdido" + "¿Desea salir?", "¿Desea salir?", JOptionPane.YES_NO_OPTION) == 0;
                        if(!ok){
                            inicial = 50;
                            inicial2 = 50;
                            Baraja barajanueva = new Baraja();
                            baraja = barajanueva;
                            baraja.barajar();

                            Baraja barajanueva2 = new Baraja();
                            baraja2 = barajanueva2;
                            baraja2.barajar();

                            Baraja barajanueva3 = new Baraja();
                            baraja3 = barajanueva3;
                            baraja3.barajar();
                        }else{
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaJugadoresVista.fxml"));
                            Parent root = loader.load();
                            Scene scene = new Scene(root,361,357);
                            Stage stage = new Stage();
                            stage.initModality(Modality.APPLICATION_MODAL);
                            stage.setTitle("Podio");
                            stage.setScene(scene);
                            stage.showAndWait();
                        }

                    }catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null,"A ocurrido un error");
                    }
                }
            }

            contador = 0;

        }
        else {
            Image myImage = new Image(getClass().getResourceAsStream(sacada+".jpg"));
            imgcartauno.setImage(myImage);

            Image myImage3 = new Image(getClass().getResourceAsStream("tapa.jpg"));
            imgcartatres.setImage(myImage3);

            Image myImage2 = new Image(getClass().getResourceAsStream(sacada2 + ".jpg"));
            imgcartados.setImage(myImage2);
            contador ++;

        }


        if(baraja.getCartas().size() == 1)
        {
            consent = JOptionPane.showConfirmDialog(null, "Sin Cartas " +
                    "¿Desea salir?", "¿Desea salir?", JOptionPane.YES_NO_OPTION) == 0;
            if(!consent){
                JOptionPane.showMessageDialog(null,"Nueva Baraja");
                Baraja barajanueva = new Baraja();
                baraja = barajanueva;
                baraja.barajar();

                Baraja barajanueva2 = new Baraja();
                baraja2 = barajanueva2;
                baraja2.barajar();

                Baraja barajanueva3 = new Baraja();
                baraja3 = barajanueva3;
                baraja3.barajar();

            }else{
                try{
                    insertar();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaJugadoresVista.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root,361,357);
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Podio");
                    stage.setScene(scene);
                    stage.showAndWait();
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"A ocurrido un error");
                }
            }
        }

    }

    @FXML
    void apostar(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ApuestaVista.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root,298,140);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Apuesta");
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"A ocurrido un error");
        }
    }

    @FXML
    void salir(ActionEvent event) {
        try{
            insertar();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaJugadoresVista.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root,361,357);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Podio");
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"A ocurrido un error");
        }
    }

    public void insertar(){
        conn.establecerConexion();
        try {
            String INSERT = "insert into jugadores (nickname, monedas) values (?,?)";
            ps = conn.getConnection().prepareStatement(INSERT);
            ps.setString(1,jugador.getNombre());
            ps.setInt(2,inicial);
            ps.execute();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"A ocurrido un error");
        }
        conn.cerrarConexion();
    }

}


