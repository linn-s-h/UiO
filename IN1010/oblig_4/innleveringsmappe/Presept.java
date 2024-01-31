class Presept extends HvitResept {
    static int rabatt = 108;
    public Presept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);
        if ((legemiddel.hentPris() - rabatt) <= 0){
            legemiddel.settPris(1);
        }else{
            int nyPris = legemiddel.hentPris() - rabatt;
            legemiddel.settPris(nyPris);
        }
    }

    @Override
    public int prisAaBetale(){
        return legemiddel.hentPris();
    }

    @Override
    public String toString(){
        //return String.format("Resept: %s, Pris: %s, Reit: %s, type: P", legemiddel.toString(), this.prisAaBetale(), this.reit);
        // ^^ måtte endre for å fungere med skrivTilFil. Skal støtte formatet til forhåndsutgitte innlesningsfiler.     
        
        String legemiddelNummer = Integer.toString(legemiddel.hentId());
        String legeNavn = utskrivendeLege.toString();
        String pasientID = Integer.toString(pasient.hentPasientId());
        String reitStr = Integer.toString(reit);

        String str = legemiddelNummer + "," + legeNavn + "," + pasientID + "," + "p" + "," + reitStr;
        return str;
    }
}
