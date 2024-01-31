
class MilResept extends HvitResept {
    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient){
        super(legemiddel, utskrivendeLege, pasient, 3);
    }

    @Override
    public int prisAaBetale(){
        return 0;
    }

    public int hentReit(){
        return this.reit;
    }


    @Override
    public String toString(){
        //return String.format("Resept: %s, Pris: %s, Reit: %s, type: Militaer", legemiddel.toString(), this.prisAaBetale(), this.reit);
        
        // ^^ måtte endre for å fungere med skrivTilFil. Skal støtte formatet til forhåndsutgitte innlesningsfiler.

        String legemiddelNummer = Integer.toString(legemiddel.hentId());
        String legeNavn = utskrivendeLege.toString();
        String pasientID = Integer.toString(pasient.hentPasientId());

        String str = legemiddelNummer + "," + legeNavn + "," + pasientID + "," + "militaer";
        return str;
    }   
}
