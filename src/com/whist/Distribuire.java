package com.whist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private List<Carte> colectieCarti;
    private List<Hand> colectieMaini = new ArrayList<>();
    private Carte atuu;

    public Distribuire(int id, int nrMaini) {
        this.id = id;
        this.nrMaini = nrMaini;
        this.colectieCarti = genereazaCarti();
        distribuieCarti(colectieCarti);
        genereazaMaini();
    }

    //TODO: returneaza colectia de carti in loc sa modifici field-ul de clasa si dupa asigneaza-o la field, daca e nevoie
    //asa poti apela metoda de mai multe ori, daca e nevoie
    private List<Carte> genereazaCarti(){
        List<Carte> Carti = new ArrayList<>();
        if(Game.getColectieJucatori().size()==3){
            //daca sunt 3 jucatori, genereaza cartile de la 9 la AS
            for(int i=6; i<12; i++){
                for(int j=0; j<4; j++){
                    Carti.add(new Carte(i, j));
                }
            }
            Collections.shuffle(Carti);
        }
        return Carti;
    }

    //TODO: e preferabil sa pasezi variabilele pe care le modifici (colCarti, colectieJucatori...) ca argumente
//decat sa modifici field-urile de clasa. Asa e si mai clar ce vrea sa faca metoda.
//TODO: indentarea...

    private void distribuieCarti(List<Carte> cartiTemp){
//        List<Carte> cartiTemp = new ArrayList<>(colectieCarti);
        //TODO: nu folosi x,y,a,b,c... pentru variabile. Aici, foloseste Jucator jucator : colectieJucatori
        for(Jucator jucator:Game.getColectieJucatori()){
            //TODO: din cauza ca ai folosit hm, nu e clar peste ce iterezi aici
            for(int i=0; i<nrMaini; i++){
                //TODO: mai bine faci un setter care suprascrie array-ul decat sa faci clear si add
//                jucator.cartiCurente.clear();
//                jucator.cartiCurente.add(cartiTemp.get(nrMaini));

                jucator.setCartiCurente(cartiTemp);
                System.out.println("Jucatorul " + jucator.getNume() + " a primit cartea " + cartiTemp.get(nrMaini));
//                cartiTemp.remove(nrMaini);
            }
        }
//        atuu = cartiTemp.get(nrMaini+1);
//        System.out.println(atuu+ " este ATUU");
        //TODO: e riscant sa faci get, remove... cu un field care se tot modifica.
        //incrementeaza asta in afara metodei, care ar trebui doar sa distribuie carti
        //manaCurenta++;
    }

    private void genereazaMaini(){
        for(int i=0; i<nrMaini; i++){
            colectieMaini.add(new Hand());
        }
    }
}
