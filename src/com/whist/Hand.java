
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
        Carte carte;
        carte = jucator.alegeCarte(atu, primaCarte);
        cartiJucatori.put(jucator, carte);
        if(cartiJucatori.size()==1 && jucator.isFirst()){
            setPrimaCarte(carte);
            jucator.setFirst(false);
        }
    }

    private void setPrimaCarte(Carte prima){
        primaCarte = prima;
    }

    public Jucator cineCastiga() {
        System.out.println("=============================");
        System.out.println(cartiJucatori.toString());

        Optional<Carte> castigatoareAtu = cartiJucatori.values().stream()
                .filter(carte -> carte.getCuloare() == atu.getCuloare())
                .max(Comparator.comparingInt(Carte::getValoare));
        Optional<Carte> castigatoarePrima = cartiJucatori.values().stream()
                .filter(carte -> carte.getCuloare() == primaCarte.getCuloare())
                .max(Comparator.comparingInt(Carte::getValoare));

        Jucator castigator=null;
        if(castigatoareAtu.isPresent()) {
            for(Jucator jucator: cartiJucatori.keySet()) {
                if (cartiJucatori.get(jucator) == castigatoareAtu.get()) {
                    castigator = jucator;
                    System.out.println("Jucatorul " + jucator.getNume() + " este castigatorul acestei maini cu Atu " + castigatoareAtu.get());
                }
            }
        }else if (castigatoarePrima.isPresent()){
            for(Jucator jucator: cartiJucatori.keySet()) {
                if (cartiJucatori.get(jucator) == castigatoarePrima.get()) {
                    castigator = jucator;
                    System.out.println("Jucatorul " + jucator.getNume() + " este castigatorul acestei maini cu culoare " + castigatoarePrima.get());
                }
            }
        }
        System.out.println("=============================");
//        setFirstandLast(castigator);
        return castigator;
    }

//    public void setFirstandLast(Jucator castigator){
//        castigator.setFirst(true);
////        int idCastigator = castigator.getId();
////        for(Jucator jucator : cartiJucatori.keySet()){
////            Jucator ultimul = jucator;
////        }
//    }
//    public void acordaPuncte(){
//
//    }



}
