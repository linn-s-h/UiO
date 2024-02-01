class BlaaResept extends Resept {
    static double rabatt = 0.75;
    private final Pasient pasient;
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);
        double gammelPris = Math.round(legemiddel.hentPris() * rabatt);
        int nyPris = (int) gammelPris;
        legemiddel.settPris(nyPris);
        this.pasient = pasient;
    }

    public String farge(){
        return "Blaa";
    }

    public int prisAaBetale(){
        return legemiddel.hentPris();
    }

    public String toString(){
        //return String.format("Resept: %s, Pris: %s, Reit: %s, type: Blaa", legemiddel.toString(), this.prisAaBetale(), this.reit);
        // ^^ måtte endre for å fungere med skrivTilFil. Skal støtte formatet til forhåndsutgitte innlesningsfiler.     
        
        String legemiddelNummer = Integer.toString(legemiddel.hentId());
        String legeNavn = utskrivendeLege.toString();
        String pasientID = Integer.toString(pasient.hentPasientId());
        String reitStr = Integer.toString(reit);

        String str = legemiddelNummer + "," + legeNavn + "," + pasientID + "," + "blaa" + "," + reitStr;
        return str;
    }
}