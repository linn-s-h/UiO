
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileNotFoundException;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class Monitor2 {

    Lock laas = new ReentrantLock();
    Condition tomBeholder = laas.newCondition();
    int antFlettinger = 0;
    int forventetFlettinger = 0;

    private SubsekvensRegister subsekvensRegister;
    public Monitor2(SubsekvensRegister subsekvensRegister){
        this.subsekvensRegister = subsekvensRegister;
    }

    //Metode som tar ut to subsekvenser og legger til i egen beholder som skal returneres
    public ArrayList<HashMap<String, Subsekvens>> hentUtTo(){
        laas.lock();
        try {
            while (antHashMap() < 2){
                if (ferdig(antFlettinger)){
                    return null;
                }
                tomBeholder.await();
            }
            ArrayList<HashMap<String, Subsekvens>> hentUtTo = new ArrayList<HashMap<String, Subsekvens>>();
            hentUtTo.add(subsekvensRegister.taUtSubsekvenser());
            hentUtTo.add(subsekvensRegister.taUtSubsekvenser());
            return hentUtTo;
       
        } catch (InterruptedException e){
            System.out.println(e);
            return null;
        } finally {
            laas.unlock();
        }
    }

    //Metoder for å unngå deadlock i main
    public boolean ferdig(int antFlettinger){
        return forventetFlettinger == antFlettinger;
    }
    //Setter ant flettinger som skal gjøres, sendes inn fra main etter alle filer er lest
    public void settAntFlettinger(int ant){
        forventetFlettinger = ant;
    }
    
    //Monitor2 to sin 'settInnSubsekvenser()' metode
    public void settInnFlettet(HashMap<String, Subsekvens> hashmap){
        laas.lock();
        try {
            subsekvensRegister.settInnSubsekvenser(hashmap);
            antFlettinger++;
            if (antHashMap() > 1 || ferdig(antFlettinger)){
                tomBeholder.signalAll();
            } 
       
        } finally {
            laas.unlock();
        }
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