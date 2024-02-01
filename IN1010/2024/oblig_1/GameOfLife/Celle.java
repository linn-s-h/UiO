
class Celle {
    public boolean levende;
    public Celle[] naboer;
    public int antLevendeNaboer;
    public int antNaboer;

    public Celle(){
        levende = false;
        naboer = new Celle[8]; 
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
         return '.';

    }
    public void leggTilNabo(Celle nabo){
        if (antNaboer < 9){ //en celle har ikke mer enn 8 naboer
            naboer[antNaboer] = nabo; //maa tilrodne array foer teller oppdateres
            antNaboer++;
        }
    }
    public void tellLevendeNaboer(){
        antLevendeNaboer = 0;
        for (int i = 0; i < naboer.length; i++){ 
            if (naboer[i] != null && naboer[i].erLevende()){ 
                antLevendeNaboer++; 
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
            //trenger ikke else for at celle skal forbli levende
        }
        else{
            if (antLevendeNaboer == 3){ //hvis if kravet ikke blir oppfylt så forblir cellen doed
                settLevende();
            }
        }
    }
}
