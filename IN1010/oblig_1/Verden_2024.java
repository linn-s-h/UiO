
class Verden{

    public int r;
    public int k;
    public Rutenett rutenett;
    public int genNr;

    public Verden(int antRader, int antKolonner){
        r = antRader;
        k = antKolonner;
        rutenett = new Rutenett(antRader, antKolonner);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
        genNr = 0;

    }
}