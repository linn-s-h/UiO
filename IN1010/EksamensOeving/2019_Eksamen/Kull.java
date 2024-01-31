
import java.util.Iterator;

abstract class Kull implements Iterable<Hund>{

    Hund mor, far;
    Kull(Hund mor, Hund far){
        this.mor = mor; this.far = far;
    }
    //med iterator kan elementer printes ut med for-each
    public void skrivUtAlle(){ 
        for (Hund h : this){
            System.out.println(h);
        }
    }
    public abstract void settInn(Hund h);
    public abstract Iterator<Hund> iterator();
}