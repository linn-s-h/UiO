abstract class Resept{
    static int teller = 0;
    int id;
    Legemiddel legemiddel;
    Lege utskrivendeLege;
    Pasient pasient;
    int reit;
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasient = pasient;
        this.reit = reit;
        id = teller;
        teller++;
    }

    public String type(){
        String s = getClass().getName();
        return s;
    }

    public int hentId(){
        return this.id;
    }

    public Legemiddel hentLegemiddel(){
        return this.legemiddel;
    }

    public Lege hentLege(){
        return this.utskrivendeLege;
    }

    public int hentPasientId(){
        return pasient.hentPasientId();
    }

    public int hentReit(){
        return this.reit;
    }

    public boolean bruk(){
        if (reit > 0) {
            reit--;
            return true;
        }else{
            return false;
        }
    }

    public Pasient hentPasient(){
        return pasient;
    }

    abstract public String farge();
    abstract public int prisAaBetale();
}