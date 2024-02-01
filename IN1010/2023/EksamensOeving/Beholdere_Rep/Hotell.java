import java.util.Iterator;

class Hotell implements Iterable<Rom> {
    //Eksamen 2022

    Rom[] forsteRomEtasje;
    int antEtasjer;

    public Hotell(int antEtasjer) {
        this.antEtasjer = antEtasjer;
        forsteRomEtasje = new Rom[antEtasjer + 1];
    }
    // Dette er et eksempel på hvordan man kan løse iteratoroppgaven. 
    class HotellIterator<Rom> implements Iterator<Rom> {
        Rom denne;
        int etasje;

        public HotellIterator() {
            this.etasje = 0;            
            // Finner den første etasjen med rom. 
            while (etasje < antEtasjer+1) {
                if (forsteRomEtasje[etajse] != null) {
                    denne = foforsteRomEtasje[etasje];
                    break;
                }
                etasje++;
            }
        }

        public boolean hasNext() {
            // Hvis denne er null er iteratoren ferdig.
            return denne != null;
        }

        private void settNeste() {
            // Hvis det er flere rom i denne etasjen, henter vi det neste rommet fra denne (Et rom har en etasje, og en neste).
            if (denne.neste != null) {
                denne = denne.neste;
                return;
            }
            // Hvis ikke går vi opp en etasje. 
            etasje++;

            // Finner den neste etasjen som har Rom.
            while (etasje <= antEtasjer+1 ) {
                // Hvis vi har gått ut av toppetasjen er det ikke flere rom, så vi setter denne til null.
                if (etasje == antEtasjer+1) {
                    break;
                }
                // Hvis det er rom i denne etasjen setter vi denne til å være det første rommet i den etasjen, og avslutter funksjone
                if (forsteRomEtasje[etasje] != null) {
                    denne = forsteRomEtasje[etasje];
                    return;
                }
                etasje++;
            }
            // Vi gikk gjennom hele hotellet og fant ikke flere rom.
            denne = null;
        }

        public Rom next() {
            // Her lagrer vi det neste rommet, og så oppdatere vi pekeren før vi returnerer det.
            Rom ret = denne;
            settNeste();
            return ret;
        }
    }

    public Iterator<Rom> iterator() {
        return new HotellIterator<>();
    }
}