
package whist;

import java.util.ArrayList;


public class Jucator {
    private final int id;
    private final String nume;
    private int puncteCastigate;
    private boolean first = false;
    ArrayList<Carti> cartiCurente = new ArrayList<>();

    public Jucator(int id, String nume) {
        this.id = id;
        this.nume = nume;
        puncteCastigate = 0;
    }
    
    public Carti alegeCarte(int x){
        return cartiCurente.get(x);
    }
    
    public void preiaCarti(Carti x){
        cartiCurente.add(x);
    } 

    @Override
    public String toString() {
        return "Jucatorul " + nume + " puncte: " + puncteCastigate + " are cartile: " + cartiCurente.toString();
    }
    

    public int getPuncteCastigate() {
        return puncteCastigate;
    }

    public void setPuncteCastigate(int puncteCastigate) {
        this.puncteCastigate = puncteCastigate;
    }

    public ArrayList<Carti> getCartiCurente() {
        return cartiCurente;
    }

    public void setCartiCurente(ArrayList<Carti> cartiCurente) {
        this.cartiCurente = cartiCurente;
    }

    public String getNume() {
        return nume;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }


    
    
    
}
