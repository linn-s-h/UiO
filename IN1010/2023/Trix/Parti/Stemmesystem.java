
//beholder klasse //fellesressursen
import java.util.Deque; //stabel interface
import java.util.ArrayDeque;

public enum Parti {
    ARBEIDERPARTIET,
    HOYRE,
    SV,
    RODT,
    FRP,
    SP,
    KRF,
}

//Denne klassen inneholder metoder som skal bli brukt i monitor

class Stemmesystem{

    private Deque<Parti> stemmer = new ArrayDeque<>();

    public void leggTilStemmer(Parti parti){
        stemmer.push(parti); //.push() er leggTil
    }
    public Parti taUtStemme(){
        return stemmer.pop(); //tar ut verdi og får den returnert
    }
    public boolean tomtForStemmer(){
        return stemmer.isEmpty();
    }
}
