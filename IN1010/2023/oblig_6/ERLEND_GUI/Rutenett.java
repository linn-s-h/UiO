

public class Rutenett {

    public int antRader;
    public int antKolonner;
    public Celle[][] rutene;

    public Rutenett(int _antRader, int _antKolonner) {
        antRader = _antRader;
        antKolonner = _antKolonner;

        rutene = new Celle[antRader][antKolonner];  // initialiserer nøstet liste med Celle objekter.
    }


    public void lagCelle(int r, int k) {    // setter startspunkt for celler i rutenett med indeks [r][k].
        Celle celle = new Celle();
        if (Math.random()<=0.3333) {
            celle.settLevende();
        }
        else {
            celle.settDoed();
        }
        rutene[r][k] = celle;
    }

    public void fyllMedTilfeldigeCeller() {     // start utgangspunkt for celler i rutenett.
        for (int i = 0; i < rutene.length; i++) {
            for (int ii = 0; ii < rutene[i].length; ii++){
                lagCelle(i, ii);
            }
        }
    }

    public Celle hentCelle(int r, int k) {      // sjekker om r og K er en gyldig plass i rutenettet. Om ikke, return null.
        if (r < rutene.length && r > 0) {
            if (k < rutene[r].length && k > 0) {
                return rutene[r][k];
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public void tegnRutenett() {
        for (Celle[] rad : rutene) {
            System.out.print("\n");
            for (Celle celle : rad) {
                System.out.print(celle.hentStatusTegn());
            }
        }
    }

    public void settNaboer(int rad, int kolonne) {  // setter naboer for alle celler i rutenettet. Bruker hentCelle og sjekker
        Celle mainCelle = rutene[rad][kolonne];     // om det er en gyldig celle. 

        for (int i = -1; i < 2; i++) {
            for (int ii = -1; ii < 2; ii++) {

                Celle sjekketCelle = hentCelle(rad+i, kolonne+ii);

                if (sjekketCelle != null && sjekketCelle != mainCelle) {
                    mainCelle.leggTilNabo(sjekketCelle);
                }
            }
        }
    }

    public void kobleAlleCeller() {
        for (int i = 0; i < rutene.length; i++) {
            for (int ii = 0; ii < rutene[i].length; ii++) {
                settNaboer(i, ii);
            }
        }
    }

    public int antallLevende() {    // for loops som sjekker alle celler i rutenett. Om .levende: teller++
        int teller = 0;

        for (int i = 0; i < rutene.length; i++) {
            for (int ii = 0; ii < rutene[i].length; ii++) {
                if (rutene[i][ii].erLevende()) {
                    teller++;
                }
            }
        }
        return teller;
    }
}