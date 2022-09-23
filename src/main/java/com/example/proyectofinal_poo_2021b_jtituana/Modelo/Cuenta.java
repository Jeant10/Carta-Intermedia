package com.example.proyectofinal_poo_2021b_jtituana.Modelo;

public class Cuenta {
    private int saldo;


    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public void depositar(int cantidad) {
        saldo = saldo + cantidad;
    }

    public void retirar(int cantidad) {
        saldo = saldo - cantidad;
    }


    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
