
import java.util.Iterator;

class KullListe extends Kull{

    Hund hode = null;
    public KullListe(Hund mor, Hund far){
        super(mor, far);
    }
    
    public void settInn(Hund h){
        if (hode == null){ //hvis første hode er null
            hode = h; //legger til i tom liste
            return;
        }
        if (h.compareTo(hode) < 0){
            h.neste = hode; //denne fremgangsmåten er bedre
            hode = h;
            return;
        }
        Hund p = hode; //Hund er en Node-klasse
        while (true){ 
            if (p.neste == null){ //hvis første ikke er større enn h og neste er null
                p.neste = h; //plasser bakerst
                break;
            } //hvis flere i lenkeliste
            if (h.compareTo(p.neste) < 0){ 
                h.neste = p.neste; //eller p.neste.neste??
                p.neste = h;
                break;
            } else{ //leter videre 
                p = p.neste;
            }
        } 
    }
    @Override
    public Iterator<Hund> iterator(){
        return new HundeIterator();
    }
    class HundeIterator implements Iterator<Hund>{
        private Hund denne = hode;
        
        public boolean hasNext(){ //hasNext() returner alltid en boolean!
            return denne != null;
        }
        public Hund next(){ //hasNext() blir alltid sjekket før next()
            Hund hund = denne;
            denne.neste = denne;
            return hund;
        }
    }
    
}