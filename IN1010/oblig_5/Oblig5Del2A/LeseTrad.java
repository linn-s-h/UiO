
import java.util.HashMap;
import java.io.FileNotFoundException;

class LeseTrad implements Runnable {
    
    private String filnavn;
    private Monitor1 monitor;
    public LeseTrad(String fil, Monitor1 m){
        monitor = m;
        filnavn = fil;
    }

    //Run metode som skal lese fra fil og legge til resulterende hashmap
    @Override
    public void run(){
         try {
            HashMap<String, Subsekvens> hashmap = monitor.lesFil(filnavn);
            monitor.settInn(hashmap); 
         } catch (FileNotFoundException e){
            System.out.println("Fil ikke funnet" + e);
         }
           
    }
}