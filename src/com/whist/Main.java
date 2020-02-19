package com.whist;

public class Main {
    public static void main(String[] args) {
        Game joc = new Game(Game.enumNrJuc.TREI);
        joc.genereazaJucatori();
        joc.setColectieCarti(joc.genereazaCarti(joc.getNumarJucatori().numar));
//        System.out.println(joc.getColectieCarti());
        Distribuire distUnu = new Distribuire(0, joc.getDistribuiri()[0], joc.getColectieCarti());
        for (Jucator jucator : joc.getColectieJucatori()) {
            distUnu.distribuieCarti(jucator);
        }
        for (Jucator jucator : joc.getColectieJucatori()) {
            distUnu.voteaza(jucator);
        }
        distUnu.calcTotalVotate();
        distUnu.genereazaMaini();
        for (Hand mana : distUnu.getColectieMaini()) {
            for (Jucator jucator : joc.getColectieJucatori()) {
                mana.solicitaCarte(jucator);
            }
            mana.cineCastiga();
        }


        Distribuire distDoi = new Distribuire(8, joc.getDistribuiri()[8], joc.getColectieCarti());
        System.out.println("\n ");
        System.out.println("Urmeaza joc de " + distDoi.nrMaini);
        for (Jucator jucator : joc.getColectieJucatori()) {
            distDoi.distribuieCarti(jucator);
        }
        for (Jucator jucator : joc.getColectieJucatori()) {
            distDoi.voteaza(jucator);
        }
        distDoi.calcTotalVotate();
        distDoi.genereazaMaini();
        for (Hand mana : distDoi.getColectieMaini()) {
            for (Jucator jucator : joc.getColectieJucatori()) {
                mana.solicitaCarte(jucator);
            }
            mana.cineCastiga();
        }



    }

}
