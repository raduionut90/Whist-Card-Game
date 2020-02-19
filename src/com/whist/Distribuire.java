package com.whist;

import java.util.*;

public class Distribuire {
//            nr. distrib. 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30
//            3 jucatori = 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1.						        Total 21
//            4 jucatori = 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1.					    Total 24
//            5 jucatori = 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1			    Total 27
//            6 jucatori = 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1		Total 30
//
//    //Fiecare distribuire va avea un nr de maini, de ex. pt 3 juc, distribuirea nr 5 va avea 4 maini.
//    genereazaMaini() // genereaza nr de maini, in functie de nr distribuirii, dupa modelul de mai sus
//    distribuieCarti() // sa imparta fiecarui jucator nr. corespunzator de carti // Hand de 4 imparte 4 carti
//    cateVotate() //intreaba si memoreaza cate maini crede ca face fiecare jucator
//    mainiCastigate //trebuie sa fie un map<nrHand><Jucator> cu lungimea de x Hand, pt fiecare hand in parte, memoreaza jucatorul care a castigat mana respectiva
//    acordaPuncte() //calculeaza punctele pt fiecare jucator, in functie de mainiCastigate

    private int id;
    private int nrMaini;
    private List<Hand> colectieMaini = new ArrayList<>();
    private Map<Jucator, Integer> mapVotate = new HashMap<>();
    private int votatePanaAcum;
    private final Carte atuu;
    private final List<Carte> colectieCarti;

    public Distribuire(int id, int nrMaini, List<Carte> colectieCarti) {
        this.id = id;
        this.nrMaini = nrMaini;
        this.colectieCarti = colectieCarti;
        this.atuu = setAtuu();
    }

    public void voteaza(Jucator jucator) {
        System.out.println(jucator.getNume() + " cate maini crezi ca faci ? Pana acum s-au votat " + votatePanaAcum);
        int votateDeJucator = jucator.cateVotezi(nrMaini, votatePanaAcum);

        mapVotate.put(jucator, votateDeJucator);
        System.out.println("Ai votat " + votateDeJucator);
        votatePanaAcum += mapVotate.get(jucator);
    }

    public void calcTotalVotate(){
        System.out.println("=================================");
        System.out.println("Total votate: " + votatePanaAcum);
    }

    private Carte setAtuu(){
        if (nrMaini!=8) {
            System.out.println("nr maini egal cu = " + nrMaini);
            Carte atu = colectieCarti.get(0);
            System.out.println(atu + " este ATU");
            colectieCarti.remove(0);
            return atu;
        } else {
            return null;
        }
    }

    protected void distribuieCarti(Jucator jucator) {
        Collections.shuffle(colectieCarti);
        for (int i = 0; i < nrMaini; i++) {
            jucator.cartiCurente.clear();
            jucator.cartiCurente.add(colectieCarti.get(i));
            System.out.println("Jucatorul " + jucator.getNume() + " a primit cartea " + jucator.getCartiCurente().toString());
            colectieCarti.remove(i);
        }
    }

    protected void genereazaMaini() {
        for (int i = 0; i < nrMaini; i++) {
            colectieMaini.add(new Hand());
        }
    }
}
