class HvitResept extends Resept {

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);
    }
    public String farge(){
        return "Hvit";
    }
    public int prisAaBetale(){
        int pris = legemiddel.hentPris();
        return pris;
    }

    public String toString(){
        //return String.format("Resept: %s, Pris: %s, Reit: %s, type: Hvit", legemiddel.toString(), this.prisAaBetale(), this.reit);
        // ^^ måtte endre for å fungere med skrivTilFil. Skal støtte formatet til forhåndsutgitte innlesningsfiler.     
        
        String legemiddelNummer = Integer.toString(legemiddel.hentId());
        String legeNavn = utskrivendeLege.toString();
        String pasientID = Integer.toString(pasient.hentPasientId());
        String reitStr = Integer.toString(reit);

        String str = legemiddelNummer + "," + legeNavn + "," + pasientID + "," + "hvit" + "," + reitStr;
        return str;
    }
}