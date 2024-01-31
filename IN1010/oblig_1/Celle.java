
class Celle {
    public boolean levende;
    public Celle[] naboer;
    public int antLevendeNaboer;
    public int antNaboer;

    public Celle(){
        levende = false;
        naboer = new Celle[8]; // en array med Celle-pekere
        antLevendeNaboer = 0;
        antNaboer = 0; //blir brukt som teller i senere metode
    }
    public void settDoed(){
        levende = false;
    }
    public void settLevende(){
        levende = true;
    }
    public boolean erLevende(){
        return levende;
    }
    public char hentStatusTegn(){
        if (erLevende()){
            return 'O';
        }
        else{
            return '.';
        }
    }
    public void leggTilNabo(Celle nabo){
        if (antNaboer < 9){ //en celle har ikke mer enn 8 naboer
            naboer[antNaboer] = nabo; //tilordning til array
            antNaboer++; //antNaboer er en teller
        }
    }
    public void tellLevendeNaboer(){
        antLevendeNaboer = 0;
        for (int i = 0; i < naboer.length; i++){ //henter alle naboer
            if (naboer[i] != null && naboer[i].erLevende()){ 
                antLevendeNaboer++; //instans blir oppdatert. 
                                    //må bruke instansen som teller ellers dukker det opp
                                    //en logikkfeil i klasse Verden!
            }
        }
    }
    public void oppdaterStatus(){
        if (erLevende()){
            if (antLevendeNaboer > 3){
                settDoed();
            }
            else if (antLevendeNaboer < 2){
                settDoed();
            }
        }
        else{
            if (antLevendeNaboer == 3){ //hvis if sjekken ikke blir oppfylt så forblir cellen død
                settLevende(); 
            }
        }
    }
}


