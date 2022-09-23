package com.example.proyectofinal_poo_2021b_jtituana.Conexion;

import com.example.proyectofinal_poo_2021b_jtituana.Modelo.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Scanner;

public class Conexion {
    private Connection connection;
    private String jdbc = "jdbc:mysql://localhost:3306/podio";
    private String usuario=  "administrador";
    private String contrasenia = "admin1234";

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void establecerConexion() {
        try {
            connection = DriverManager.getConnection(jdbc,usuario ,contrasenia);
            System.out.println("Se establecio la conexion...");
        } catch (SQLException sql) {
            System.out.println("Algo paso y no se logro la conexion...");
            sql.printStackTrace();
        }

    }

    public void cerrarConexion (){

        if (connection!=null){
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }


    public static ObservableList<Jugador> listadeJugadores(){
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
        ObservableList<Jugador> lista = FXCollections.observableArrayList();
        try{
            PreparedStatement p = conexion.getConnection().prepareStatement("Select * from jugadores");
            ResultSet rs = p.executeQuery();

            while(rs.next()){
                lista.add(new Jugador(rs.getString("nickname"),Integer.parseInt(rs.getString("monedas"))));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        conexion.cerrarConexion();
        return lista;
    }

    public static Jugador Buscar(String nome) {
        Jugador resultado = null;
        ObservableList<Jugador> lista = listadeJugadores();
        for (Jugador profilo : lista) {
            if (profilo.getUsername().equals(nome)) {
                resultado = profilo;
                break;
            }
        }
        return resultado;
    }

}
