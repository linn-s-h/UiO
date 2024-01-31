
import java.util.Iterator;

class KullArray extends Kull{

    private Hund[] hunder = new Hund[60];
    KullArray(Hund mor, Hund far){
        super(mor, far);
    }
    public void settInn(Hund h){
        int sek = h.minFodselstid.sek;
        h.neste = hunder[sek];
        hunder[sek] = h;
    }
    public void skrivAlle(){
        for (int i = 0; i < 60; i++){
            Hund h = hunder[i];
            while (h != null){
                System.out.println(h.navn);
                h = h.neste;
            }
        }
        //eller !!!
        for (Hund h : this){
            System.out.println(h.navn);
        }  
    }
    @Override
    public Iterator<Hund> iterator(){
        return new HundeIterator();
    }
    class HundeIterator implements Iterator<Hund>{

        int pos;
        Hund denne;

        HundeIterator(){
            pos = 0;
            denne = null;
            while (true){
                if (pos > 59){
                    break;
                }
                if (hunder[pos] != null){
                    denne = hunder[pos];
                    break;
                }
                pos++;
            }
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public Hund next(){
            Hund hund = denne;
            if (denne.neste != null){
                denne = denne.neste; //Itererer som vanlig
            } else {
                pos++;
                while (pos < 60 && hunder[pos] == null){
                    //itererer 'pos' til en hund ikke gir null eller utenfor listen
                    pos++;
                }
                if (pos < 60){
                    //hvis 'pos' er mindre enn 60, hopper denne til hunden med gitt 'pos'
                    denne = hunder[pos];
                } else { //men hvis 'pos' er større en 59, så er det ikke flere hunde-objekter
                    denne = null;
                }
            } return hund;
        }
    }
}