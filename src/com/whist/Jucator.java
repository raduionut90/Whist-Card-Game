
package com.whist;

import java.util.*;


public class Jucator {
    private final int id;
    private final String nume;
    private int puncteCastigate;
    private boolean first = false;
    private boolean last = false;
    private List<Carte> cartiCurente = new ArrayList<>();

    public Jucator(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    protected Carte alegeCarte(Carte atu, Carte primaCarte){
        if(atu!=null) System.out.println("     ATU    este: " + atu);
        if(primaCarte!=null) System.out.println("Prima carte este: " + primaCarte);
        System.out.println("+++++ " + nume + " +++++ carti tale sunt: \n");
        Collections.sort(cartiCurente, Comparator.comparingInt(Carte::getCuloare));
        for (int i = 0; i < cartiCurente.size(); i++) {
            System.out.println(i + ". " + cartiCurente.get(i));
        }
        System.out.println("\n Introdu nr. cartii pe care vrei sa o dai jos: ");
        Scanner sc = new Scanner(System.in);
        int nrAles;
        while(true) {
            try {
                nrAles = sc.nextInt();
                if (nrAles>cartiCurente.size()-1)
                    throw new IndexOutOfBoundsException("Nu exista cartea cu numarul ales de tine");
                if(primaCarte!=null && primaCarte.getCuloare()!=atu.getCuloare()){
                    if (!verificareCuloare(primaCarte)
                            && verificareAtu(atu)
                            && cartiCurente.get(nrAles).getCuloare() != atu.getCuloare()){
                        throw new IllegalArgumentException("Ai atu in mana");
                    }
                } else if (primaCarte!=null && primaCarte.getCuloare()==atu.getCuloare()
                        && verificareCuloare(primaCarte)
                        && cartiCurente.get(nrAles).getCuloare() != primaCarte.getCuloare()){
                    throw new IllegalArgumentException("Ai atu in mana !");
                }
                if (verificareCuloare(primaCarte) && cartiCurente.get(nrAles).getCuloare() != primaCarte.getCuloare()){
                    throw new IllegalArgumentException("Ai culoarea in mana si trebuie sa o dai");
                }
                break;
            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        Carte carteAleasa = cartiCurente.get(nrAles);
        cartiCurente.remove(nrAles);
        System.out.println("Cartea data jos este " + carteAleasa + "\n \n");
        return carteAleasa;
    }

    public boolean verificareCuloare(Carte prima){
        boolean areCuloare = false;
        for (Carte carte : cartiCurente) {
            if (prima!=null && carte.getCuloare()==prima.getCuloare()){
                areCuloare = true;
                break;
            } else if (prima!=null && carte.getCuloare()!=prima.getCuloare()){
                areCuloare = false;
            }
        }
        return areCuloare;
    }

    public boolean verificareAtu(Carte atu){
        boolean areCuloare = false;
        for (Carte carte : cartiCurente) {
            if (carte.getCuloare()==atu.getCuloare()){
                areCuloare = true;
            } else if(carte.getCuloare()!=atu.getCuloare()){
                areCuloare = false;
            }
        }
        return areCuloare;
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

    public int getPuncteCastigate() {
        return puncteCastigate;
    }

    public void setPuncteCastigate(int puncteCastigate) {
        this.puncteCastigate = puncteCastigate;
    }
}
