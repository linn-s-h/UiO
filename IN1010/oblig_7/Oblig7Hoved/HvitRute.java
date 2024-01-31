
class HvitRute extends Rute{

    public HvitRute(int rad, int kol, Labyrint labyrint){
        super(rad, kol, labyrint);
    }
    @Override
    public void finn(Rute fra){

        for (int i = 0; i < naboer.length; i++){
            if (naboer[i] != fra && naboer[i] != null){
                naboer[i].finn(this); //this er referanse til HvitRute
            }
        }
    }
    @Override
    public String toString(){
        return ".";
    }
}

class SortRute extends Rute{

    public SortRute(int rad, int kol, Labyrint labyrint){
        super(rad, kol, labyrint);
    }
    @Override
    public void finn(Rute fra){}

    @Override
    public String toString(){
        return "#";
    }
}

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