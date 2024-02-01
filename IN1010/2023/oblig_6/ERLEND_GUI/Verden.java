import java.util.ArrayList;

public class Verden {

    protected Rutenett rutenett;
    protected int genNr;

    public Verden(int indexCeller) {
        rutenett = new Rutenett(indexCeller, indexCeller);
        genNr = 0;

        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }


    public void tegn() {
        rutenett.tegnRutenett();
        System.out.println("\n\nANT LEVENDE NABOER: " + rutenett.antallLevende());
        System.out.println("GEN: " + genNr);
    }

    public void oppdatering() {     // hovedmetoden som kjøres hver iterasjon. Teller levende naboer og utfra resultatet oppdaterer .levende.

        for (int i = 0; i < rutenett.antRader; i++) {
            for (int ii = 0; ii < rutenett.antKolonner; ii++) {
                rutenett.rutene[i][ii].tellLevendeNaboer();
            }
        }
        for (int i = 0; i < rutenett.antRader; i++) {
            for (int ii = 0; ii < rutenett.antKolonner; ii++) {
                rutenett.rutene[i][ii].oppdaterStatus();
            }
        }
        genNr++;
    }

    public ArrayList<Character> hentStatusPaaCeller() {
        ArrayList<Character> celleStatusTegn = new ArrayList<>();
        for (int i = 0; i < rutenett.antRader; i++) {
            for (int ii = 0; ii < rutenett.antKolonner; ii++) {
                celleStatusTegn.add(rutenett.rutene[i][ii].hentStatusTegn());
            }
        }
        return celleStatusTegn;
    }
}
