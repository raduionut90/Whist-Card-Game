
package com.whist;

import java.util.*;

public class Hand {
    //cartiDateDeJucatori // memoreaza cartile date de fiecare jucator - probabil map
    //cineCastiga() // in functie de cartea data de primul jucator si de atu, stabileste cine a castigat mana,
    // si returneaza numele jucatorului care a castigat mana
    private final Carte atu;
    protected Map<Jucator, Carte> cartiJucatori = new LinkedHashMap<>();

    public Hand(Carte atu) {
        this.atu = atu;
    }

    public void solicitaCarte(Jucator jucator){
        System.out.println("Atu este " + atu);
        Carte carte = jucator.alegeCarte();
        cartiJucatori.put(jucator, carte);
    }

    public void cineCastiga() {
        System.out.println(cartiJucatori.toString());
        Jucator castigator = null;
        int counter = 0;
        for (Jucator jucator : cartiJucatori.keySet()) {
            if (cartiJucatori.get(jucator).getCuloare() == atu.getCuloare()) {
                counter++;
                if (counter > 1) {
                    Carte castigatoare = cartiJucatori.values().stream().max((c1, c2) -> (c1.getValoare() - c2.getValoare())).get();
                    if (cartiJucatori.get(jucator) == castigatoare) {
                        castigator = jucator;
                    }
                } else if (counter == 1) {
                    castigator = jucator;
                }
            }

            //verific daca jucatorii au dat culoare jos
            //cea mai mare culoare

        }
        if (castigator != null) {
            System.out.println("Jucatorul " + castigator.getNume() + " a castigat aceasta mana");
        }
    }

//    public void acordaPuncte(){
//
//    }



}
