
package com.whist;

import java.util.*;


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

    protected Carte alegeCarte(Carte atu, Carte primaCarte){
        System.out.println("     ATU    este: " + atu);
        System.out.println("Prima carte este: " + primaCarte);
        System.out.println("+++++ " + nume + " +++++ carti tale sunt: \n");
        Collections.sort(cartiCurente, (c1, c2) -> c1.getCuloare()-c2.getCuloare());
        for (int i = 0; i < cartiCurente.size(); i++) {
            System.out.println(i + ". " + cartiCurente.get(i));
        }
        System.out.println("Introdu nr. cartii pe care vrei sa o dai jos: ");
        Scanner sc = new Scanner(System.in);
        int nrAles;
        while(true) {
            try {
                nrAles = sc.nextInt();
                if (nrAles>cartiCurente.size()-1)
                    throw new IndexOutOfBoundsException("Nu exista cartea cu numarul ales de tine");
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            }
        }
        Carte carteAleasa = cartiCurente.get(nrAles);
        cartiCurente.remove(nrAles);
        System.out.println("Cartea data jos este " + carteAleasa + "\n \n");
        return carteAleasa;
    }

    public int cateVotezi(int nrMaini, int votatePanaAcum){
        Scanner scan = new Scanner(System.in);
        int rezultat;
        while(true) {
            try {
                rezultat = scan.nextInt();
                if (rezultat > nrMaini || rezultat<0)
                    throw new IllegalArgumentException("Nu poti vota mai mult decat nr. de maini sau mai putine de 0! reincearca");
                if (isLast() && rezultat == nrMaini - votatePanaAcum)
                    throw new IllegalArgumentException("Esti ultimul si nu ai voie sa votezi " + (nrMaini-votatePanaAcum));
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            } catch (InputMismatchException e){
                System.err.println(e.toString());
                System.out.println("Trebuie sa introduci o cifra");
                scan.next();
            }
        }
        return rezultat;
    }

    @Override
    public String toString() {
        return nume;
  //      return "Jucatorul " + nume + " puncte: " + puncteCastigate + " are cartile: " + cartiCurente.toString();
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

    public int getId() {
        return id;
    }
}
