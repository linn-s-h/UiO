
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class KnivMonitor {

    ArrayList<Kniv> knivBeholder = new ArrayList<Kniv>();
    Lock laas = new ReentrantLock();
    Condition tomtKniver = laas.newCondition();

    public void leggTilKniv(Kniv k){
        laas.lock();
        try {
            knivBeholder.add(k);
        } finally {
            laas.unlock();
        }
     
    }
    public Kniv[] taUtToKniver(){
        laas.lock();
        try {
            if (hentAntKniver() > 1){
                Kniv[] kniver = new Kniv[2];
                /*kniver[0] =*/ knivBeholder.remove(0);
                /*kniver[1] =*/ knivBeholder.remove(0);
                return kniver;
    
            } else {
                return null;
            }
                
        } finally {
            laas.unlock();
        }
     
    }
    public int hentAntKniver(){
        laas.lock();
        try {
            return knivBeholder.size();
        } finally {
            laas.unlock();
        }
    
    }
}