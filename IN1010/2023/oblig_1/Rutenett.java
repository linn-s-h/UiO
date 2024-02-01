
class Rutenett {
    public int antRader;
    public int antKolonner;
    public Celle[][] rutene;   

    public Rutenett(int antRader, int antKolonner){
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutene = new Celle[antRader][antKolonner];
    }
    public void lagCelle(int r, int k){
        Celle celle = new Celle();
        if (Math.random()<=0.3333){ //gir true 1 av 3 ganger
            celle.settLevende(); 
        }
        rutene[r][k] = celle; //legger til celle, levende eller død
    }
    public void fyllMedTilfeldigeCeller(){
        for (int r = 0; r < rutene.length; r++){
            for (int k = 0; k < rutene[r].length; k++){
                lagCelle(r, k);
            }
        }
    }
    public Celle hentCelle(int r, int k){ //metode som returnerer en celle av klassen Celle
        boolean lovlig = false;
        if (r < antRader && r > -1){ //array starter med indeks 0
            if (k < antKolonner && k > -1){
                lovlig = true;
            }
        }

        if (lovlig == false){
            return null; //returnerer null fordi cellens koordinater er utenfor brettet
        }                                                           //ergo ingen celle
        return rutene[r][k];
    }
    
    public void tegnRutenett(){
        for (int r = 0; r < rutene.length; r++){
            for (int k = 0; k < rutene[r].length; k++){
                System.out.print(rutene[r][k].hentStatusTegn() + " ");
            }   //uten hentStatusTegn() vil adressen der objektet ligger i minnet 
                                                            //printes ut i stedet for tegn

            System.out.println("  ");
        }
    }
    public void settNaboer(int r, int k){
        Celle mainCelle = hentCelle(r, k);
        for (int i = -1; i < 2; i++){ // [i-1], [i], [i+1] bestemmer rad
            for (int j = -1; j < 2; j++){ // [j-1], [j], [j+1] bestemmer kolonne
                if (i != 0 || j != 0){ // mainCelle har koordinatene [r+0][k+0]
                    if (hentCelle(r+i, k+j) != null){ //vi vil ikke sette celler utenfor brettet som naboer
                        mainCelle.leggTilNabo(hentCelle(r+i, k+j)); //nabo-celler
                    }
                }
            }
        }
    }
    public void kobleAlleCeller(){
        for (int r = 0; r < rutene.length; r++){
            for (int k = 0; k < rutene[r].length; k++){
                settNaboer(r, k);
            }
        }
    }
    public int antallLevende(){
        int antLevende = 0; //teller
        for (int r = 0; r < rutene.length; r++){
            for (int k = 0; k < rutene[r].length; k++){
                if (hentCelle(r, k).erLevende()){
                    antLevende++;
                }
            }
        }
        return antLevende;
    }
}