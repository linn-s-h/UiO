
import java.util.HashMap;
import java.io.FileNotFoundException;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class Monitor1 {

    Lock laas = new ReentrantLock();
    Condition tomBeholder = laas.newCondition();
    
    private SubsekvensRegister subsekvensRegister;
    public Monitor1(SubsekvensRegister subsekvensRegister){
        this.subsekvensRegister = subsekvensRegister;
    }

    //Monitor1 to sin 'settInnSubsekvenser()' metode
    public void settInn(HashMap<String, Subsekvens> hashmap){
        laas.lock();
        try {
            subsekvensRegister.settInnSubsekvenser(hashmap);
            tomBeholder.signalAll(); //join();

        } finally {
            laas.unlock();
        }
    } 
    public HashMap<String, Subsekvens> taUtSubsekvenser(){
        laas.lock();
        try {
            while (antHashMap() < 1){
                tomBeholder.await();
            }
            return subsekvensRegister.taUtSubsekvenser();

        } catch (InterruptedException e){
            System.out.println(e);
            return null;
        } finally {
            laas.unlock();
        }
       
    }
    public int antHashMap(){
        laas.lock();
        try {
            return subsekvensRegister.antHashMap();
        } finally {
            laas.unlock();
        }
    }
    public HashMap<String, Subsekvens> flettSammen(HashMap<String, Subsekvens> h1, HashMap<String, Subsekvens> h2){
        return subsekvensRegister.flettSammen(h1, h2);
    }
    public HashMap<String, Subsekvens> lesFil(String filnavn) throws FileNotFoundException{
      return subsekvensRegister.lesFil(filnavn);
    }
}
