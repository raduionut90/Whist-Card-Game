package com.whist;

public class Main {
    public static void main(String[] args) {
        Game joc = new Game(Game.enumNrJuc.TREI);
        joc.genereazaJucatori();
        joc.setColectieCarti(joc.genereazaCarti(joc.getNumarJucatori().numar));
        System.out.println(joc.getColectieCarti());


//        Distribuire distUnu = new Distribuire(0, joc.getDistribuiri()[9], joc.getColectieCarti());
//        for (Jucator jucator : joc.getColectieJucatori()) {
//            distUnu.distribuieCarti(jucator);
//        }
//        System.out.println("\n ");
//        System.out.println("Joc de " + distUnu.nrMaini);
//        System.out.println("Atu este: " + distUnu.getAtuu() + "\n");
//        for (Jucator jucator : joc.getColectieJucatori()) {
//            distUnu.voteaza(jucator);
//        }
//        distUnu.calcTotalVotate();
//        distUnu.genereazaMaini();
//        for (Hand mana : distUnu.getColectieMaini()) {
//            for (Jucator jucator : joc.getColectieJucatori()) {
//                mana.solicitaCarte(jucator);
//            }
//            Jucator castigator = mana.cineCastiga();
//            joc.setFirstAndLast(castigator);
//            distUnu.setMainiCastigate(castigator);
//        }
//        distUnu.calcularePunctaj();

        for (int i = 0; i < joc.getDistribuiri().length; i++) {
            Distribuire distribuire = new Distribuire(i, joc.getDistribuiri()[i], joc.getColectieCarti());
            System.out.println("\n ");
            System.out.println("Joc de " + distribuire.nrMaini);
            System.out.println("Atu este: " + distribuire.getAtuu() + "\n");
            for (Jucator jucator : joc.getColectieJucatori()) {
                distribuire.distribuieCarti(jucator);
            }
            for (Jucator jucator : joc.getColectieJucatori()) {
                distribuire.voteaza(jucator);
            }
            distribuire.calcTotalVotate();
            distribuire.genereazaMaini();
            for (Hand mana : distribuire.getColectieMaini()) {
                for (Jucator jucator : joc.getColectieJucatori()) {
                    mana.solicitaCarte(jucator);
                }
                Jucator castigator = mana.cineCastiga();
                joc.setFirstAndLast(castigator);
                distribuire.setMainiCastigate(castigator);
            }
            distribuire.calcularePunctaj();
        }

    }

}
