
class Rutenett {

    public int r; //antRader
    public int k; //antKolonner
    public Celle[][] rutene;

    public Rutnett(int antRader, int antKolonner){
        r = antRader;
        k = antKolonner;
        rutene = new Celle[r][k];
    }
    public void lagCelle(int r, int k){

        Celle celle = new Celle();
        if (Math.random()<=0.3333){
            celle.settLevende();
        }
        rutene[r][k] = celle; //legger celle i rutenettet
    }
    public void fyllMedTilfeldigeCeller(){
        for (int i = 0; i < rutene.length(); i++){ //gaar gjennom rad saa kolonne
            for (int j = 0; j < rutene[i]; j++){ //gaar gjennom hver rute
                lagCelle(i,j);
            }
        }
    }
    public Celle hentCelle(int r, int k){
        if (r < this.r && r > -1 && k < this.k && k > -1){
            return rutene[r][k];
        }
        return null; //ugyldig saa returnerer null
    }
    public void tegnRutenett(){
        for (int i = 0; i < rutene.length; i++){
            for (int j = 0; j < rutene[i].length; j++){
                System.out.println(rutene[i][j].hentStatusTegn() + " ");
            }
            System.out.println("   ");
        }

    }
    public void settNaboer(int r, int k){
        Celle celle = hentCelle(r,k);
        for (int i = -1; i < 2; i++){ //blir [r-1], [r], r[r+1]
            for (int j = -1; j < 2; j++){ //blir [k-1], [k], [k+1]
                if (!(i == 0 && j == 0)){ //rutene[0][0] er cellen vaar vi jobber rundt
                    if (hentCelle(r+1,k+j) != null){ //vil ungaa NullPointerException
                        celle.leggTilNabo(hentCelle(r+1,k+j)); 
                    }
                }
            }
        }
    }

    public void kobleAlleCeller(){
        for (int i = 0; i < rutene.length; i++){
            for (int j = 0; j < rutene[i].length; j++){
                settNaboer(i,j);
            }
        }
    }
    public void antallLevende(){
        int ant = 0;
        for (int i = 0; i < rutene.length; i++){
            for (int j = 0; j < rutene[i].length; j++){
                if hentCelle(i,j).erLevende();
                ant++;
            }
        } 
        return ant;
    }

}