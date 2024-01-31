
abstract class Resept{

    public Legemiddel legemiddel;
    public Lege utskrivendeLege;
    public int pasientId;
    public int reit; //antall ganger som er igjen på resespten
    public final int id; 
    public static int idTeller = 0;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        this.legemiddel = legemiddel; //referanse til legemiddel
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        id = idTeller; 
        idTeller++; //id stiger for hver objekt som opprettes
    }
    public int hentId(){
        return id;
    }
    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }
    public Lege hentLege(){
        return utskrivendeLege;
    }
    public int hentPasientId(){
        return pasientId;
    }
    public int hentReit(){
        return reit;
    }
    public boolean bruk(){
        if (reit < 1){ //resept oppbrukt
            return false;
        }
        else{
            reit--;
            return true;
        }
    }
    abstract public String farge();
    abstract public int prisAaBetale();

    @Override
    public String toString(){
        String beskrivelse = ("Legemiddel: " + legemiddel.toString() + "\n");
        beskrivelse += ("Lege: " + utskrivendeLege.toString() + "\n");
        beskrivelse += ("Pasient id: " + pasientId + "\n");
        beskrivelse += ("Reit: " + reit + "\n");
        beskrivelse += ("Farge: " + farge() + "\n");
        beskrivelse += (getClass().getName() + " pris: " + prisAaBetale());
        return beskrivelse;
    }
}