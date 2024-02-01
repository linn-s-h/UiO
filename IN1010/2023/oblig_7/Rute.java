

abstract class Rute{

    int rad;
    int kol;
    Labyrint labyrint;
    Rute[] naboer;
    int antNaboer = 0;

    Rute nord;
    Rute syd;
    Rute vest;
    Rute oest;

    public Rute(int rad, int kol, Labyrint labyrint){
        this.rad = rad;
        this.kol = kol;
        this.labyrint = labyrint;
        naboer = new Rute[4]; //Nord //Syd //Vest //Oest
    }

    public void leggTilNabo(Rute nabo){

        naboer[antNaboer] = nabo;
        if (antNaboer == 0){
            nord = naboer[antNaboer];
        }
        else if (antNaboer == 1){
            syd = naboer[antNaboer];
        }
        else if (antNaboer == 2){
            vest = naboer[antNaboer];
        }
        else if (antNaboer == 3){
            oest = naboer[antNaboer];
        }
        antNaboer++;
    }

    //Denne metoden blir uansett overskrevet av subklassene
    public void finn(Rute fra){}

    public boolean erHvit(){
        return false; //Subklasser vil også overskrive denne metoden
    }

    @Override
    public String toString(){
        return "";
    }
}