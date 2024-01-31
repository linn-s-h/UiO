

interface Drikkbar{
    void drikkGlass();
    void fyllOpp();
}

class Drikke implements Drikkbar{

    public double maxVolum; //dl
    public final double maxTeller;
    public Drikke(double maxTeller){
        this.maxTeller = maxTeller;
        maxVolum = maxTeller;
    }
    public void drikkGlass(){
        maxVolum -= 2;
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

class Test{
    public static void main(String[] args){
        Drikke glass = new Drikke(15);
        Ol ol_glass = new Ol(12);
        ol_glass.drikkGlass();
        glass.drikkGlass();
        glass.drikkGlass();
        glass.drikkGlass();
        glass.drikkGlass();
        System.out.println(glass);
        System.out.println(ol_glass);
    }
}