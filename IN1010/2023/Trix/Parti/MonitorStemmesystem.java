//monitor håndterer fellesressurser //beskyttelseslag for kritiske handlinger 
//låser rundt disse kritiske operasjonene og regioner
//await() er konsumerende metode //throw Exception

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MonitorStemmesystem{

    private Lock laas = new ReentrantLock();
    private Condition ikkeTomt = laas.newCondition();

    private Stemmesystem stemmesystem;
    public MonitorStemmesystem(Stemmesystem stemmesystem){
        this.stemmesystem = stemmesystem;
    }

    public void leggTilStemmer(Parti parti){
        laas.lock();
        try {
            //kritisk region
            stemmesystem.leggTilStemmer(parti); 
            ikkeTomt.signalAll(); //opphever alle tråder ikke kun den første i kø

        } finally {
            laas.unlock();
        }
    }
    public Parti taUtStemme() throws InterruptedException{
        laas.lock();
        try { //uansett hva som skjer i try, så vil det skje
            //kritisk region
            while (tomtForStemmer()){
                ikkeTomt.await(); //passiv venting - bruker ikke undøvendig ressurser
                                    //aktiv venting - while loop som går evig til condition er møtt
                                    //await() venter på betingelse og i riktig rekkefølge 
            }
            return stemmesystem.taUtStemme();

        } finally {
            laas.unlock();
        }
    }
    public boolean tomtForStemmer(){
        laas.lock();
        try {
            //kritisk region
            return stemmesystem.tomtForStemmer();

        } finally {
            laas.unlock();
        }
    }
}