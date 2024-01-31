
class Pasient{

    public final String navn;
    public final String foedselsnummer;
    public final int id;
    public static int idTeller = 0;

    public Koe<Resept> resepter;

    public Pasient(String navn, String foedselsnummer){
        this.navn = navn;
        this.foedselsnummer = foedselsnummer;
        id = idTeller;
        idTeller++;

        resepter = new Koe<>();

    }
    public void leggtilResept(Resept resept){
        resepter.leggTil(resept);
    }
    public int hentPasientId(){ //frivillig metode som kan brukes i klassen resept
        return id;
    }

    public Koe hentPasientResepter(){
        return resepter;
    } 

    public String toString(){
        String str = navn + "," + foedselsnummer + "," + id;
        return str;
    }

    public String hentNavn(){
        return navn;
    }
}
