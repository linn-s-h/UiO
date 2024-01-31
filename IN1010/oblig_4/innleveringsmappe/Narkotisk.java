class Narkotisk extends Legemiddel{
    public final int styrke;
    public Narkotisk(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff, "narkotisk", styrke);
        this.styrke = styrke;
    }
}