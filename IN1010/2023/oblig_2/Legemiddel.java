abstract class Legemiddel{ // lage objekter via subklasser

    public final String navn;
    private int pris; //har metoder som gjør at vi kan endre den private instansen utenfor klassen
    public final double virkestoff; //angis i mg
    public final int id; 
    public static int idTeller = 0; //må ha en teller som gjelder for alle klasser og ikke resetter seg selv

    public Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.virkestoff = virkestoff;
        this.pris = pris;
        id = idTeller; //med final så er det lov å assigne en final varibel til å peke på en static variabel 
        idTeller++; //id endrer seg for hvert objekt som opprettes, slik at ingen legemiddel har samme id

    }
    public int hentPris(){
        return pris;
    }
    public void settNyPris(int nyPris){
        pris = nyPris;
    }
    @Override
    public String toString(){ //magisk string metode 
        return id + " – " + navn + "(" + virkestoff + " mg): " + pris + " kr"; 
    }
}

