
package com.whist;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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
        Carte carte;
        carte = jucator.alegeCarte(atu, primaCarte);
        cartiJucatori.put(jucator, carte);
        if(primaCarte==null) {
            setPrimaCarte(carte);
        }

    }

    private void setPrimaCarte(Carte prima){
        primaCarte = prima;
    }

    public Jucator cineCastiga() {
        System.out.println("=============================");
        System.out.println("ATU  a fost: " + atu);
        System.out.println(cartiJucatori.toString());
        Carte castigatoareAtu;
        try{
            castigatoareAtu = cartiJucatori.values().stream()
                .filter(carte -> carte.getCuloare() == atu.getCuloare())
                .findAny().get();
            try{
                castigatoareAtu = cartiJucatori.values().stream()
                        .filter(carte -> carte.getCuloare() == atu.getCuloare())
                        .max(Comparator.comparingInt(Carte::getValoare)).get();
            }catch (NoSuchElementException e){
                castigatoareAtu = null;
            }
        }catch (NoSuchElementException e){
            castigatoareAtu = null;
        }


        Jucator castigator=null;
        if(castigatoareAtu!=null) {
            for(Jucator jucator: cartiJucatori.keySet()) {
                if (cartiJucatori.get(jucator) == castigatoareAtu) {
                    castigator = jucator;
                    System.out.println("Jucatorul " + jucator.getNume() + " cu ID: " +jucator.getId()+ " este castigatorul acestei maini cu Atu " + castigatoareAtu);
                    break;
                }
            }
        }else if (castigatoareAtu==null){
            Carte castigatoarePrima;
            try{
                castigatoarePrima = cartiJucatori.values().stream()
                        .filter(carte -> carte.getCuloare() == primaCarte.getCuloare())
                        .max(Comparator.comparingInt(Carte::getValoare)).get();
            }catch (NoSuchElementException | NullPointerException e){
                castigatoarePrima = cartiJucatori.values().stream()
                        .filter(carte -> carte.getCuloare() == primaCarte.getCuloare())
                        .findAny().get();
            }
            for(Jucator jucator: cartiJucatori.keySet()) {
                if (cartiJucatori.get(jucator) == castigatoarePrima) {
                    castigator = jucator;
                    System.out.println("Jucatorul " + jucator.getNume()+ " cu ID: " +jucator.getId()+ " este castigatorul acestei maini cu culoare " + castigatoarePrima);
                }
            }
        }
        System.out.println("=============================");
//        setFirstandLast(castigator);
        return castigator;
    }

//    public void acordaPuncte(){
//
//    }



}
