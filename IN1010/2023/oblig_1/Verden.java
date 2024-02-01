
class Verden {
    public int genNr;
    public Rutenett rutenett;
    public int antRader;
    public int antKolonner;

    public Verden(int antRader, int antKolonner){
        this.antRader = antRader; // trenger å lage instans av paramtere for å bruke de til metoden oppdatering()
        this.antKolonner = antKolonner;
        rutenett = new Rutenett(antRader, antKolonner); //rutenett er variablen, new Rutenett() er objektet
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
        genNr = 0;
    }
    public void tegn(){
        System.out.println();
        System.out.println("Generasjon nr " + genNr + ":"); System.out.println();
        rutenett.tegnRutenett();
        System.out.println("Det er " + rutenett.antallLevende() + " levende celler.");
        System.out.println();
    }
    public void oppdatering(){
        for(int r = 0; r < antRader; r++){
            for (int k = 0; k < antKolonner; k++){
                rutenett.hentCelle(r,k).tellLevendeNaboer(); //henter hver celle i rutenett
                                                            //og kaller på metode som øker instansteller med ant levende naboer
            }
        }
        for (int r = 0; r < antRader; r++){
            for (int k = 0; k < antKolonner; k++){
                rutenett.hentCelle(r,k).oppdaterStatus(); //henter hver celle i rutenett
                                                        //og oppdaterer status i forhold til NÅ ant levende naboer
            }
        }
        genNr++; // oppdaterer generasjon
    }

}