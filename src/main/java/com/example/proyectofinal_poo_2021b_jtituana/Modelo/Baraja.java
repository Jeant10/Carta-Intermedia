package com.example.proyectofinal_poo_2021b_jtituana.Modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author lfborjas
 */
public class Baraja {
    public static String[] palos={"diamantes", "treboles", "corazones", "espadas"};
    private ArrayList<Carta> cartas;
    public Baraja(){
        cartas = new ArrayList<Carta>();
        for(String palo: palos)
            for(int i=1;i<=13;i++)
                cartas.add(new Carta(palo, i));

    }

    public void barajar(){
        Collections.shuffle(cartas);
    }

    public Carta sacar(int n){
        Carta rv = new Carta();
        rv = cartas.remove(n);
        return rv;
    }


    public ArrayList<Carta> getCartas(){
        return this.cartas;
    }

    public String toString(){
        return cartas.toString();
    }

}
