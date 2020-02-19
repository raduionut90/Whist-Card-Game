package com.whist;

public class Main {

    //TODO: preferabil, clasa care contine metoda main ar trebui sa fie separata si sa nu creezi obiecte din ea.
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
    }

}
