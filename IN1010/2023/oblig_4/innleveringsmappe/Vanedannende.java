class Vanedannende extends Legemiddel{
    public int styrke = 0;
    public Vanedannende(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff, "vanedannende", styrke);
        this.styrke = styrke;
    }
}