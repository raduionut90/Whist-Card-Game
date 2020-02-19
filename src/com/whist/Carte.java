
package com.whist;

import java.util.Objects;

public class Carte {
    private final int valoare;
    private final int culoare;

    public Carte(int valoare, int culoare) {
        this.valoare = valoare;        
        this.culoare = culoare;
    }

    public int getCuloare() {
        return culoare;
    }

    public int getValoare() {
        return valoare;
    }

    @Override
    public String toString() {
    //TODO: extrage array-urile in constante
    String[] culori = {"rosie", "neagra", "romb", "trefla"};
    //TODO: nu e clar de ce array-ul incepe cu null. Nu ar trebui sa fie "2"?
    String[] valori = {"3", "4", "5", "6", "7", "8", "9", "10", "JUVE", "DAMA", "POPA", "AS"};
        //as de rosie
        return valori[valoare] + " de " + culori[culoare];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return valoare == carte.valoare &&
                culoare == carte.culoare;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valoare, culoare);
    }
}
