

class GOLModell{

    public int antRader;
    public int antKolonner;
    public Verden verden;
    public Rutenett rutenett;
    public Celle celle;
    public Celle[][] alleCeller;

    public GOLModell(int antRader, int antKolonner){
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        verden = new Verden(antRader, antKolonner);
        rutenett = verden.hentRutenett();
        alleCeller = new Celle[antRader][antKolonner];
    }

    public Celle hentCelle(int r, int k){
        celle = rutenett.hentCelle(r,k);
        return celle;
    }
    public boolean hentCelleStatus(Celle celle){
        return celle.erLevende(); //returner true hvis levende, false hvis doed
    }
    public void settLevende(Celle celle){
        celle.settLevende();

    }
    public void settDoed(Celle celle){
        celle.settDoed();
    }
    public int antallLevende(){
        int antLevende = rutenett.antallLevende();
        return antLevende;
    }
    //Kaller på oppdatering-metoden til verden
    public void oppdaterVerden(){
        verden.oppdatering();
    }
    
    //For å oppdatere view så må vi samle alle cellene i en return, som kontroll må hente fra modell
    public Celle[][] hentAlleCeller(){
        for (int r = 0; r < antRader; r++){
            for (int k = 0; k < antKolonner; k++){
                Celle celle = hentCelle(r,k);
                alleCeller[r][k] = celle;
            }
        }
        return alleCeller;
    }
    public boolean hentStatus(int r, int k){
        Celle celle = alleCeller[r][k];
        return celle.erLevende();

    }
 
}
