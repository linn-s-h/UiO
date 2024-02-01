
class Ol extends Drikke implements Drikkbar{

    public Ol(double maxTeller){
        super(maxTeller);
    }
    public void drikkGlass(){
        maxVolum -= 0.5;
        if (maxVolum < 2){
            maxVolum = 0;
            fyllOpp();
        }
    }
    public void fyllOpp(){
        maxVolum += maxTeller;
    }
    @Override
    public String toString(){
        return "Volum er " + maxTeller + " dl og det er naa " + maxVolum + " dl oppi glasset";
    }
}