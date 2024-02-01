
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

    public ArrayList<HashMap<String, Subsekvens>> hentBeholder(){
        return subsekvensRegister.hentBeholder();
    }

    //Metode som tar ut to subsekvenser og legger til i egen beholder som skal returneres
    public ArrayList<HashMap<String, Subsekvens>> hentUtTo(){
        laas.lock();
        try {
            while(antHashMap() < 2){
                try{
                    if (ferdig()){
                        return null;
                    }
                    tomBeholder.await();

                }catch (InterruptedException e){
                    System.out.println("gikk galt ved await");
                }
            }
            
            ArrayList<HashMap<String, Subsekvens>> hentUtTo = new ArrayList<HashMap<String, Subsekvens>>();
            hentUtTo.add(subsekvensRegister.hentBeholder().get(1));
            subsekvensRegister.hentBeholder().remove(1);
            hentUtTo.add(subsekvensRegister.hentBeholder().get(0));
            subsekvensRegister.hentBeholder().remove(0);
  
            return hentUtTo;
        } catch (IndexOutOfBoundsException e){
            System.out.println("index out of bounds");
            return null;
        } finally {
            laas.unlock();
        }
    }
    public boolean ferdig(){
        return forventetFlettinger == antFlettinger;
    }
    public void settAntFlettinger(int ant){
        forventetFlettinger = ant;
    }
    
    //Monitor2 to sin 'settInnSubsekvenser()' metode
    public void settInnFlettet(HashMap<String, Subsekvens> hashmap){
        laas.lock();
        try {
            subsekvensRegister.settInnSubsekvenser(hashmap);
            antFlettinger++;
            if (antHashMap() > 1 || ferdig()){
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
        } finally {
            laas.unlock();
        }
    } 

    public HashMap<String, Subsekvens> taUtSubsekvenser(){
        laas.lock();
        try {
            return subsekvensRegister.taUtSubsekvenser();

        } /*catch (InterruptedException e){
            System.out.println(e);
            return null;
        }*/  finally {
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
        return SubsekvensRegister.flettSammen(h1, h2);
    }
    public HashMap<String, Subsekvens> lesFil(String filnavn) throws FileNotFoundException{
      return SubsekvensRegister.lesFil(filnavn);
    }
}