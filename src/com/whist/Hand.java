
package com.whist;

import java.util.HashMap;
import java.util.Map;

public class Hand {
    //cartiDateDeJucatori // memoreaza cartile date de fiecare jucator - probabil map
    //cineCastiga() // in functie de cartea data de primul jucator si de atu, stabileste cine a castigat mana,
                    // si returneaza numele jucatorului care a castigat mana

    private Map<Jucator, Carte> carteJucator = new HashMap<>();

    public void adaugareCarte(Jucator jucator, Carte carte){
        carteJucator.put(jucator, carte);
    }




}
