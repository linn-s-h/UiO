
class Verden{

    public int r;
    public int k;
    public Rutenett rutenett;
    public int genNr;

    public Verden(int antRader, int antKolonner){
        r = antRader;
        k = antKolonner;
        rutenett = new Rutenett(antRader, antKolonner);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
        genNr = 0;

    }
    public void tegn(){
        System.out.println("  ");
        rutenett.tegnRutenett();
        System.out.println("Generasjon: " + genNr);
        System.out.println("Antall levende celler: " + rutenett.antallLevende());
    }
    public void oppdatering(){
        for (int i = 0; i < r; i++){
            for (int j = 0; j < k; j++){
                rutenett.hentCelle(i,j).tellLevendeNaboer();
            }
        }
          for (int i = 0; i < r; i++){
            for (int j = 0; j < k; j++){
                rutenett.hentCelle(i,j).oppdaterStatus();
            }
        }
        genNr++;
    }
    
}