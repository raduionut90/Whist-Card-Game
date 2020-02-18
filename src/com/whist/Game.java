
package com.whist;

import java.util.*;

public class Game {
    public enum enumNrJuc {
        TREI(3),
        PATRU(4),
        CINCI(5),
        SASE(6);
        private final int numar;

        enumNrJuc(int nr) {
            this.numar = nr;
        }
    }
    private final enumNrJuc numarJucatori;
    private final int[] distribuiri;
    private int manaCurenta=1;
    //TODO: lipseste private
    //TODO: initializeaza mereu cu interfata: ex: List<Jucator> = new ArrayList<>(); Map<Integer, Integer> hm = new HashMap<>();
    private final List<Jucator> colectieJucatori = new ArrayList<>();
    private final List<Distribuire> colectieDistribuiri = new ArrayList<>();
    private List<Carte> colectieCarti = new ArrayList<>();
    //TODO: da un nume mai sugestiv pentru asta
  //  HashMap<Integer, Integer> hm = new HashMap<>();

    public Game(enumNrJuc numarJucatori) {
        this.numarJucatori = numarJucatori;
        this.distribuiri = setDistribuiri(numarJucatori);
//        genereazaCarti();
//        populareHashmap();
    }

    //TODO: nume mai sugestiv si aici
//    private void populareHashmap(){
//        for (int i = 1; i <= nrDistribuiri; i++) {
//            hm.put(i, maini[i-1]);
//        }
//    }
    //Am anulat aceasta metoda pentru ca am creat clasa Distribuire care se va ocupa de acest lucru.

    void genereazaJucatori(){
        Scanner in = new Scanner(System.in);
        for(int i=0; i<numarJucatori.numar; i++){
            System.out.println("Intrudu un nume pt jucatorul nr " + i);
            String nume = in.next();
            colectieJucatori.add(new Jucator(i, nume));
//            System.out.println("A fost adaugat jucatorul " + nume);
        }
        colectieJucatori.get(0).setFirst(true);
        colectieJucatori.get(numarJucatori.numar-1).setLast(true);
        System.out.println("Jucatorul " + colectieJucatori.get(0).getNume() + " este primul");
        System.out.println("Jucatorul " + colectieJucatori.get(numarJucatori.numar-1).getNume() + " este ultimul");

    }

    //TODO: returneaza colectia de carti in loc sa modifici field-ul de clasa si dupa asigneaza-o la field, daca e nevoie
    //asa poti apela metoda de mai multe ori, daca e nevoie
    protected List<Carte> genereazaCarti(int nrJucatori){
        List<Carte> Carti = new ArrayList<>();
        if(nrJucatori==3){
            //daca sunt 3 jucatori, genereaza cartile de la 9 la AS
            for(int i=6; i<12; i++){
                for(int j=0; j<4; j++){
                    Carti.add(new Carte(i, j));
                }
            }
        }
        return Carti;
    }

    //acestea sunt mainile, reprezentand cartile impartite, in functie de nr de jucatori.
    private int[] setDistribuiri(enumNrJuc numarJuc){
        int[] jocInTrei = {1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1};
        int[] jocInPatru = {1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1};
        int[] jocInCinci = {1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1};
        int[] jocInSase = {1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1}; 

        switch(numarJuc){
            case TREI:
                return jocInTrei;
            case PATRU:
                return jocInPatru;
            case CINCI:
                return jocInCinci;
            case SASE:
                return jocInSase;
            default:
                return null;
        }
    }


    public int getManaCurenta() {
        return manaCurenta;
    }

    public List<Jucator> getColectieJucatori() {
        return colectieJucatori;
    }

    public enumNrJuc getNumarJucatori() {
        return numarJucatori;
    }

    public List<Distribuire> getColectieDistribuiri() {
        return colectieDistribuiri;
    }

    public int[] getDistribuiri() {
        return distribuiri;
    }

    public void setColectieCarti(List<Carte> colectieCarti) {
        this.colectieCarti = colectieCarti;
    }

    public List<Carte> getColectieCarti() {
        return colectieCarti;
    }
}
