package com.whist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("De cate persoane sa fie jocul ? 3, 4, 5 sau 6 ?");
        Scanner scanner = new Scanner(System.in);
        int nrJuc = scanner.nextInt();
        Game joc = null;
        switch (nrJuc){
            case 3:
                joc = new Game(Game.enumNrJuc.TREI);
                break;
            case 4:
                joc = new Game(Game.enumNrJuc.PATRU);
                break;
            case 5:
                joc = new Game(Game.enumNrJuc.CINCI);
                break;
            case 6:
                joc = new Game(Game.enumNrJuc.SASE);
                break;
            default:
                System.out.println("Nu ai introdus nr corect de persoane");
                return;

        }
//        Game joc = new Game(Game.enumNrJuc.TREI);
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
            System.out.println("Distribuirea nr: " + i);
            System.out.println("Joc de " + distribuire.nrMaini);
            System.out.println("Ordinea jucatorilor " + joc.getColectieJucatori());
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
                joc.faCartile(castigator);
                distribuire.setMainiCastigate(castigator);
            }
            distribuire.calcularePunctaj();
            joc.faCartile(i);
        }

    }

}
