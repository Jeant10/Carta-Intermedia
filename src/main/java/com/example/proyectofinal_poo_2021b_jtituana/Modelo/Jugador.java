package com.example.proyectofinal_poo_2021b_jtituana.Modelo;

public class Jugador {

    private int id = 0;
    private String username;
    private int monedas;

    public Jugador(String username, int monedas) {
        this.username = username;
        this.monedas = monedas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    @Override
    public String toString() {
        return "Jugador{" + ", username='" + username + '\'' +
                ", monedas='" + monedas + '\'' +
                '}';
    }
}
