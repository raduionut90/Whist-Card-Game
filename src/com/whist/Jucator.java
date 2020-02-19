
package com.whist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Jucator {
    private final int id;
    private final String nume;
    private int puncteCastigate;
    private boolean first = false;
    private boolean last = false;
    //TODO: foloseste mereu private sau protected
    protected List<Carte> cartiCurente = new ArrayList<>();

    public Jucator(int id, String nume) {
        this.id = id;
        this.nume = nume;
        //TODO: e deja initializat cu 0 (default value)
        //puncteCastigate = 0;
    }

    public int cateVotezi(int nrMaini, int votatePanaAcum){
        Scanner sc = new Scanner(System.in);
        int rezultat = sc.nextInt();
        if (rezultat>nrMaini) {
            if (isLast() && rezultat == nrMaini - votatePanaAcum){
                System.out.println("Nu poti vota " + rezultat + ". Pana acum s-au votat " + votatePanaAcum);
                return -1;
            }
            return -1;
        } else {
            return rezultat;
        }

    }
    
//    public Carte alegeCarte(int x){
//        return cartiCurente.get(x);
//    }

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

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
