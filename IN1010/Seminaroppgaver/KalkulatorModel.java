

class KalkulatorModel{

    private double resultat;

    public double hentResultat(){
        return resultat;
    }

    public void plusse(double t1, double t2){
        resultat = t1 + t2;
    }
    public void minuse(double t1, double t2){
        resultat = t1 - t2;
    }
    public void gange(double t1, double t2){
        resultat = t1 * t2;
    }
    public void dele(double t1, double t2){
        if (t2 == 0){
            throw new IllegalArgumentException("Kan ikke dele på 0");
        }
        resultat = t1 / t2;
    }
}