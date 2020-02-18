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
    private Carte atuu;

    public Distribuire(int id, int nrMaini) {
        this.id = id;
        this.nrMaini = nrMaini;
    }

    public void voteaza(Jucator jucator) {
        cateVotate();
        System.out.println(jucator.getNume() + " cate maini crezi ca faci ? Pana acum s-au votat " + votatePanaAcum);
        mapVotate.put(jucator, jucator.cateVotezi(nrMaini, votatePanaAcum));
        cateVotate();
    }

    public int cateVotate(){
        for (int i = 0; i < mapVotate.size(); i++) {
             votatePanaAcum =+ mapVotate.get(i);
        }
        return votatePanaAcum;
    }

    //TODO: e preferabil sa pasezi variabilele pe care le modifici (colCarti, colectieJucatori...) ca argumente
//decat sa modifici field-urile de clasa. Asa e si mai clar ce vrea sa faca metoda.
//TODO: indentarea...

    protected void distribuieCarti(List<Carte> colectieCarti, Jucator jucator) {
        //TODO: nu folosi x,y,a,b,c... pentru variabile. Aici, foloseste Jucator jucator : colectieJucatori
        //TODO: din cauza ca ai folosit hm, nu e clar peste ce iterezi aici
        //TODO: mai bine faci un setter care suprascrie array-ul decat sa faci clear si add
        Collections.shuffle(colectieCarti);
        for (int i = 0; i < nrMaini; i++) {
            jucator.cartiCurente.clear();
            jucator.cartiCurente.add(colectieCarti.get(i));
            System.out.println("Jucatorul " + jucator.getNume() + " a primit cartea " + jucator.getCartiCurente().toString());
            colectieCarti.remove(i);
        }

        if (nrMaini!=8) {
            atuu = colectieCarti.get(nrMaini);
            System.out.println(atuu + " este ATU");
        }
        //TODO: e riscant sa faci get, remove... cu un field care se tot modifica.
        //incrementeaza asta in afara metodei, care ar trebui doar sa distribuie carti
        //manaCurenta++;
    }

    protected void genereazaMaini() {
        for (int i = 0; i < nrMaini; i++) {
            colectieMaini.add(new Hand());
        }
    }
}
