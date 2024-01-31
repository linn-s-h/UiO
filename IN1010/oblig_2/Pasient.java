import java.util.ArrayList;

class Pasient{

    public final String navn;
    public final String foedselsnummer;
    public final int id;
    public static int idTeller = 0;

    public ArrayList<Resept> resepter;

    public Pasient(String navn, String foedselsnummer){
        this.navn = navn;
        this.foedselsnummer = foedselsnummer;
        id = idTeller;
        idTeller++;

        resepter = new ArrayList<>();

    }
    public void leggtilResept(Resept resept){
        resepter.add(resept);
    }
}