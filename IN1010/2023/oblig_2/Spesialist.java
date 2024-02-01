
class Spesialist extends Lege implements Godkjenningsfritak{

    protected String kontrollKode;
    public Spesialist(String navnLege, String kode){
        super(navnLege); //arver kun navnLege fra Lege
        kontrollKode = kode; //Spesialist har sin egen egenskap Lege ikke har
    }
    public String hentKontrollKode(){
        return kontrollKode;
    }
    @Override
    public String toString(){
        return super.toString() + " – " + "Kontrollkode: " + kontrollKode;
    }
}