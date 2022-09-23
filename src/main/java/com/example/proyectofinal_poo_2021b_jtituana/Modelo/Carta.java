package com.example.proyectofinal_poo_2021b_jtituana.Modelo;

/**
 * @author lfborjas
 */
public class Carta {
    private String palo;
    private int numero;

    public Carta(String palo, int numero){
        this.palo = palo;
        this.numero = numero;
    }

    public Carta(){

    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString(){
        return String.format("%s de %s", numero, palo);
    }

    /*public String getRankDisplay(){
        switch(this.numero){
            case 1:
                return "as";
            case 11:
                return "sota";
            case 12:
                return "reina";
            case 13:
                return "rey";
            default:
                return String.valueOf(numero);
        }
    }*/

    public boolean equals(Carta otra){
        return this.palo.equals(otra.palo) && this.numero == otra.numero;
    }

    /*public static String getSerie(ArrayList<Carta> mano){
        int mayorPalo=0;
        int mayorNum=0;
        HashMap<Integer, Integer> numeros = new HashMap<Integer, Integer>();
        HashMap<String, Integer> palos = new HashMap<String, Integer>();
        for(Carta c: mano){
            int add = palos.get(c.palo)!= null ?  palos.get(c.palo)+1 : 1 ;
            palos.put(c.palo, add);
            add = numeros.get(c.numero) != null ? numeros.get(c.numero)+1: 1;
            numeros.put(c.numero, add);
        }
        for(Integer e: palos.values()){
            mayorPalo = e > mayorPalo ? e : mayorPalo;
        }
        
        for(Integer e: numeros.values()){
            mayorNum = e > mayorNum ? e : mayorNum;
        }

        StringBuilder retVal = new StringBuilder();       
        if(mayorPalo == mano.size())
            return "flush";
        if(mayorNum == mano.size() -1)
            return "poker";
        return "ninguna";
    }*/

    /*public static int getCuenta(ArrayList<Carta> mano){
        int c=0;
        boolean hasAce=false;
        for(Carta k: mano){

            switch(k.numero){
                case 1:
                    c += 11;
                    hasAce = true;
                    break;
                case 11:
                case 12:
                case 13:
                    c += 10;
                    break;
                default:
                    c += k.numero;
            }
        }
        if(c >= 21 && hasAce)
            return c-10;
        else
            return c;

    }*/
}
