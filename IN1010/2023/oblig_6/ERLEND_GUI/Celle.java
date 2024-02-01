

public class Celle{

    private int antNaboer;
    private int antLevendeNaboer;
    private boolean levende;
    private Celle[] naboer;

    public Celle() {
        antNaboer = 0;
        antLevendeNaboer = 0;
        levende = false;
        naboer = new Celle[8];
    }


    public boolean erLevende() {
        return levende;
    }

    public void settDoed() {
        levende = false;
    }

    public void settLevende() {
        levende = true;
    }

    public char hentStatusTegn() {  // returnerer String "O" eller".
        if (levende == true){
            return 'O';
        }
        else {
            return '.';
        }
    }

    public void leggTilNabo(Celle nabo) {   // looper gjennom liste med naboer: hvis element er null: sett nabo på den indeksen.
        boolean b = true;

        for (int i = 0; i < naboer.length; i++){
            if (naboer[i] == null && b == true) { 
                naboer[i] = nabo;
                b = false;
                antNaboer++;
            }
        }
    }

    public void tellLevendeNaboer() {   // looper gjennom liste med naboer: ++ for hver nabo hvor .levende == true.
        antLevendeNaboer = 0;
        
        for (int i = 0; i < naboer.length; i++) {
            if (naboer[i] != null){
                if (naboer[i].erLevende()) {
                    antLevendeNaboer++;
                }
            }
        }
    }


    public void oppdaterStatus() {   // ulike statements som bestemmer om celle.levende settes true / false.

        if (erLevende()) {
            if (antLevendeNaboer < 2) {
                settDoed();
            }
            else if (antLevendeNaboer > 3) {
                settDoed();
            }
        }

        else {
            if (antLevendeNaboer == 3) {
                settLevende();
            }
        }
    }
}