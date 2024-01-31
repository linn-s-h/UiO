class Spesialist extends Lege implements Godkjenningsfritak{

    String kontrollkode;

    public Spesialist(String navn, String kontrollkode){
        super(navn);
        this.kontrollkode = kontrollkode;
    }

    public String hentKontrollKode(){
        return kontrollkode;
    }
    public String toString(){
        String str = navn + ", " + kontrollkode;
        return str;
    }
}