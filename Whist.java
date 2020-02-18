
package whist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class Whist {
    public enum nrJucatori{TREI, PATRU, CINCI, SASE};

    private final int[] maini;
    private final int jucatori;
    private final int nrDistribuiri;
    private int manaCurenta=1;
    private Carti atuu;
    ArrayList<Jucator> colectieJucatori = new ArrayList<>();
    ArrayList<Carti> colCarti = new ArrayList<>();
    ArrayList<Maini> colMaini = new ArrayList<>();
    HashMap<Integer, Integer> hm = new HashMap<>();

    public Whist(nrJucatori x) {
        this.maini = setNrMaini(x);
        this.jucatori = x.ordinal()+3;
        nrDistribuiri =  maini.length;
        genereazaJucatori();
        genereazaCarti();
        populareHashmap();
    }
    
    private void genereazaMainile(){
        
    }
    
    private void populareHashmap(){
        for (int i = 1; i <= nrDistribuiri; i++) {
            hm.put(i, maini[i-1]);
        }
    }
    private void distribuieCarti(){
            ArrayList<Carti> cartiTemp = new ArrayList<>(colCarti);
                for(Jucator x:colectieJucatori){
                    for(int j=0; j<hm.get(manaCurenta); j++){
                        x.cartiCurente.clear();
                        x.cartiCurente.add(cartiTemp.get(manaCurenta));
                        System.out.println("Jucatorul " + x.getNume() + " a primit cartea " + cartiTemp.get(manaCurenta));
                        cartiTemp.remove(manaCurenta);
                    }                    
                }
                atuu = cartiTemp.get(manaCurenta);
                System.out.println(atuu+ " este ATUU");
                manaCurenta++;
    }
    
    private void genereazaJucatori(){
        Scanner in = new Scanner(System.in);
        for(int i=0; i<jucatori; i++){
            System.out.println("Intrudu un nume pt jucatorul nr " + i);
            String nume = in.next();
            colectieJucatori.add(new Jucator(i, nume));
//            System.out.println("A fost adaugat jucatorul " + nume);
        }
        colectieJucatori.get(0).setFirst(true);
        System.out.println("Jucatorul " + colectieJucatori.get(0).getNume() + " este primul");
    }
    
    private void genereazaCarti(){
        if(jucatori==3){
            //daca sunt 3 jucatori, genereaza cartile de la 9 la AS
            for(int i=7; i<13; i++){
                for(int j=0; j<4; j++){
                    colCarti.add(new Carti(i, j));
                }
            }
            Collections.shuffle(colCarti);
        }
    }

    //acestea sunt mainile, reprezentand cartile impartite, in functie de nr de jucatori.
    private int[] setNrMaini(nrJucatori x){
        int[] jocInTrei = {1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1};
        int[] jocInPatru = {1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1};
        int[] jocInCinci = {1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1};
        int[] jocInSase = {1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1}; 

        switch(x){
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

    public int[] getMaini() {
        return maini;
    }

    public Carti getAtuu() {
        return atuu;
    }

    public void setAtuu(Carti atuu) {
        this.atuu = atuu;
    }

    


    public static void main(String[] args) {
        Whist joc = new Whist(nrJucatori.TREI);
        System.out.println(joc.jucatori);
//        System.out.println(joc.colectieJucatori.toString());
//        System.out.println("nr carti: " + joc.colCarti.size());
//        System.out.println("nr distribuiri " + joc.nrDistribuiri);
//        System.out.println("CARTI: " + joc.colCarti.toString());
       


        System.out.println("mana curenta este: " +joc.manaCurenta);

        joc.distribuieCarti();

        System.out.println(joc.hm.toString());
        System.out.println("mana curenta este: " +joc.manaCurenta);

        joc.distribuieCarti();        System.out.println("\n mana curenta este: " +joc.manaCurenta);

        joc.distribuieCarti();        System.out.println("\n mana curenta este: " +joc.manaCurenta);

        joc.distribuieCarti();        System.out.println("\n mana curenta este: " +joc.manaCurenta);

        joc.distribuieCarti();        System.out.println("\n mana curenta este: " +joc.manaCurenta);

        joc.distribuieCarti();
    }
    
}
