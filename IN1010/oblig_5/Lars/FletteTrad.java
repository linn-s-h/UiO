import java.util.ArrayList;
import java.util.HashMap;

class FletteTrad implements Runnable{
    Monitor2 m;
    public FletteTrad(Monitor2 m){
        this.m = m;
    }
    public void run(){
        while(!m.omFlettetFerdig()){ 
            ArrayList<HashMap<String,Subsekvens>> mapListe = m.hentToHashMap();
            if (mapListe == null){
                return;
            }
            m.leggTilHashMap(m.settSammenTo(mapListe.get(0), mapListe.get(1)));
        }
        return;
    }
}
