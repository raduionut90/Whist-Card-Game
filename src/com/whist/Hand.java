
package com.whist;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Hand {
    //cartiDateDeJucatori // memoreaza cartile date de fiecare jucator - probabil map
    //cineCastiga() // in functie de cartea data de primul jucator si de atu, stabileste cine a castigat mana,
    // si returneaza numele jucatorului care a castigat mana
    private final Carte atu;
    private Carte primaCarte;   //culoarea
    protected Map<Jucator, Carte> cartiJucatori = new LinkedHashMap<>();

    public Hand(Carte atu) {
        this.atu = atu;
    }

    public void solicitaCarte(Jucator jucator){
        Carte carte = jucator.alegeCarte(atu, primaCarte);
        cartiJucatori.put(jucator, carte);
        if(cartiJucatori.size()==1 && jucator.isFirst()){
            setPrimaCarte(carte);
        }
    }

    private void setPrimaCarte(Carte prima){
        primaCarte = prima;
    }

    public void cineCastiga() {
        System.out.println("=============================");
        System.out.println(cartiJucatori.toString());

        Optional<Carte> castigatoareAtu = cartiJucatori.values().stream()
                .filter(carte -> carte.getCuloare() == atu.getCuloare())
                .max(Comparator.comparingInt(Carte::getValoare));
        Optional<Carte> castigatoarePrima = cartiJucatori.values().stream()
                .filter(carte -> carte.getCuloare() == primaCarte.getCuloare())
                .max(Comparator.comparingInt(Carte::getValoare));
        if(castigatoareAtu.isPresent()) {
            for(Jucator jucator: cartiJucatori.keySet()) {
                if (cartiJucatori.get(jucator) == castigatoareAtu.get()) {
                    System.out.println("Jucatorul " + jucator.getNume() + " este castigatorul acestei maini cu Atu " + castigatoareAtu.get());
                }
            }
        }else if (castigatoarePrima.isPresent()){
            for(Jucator jucator: cartiJucatori.keySet()) {
                if (cartiJucatori.get(jucator) == castigatoarePrima.get()) {
                    System.out.println("Jucatorul " + jucator.getNume() + " este castigatorul acestei maini cu culoare " + castigatoarePrima.get());
                }
            }
        }
        System.out.println("=============================");
    }

//    public void acordaPuncte(){
//
//    }



}
