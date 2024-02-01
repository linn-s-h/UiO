
class Fisk{
    int stoerrelse;
    String navn;

    public Fisk(int stoerrelse, String navn){
        this.stoerrelse = stoerrelse;
        this.navn = navn;
    }
    public int hentStoerrelse(){
        return stoerrelse;
    }
}