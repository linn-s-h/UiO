
class Aapning extends HvitRute{

    public Aapning(int rad, int kol, Labyrint labyrint){
        super(rad, kol, labyrint);
    }
    @Override
    public void finn(Rute fra){
        String r = Integer.toString(rad);
        String k = Integer.toString(kol);
        System.out.println("(" + r + "," + k + ")");
        return;
    }
    
    public String toString(){
        return ".";
    }
}