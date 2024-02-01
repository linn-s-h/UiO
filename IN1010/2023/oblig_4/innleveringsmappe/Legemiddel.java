abstract class Legemiddel{
    public static int teller = 0;
    public final String navn;
    public final String type;
    public int pris;
    public final double virkestoff;
    private final int styrkeTilString;
    public final int id;
    public Legemiddel(String navn, int pris, double virkestoff, String type, int styrke){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.type = type;
        this.styrkeTilString = styrke;
        id = teller;
        teller++;
    }
    public String hentNavn(){
        return this.navn;
    }

    public int hentPris(){
        return this.pris;
    }

    public void settPris(int pris){
        this.pris = pris;
    }

    public int hentId(){
        return this.id;
    }

    public String toString(){
        //return String.format(
        //        "%s, ID: %s, Pris: %s, Virkestoff: %s", this.navn, this.id, this.pris, this.virkestoff
        //);

        String prisStr = Integer.toString(pris);
        String virkestoffStr = Double.toString(virkestoff);
        String idStr = Integer.toString(id);
        String styrkeStr = Integer.toString(styrkeTilString);
        // navn + type.

        if (!type.equals("vanlig")){
            return navn + "," + type + "," + prisStr + "," + virkestoffStr + "," + styrkeStr; // med styrke.
        }
         return navn + "," + type + "," + prisStr + "," + virkestoffStr; // returner uten styrke
    }
}