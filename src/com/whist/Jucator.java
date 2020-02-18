
package com.whist;

import java.util.ArrayList;
import java.util.List;


public class Jucator {
    private final int id;
    private final String nume;
    private int puncteCastigate;
    private boolean first = false;
    //TODO: foloseste mereu private sau protected
    protected List<Carte> cartiCurente = new ArrayList<>();

    public Jucator(int id, String nume) {
        this.id = id;
        this.nume = nume;
        //TODO: e deja initializat cu 0 (default value)
        //puncteCastigate = 0;
    }
    
    public Carte alegeCarte(int x){
        return cartiCurente.get(x);
    }

    public void preiaCarti(Carte x){
        cartiCurente.add(x);
    }

    @Override
    public String toString() {
        return "Jucatorul " + nume + " puncte: " + puncteCastigate + " are cartile: " + cartiCurente.toString();
    }
    

    public int getPuncteCastigate() {
        return puncteCastigate;
    }

    public void setPuncteCastigate(int puncteCastigate) {
        this.puncteCastigate = puncteCastigate;
    }

    public List<Carte> getCartiCurente() {
        return cartiCurente;
    }

    public void setCartiCurente(List<Carte> cartiCurente) {
        this.cartiCurente = cartiCurente;
    }

    public String getNume() {
        return nume;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }


    
    
    
}
