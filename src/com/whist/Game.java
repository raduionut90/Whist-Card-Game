
package com.whist;

import java.util.*;

public class Game {
    public enum enumNrJuc {
        TREI(3),
        PATRU(4),
        CINCI(5),
        SASE(6);
        protected final int numar;

        enumNrJuc(int nr) {
            this.numar = nr;
        }
    }
    private final enumNrJuc numarJucatori;
    private final int[] distribuiri;
    private final List<Jucator> colectieJucatori = new ArrayList<>();
    private List<Carte> colectieCarti = new ArrayList<>();


    public Game(enumNrJuc numarJucatori) {
        this.numarJucatori = numarJucatori;
        this.distribuiri = setDistribuiri(numarJucatori);
//        genereazaCarti();
    }

    public void setFirstAndLast(Jucator castigator){
//        System.out.println("Pozitia "+castigator.getNume()+" in lista era " + colectieJucatori.indexOf(castigator));
        int index = colectieJucatori.indexOf(castigator);
        List<Jucator> listTemp = new ArrayList<>();
        for (int i = 0; i < colectieJucatori.size(); i++) {
            listTemp.add(i, colectieJucatori.get(index%colectieJucatori.size()));
            index++;
        }
        for(int i=0; i < listTemp.size(); i++){
            colectieJucatori.set(i, listTemp.get(i));
            colectieJucatori.get(i).setFirst(false);
            colectieJucatori.get(i).setLast(false);
//            System.out.println("Pozitia jucatorului " + colectieJucatori.get(i).getNume() + " este " + i);
        }
//        System.out.println("Pozitia " + castigator.getNume() + "  in lista este " + colectieJucatori.indexOf(castigator));
        colectieJucatori.get(0).setFirst(true);
        colectieJucatori.get(colectieJucatori.size()-1).setLast(true);
    }


    protected void genereazaJucatori(){
        Scanner in = new Scanner(System.in);
        for(int i=0; i<numarJucatori.numar; i++){
            System.out.println("Introdu un nume pt jucatorul nr " + i);
            String nume = in.next();
            colectieJucatori.add(new Jucator(i, nume));
        }
        colectieJucatori.get(0).setFirst(true);
        colectieJucatori.get(numarJucatori.numar-1).setLast(true);
    }

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

    public List<Jucator> getColectieJucatori() {
        return colectieJucatori;
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

    public enumNrJuc getNumarJucatori() {
        return numarJucatori;
    }
}
