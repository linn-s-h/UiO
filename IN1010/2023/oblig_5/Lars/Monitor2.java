import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Monitor2 {
    SubsekvensRegister subsekvensregister = new SubsekvensRegister();
    Lock lock = new ReentrantLock();
    Condition nok = lock.newCondition();
    int antallInnlesteHash = 0;
    int antallFlettinger = 0;
    public void leggTilHashMap(HashMap<String,Subsekvens> nyHashMap){
        lock.lock();
        try{
            subsekvensregister.leggTilHashMap(nyHashMap);
            antallFlettinger++;
            if (antallHashMap() >= 2 || omFlettetFerdig()){
                nok.signalAll();
            }
        } finally{
            lock.unlock();
        }
    }
    public ArrayList<HashMap<String,Subsekvens>> hentToHashMap(){
        lock.lock();
        try{ 
            while (antallHashMap() < 2){
                if (omFlettetFerdig()){
                    return null;
                }
                nok.await();
            }
            ArrayList<HashMap<String,Subsekvens>> returliste = new ArrayList<HashMap<String,Subsekvens>>();
            returliste.add(hentHashMap(0));
            returliste.add(hentHashMap(0));
           
            return returliste;
        } catch(InterruptedException e){
            System.out.println("noe feil med hent to hashmap");
            return null;
        } finally{
            lock.unlock();
        }
    }
    public ArrayList<HashMap<String,Subsekvens>> hentListe(){
        return subsekvensregister.hentListe();
    }
    public HashMap<String,Subsekvens> hentHashMap(int indeks){
        return subsekvensregister.hentHashMap(indeks);
    }
    public int antallHashMap(){
        return subsekvensregister.antallHashMap();
    }
    public HashMap<String,Subsekvens> lesFil(String filnavn){
        return SubsekvensRegister.lesFil(filnavn);
    }
    public HashMap<String,Subsekvens> settSammenTo(HashMap<String,Subsekvens> mapEn, HashMap<String,Subsekvens> mapTo){
        return SubsekvensRegister.settSammenTo(mapEn,mapTo);
    }
    public boolean omFlettetFerdig(){
        if (antallFlettinger == antallInnlesteHash - 1){
            return true;
        }else{
            return false;
        }
    }
    public void lestFerdig(){
        antallInnlesteHash = subsekvensregister.antallHashMap();
        antallFlettinger = 0;
    }

}
