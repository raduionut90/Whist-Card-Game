
package whist;

public class Carti {
    private final int valoare;
    private final int culoare;

    public Carti(int valoare, int culoare) {
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
    String[] culori = {"rosie", "neagra", "romb", "trefla"};
    String[] valori = {null, "3", "4", "5", "6", "7", "8", "9", "10", "JUVE", "DAMA", "POPA", "AS"};
        //as de rosie
        return valori[valoare] + " de " + culori[culoare];
    }
    
    
}
