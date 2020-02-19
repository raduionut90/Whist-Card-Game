package com.whist;

public class Main {

    //TODO: preferabil, clasa care contine metoda main ar trebui sa fie separata si sa nu creezi obiecte din ea.
    public static void main(String[] args) {
        Game joc = new Game(Game.enumNrJuc.TREI);
        joc.genereazaJucatori();
        joc.setColectieCarti(joc.genereazaCarti(joc.getColectieJucatori().size()));
        Distribuire distUnu = new Distribuire(0, joc.getDistribuiri()[0]);
        for (Jucator jucator : joc.getColectieJucatori()) {
                distUnu.distribuieCarti(joc.getColectieCarti(), jucator);
        }
        for (Jucator jucator : joc.getColectieJucatori()) {
            distUnu.voteaza(jucator);
        }
        distUnu.genereazaMaini();
    }

}
