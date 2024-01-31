
class PResept extends HvitResept{
    
    public static int rabatt = -108; //statisk rabatt
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }
    public int prisAaBetale(){
        int nyPris = (legemiddel.hentPris() + rabatt); //ny pris med rabatt
        if (nyPris > 0){
            return nyPris;
        }
        else{
            return 0; //pris aldri mindre enn 0 selv med rabatt
        }
    }

}