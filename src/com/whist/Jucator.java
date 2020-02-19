
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
    protected List<Carte> cartiCurente = new ArrayList<>();

    public Jucator(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public int cateVotezi(int nrMaini, int votatePanaAcum){
        boolean loop = true;
        Scanner scan = new Scanner(System.in);
        int rezultat=0;
        while(loop) {
            try {
                rezultat = scan.nextInt();
                if (rezultat > nrMaini)
                    throw new IllegalArgumentException("Nu poti vota mai mult decat nr. de maini! reincearca");
                if (isLast() && rezultat == nrMaini - votatePanaAcum)
                    throw new IllegalArgumentException("Esti ultimul si nu poti vota exact nr. de maini! reincearca");
                loop = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                loop = true;
            }
        }
        return rezultat;
    }

    @Override
    public String toString() {
        return "Jucatorul " + nume + " puncte: " + puncteCastigate + " are cartile: " + cartiCurente.toString();
    }

    public List<Carte> getCartiCurente() {
        return cartiCurente;
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
