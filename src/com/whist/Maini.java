
package com.whist;

//clasa care se ocupa de distribuirea cartilor in functie de mana curenta si cartile avute la dispozitie

import java.util.HashMap;

public class Maini {
    //aici vor fi memorate cartile pe care jucatorii le da jos
    //lungime hasmap va fi de #maini este jocul.
    private int nrMana;
    private int nrCarti;
    //retine jucatorul si cartea pe care a dat-o
    private final HashMap<Jucator, Carti> mana;  
    //


    
//    private void cineCastiga(){
//        //jucatorul care are cel mai mare ATUU
//        //jucatorul care are cea mai mare carte de culoare celui care a dat primul
//        //
//        for(Jucator x:mana.get(this)){
//            
//        }
//
//    }

    public Maini(int nrMana, int nrCarti, HashMap hm) {
        this.nrMana = nrMana;
        this.nrCarti = nrCarti;
        mana = hm;
    }

    public int getNrMana() {
        return nrMana;
    }

    public void setNrMana(int nrMana) {
        this.nrMana = nrMana;
    }

    public int getNrCarti() {
        return nrCarti;
    }

    public void setNrCarti(int nrCarti) {
        this.nrCarti = nrCarti;
    }
    
    
    
}
