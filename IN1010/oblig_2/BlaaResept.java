
class BlaaResept extends Resept{

    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }
    public String farge(){
        return "blaa";
    }
    public int prisAaBetale(){
        int naaPris = (int)Math.round(legemiddel.hentPris() * 0.25);
        return naaPris;
    }
}