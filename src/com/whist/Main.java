package com.whist;

public class Main {

    //TODO: preferabil, clasa care contine metoda main ar trebui sa fie separata si sa nu creezi obiecte din ea.
    public static void main(String[] args) {
        Game joc = new Game(Game.enumNrJuc.TREI);

        System.out.println("mana curenta este: " +Game.getManaCurenta());

        System.out.println(joc.getColectieDistribuiri().toString());

    }

}
