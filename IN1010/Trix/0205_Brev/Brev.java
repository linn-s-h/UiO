import java.util.ArrayList;

class Brev{

    private String avsender;
    private String mottaker;
    ArrayList<String> linjer;

    public Brev(String avsender, String mottaker){
        this.avsender = avsender;
        this.mottaker = mottaker;
        linjer = new ArrayList<String>();
    }
    public void skrivLinje(String linje){
        linjer.add(linje);
    }
    public void lesBrev(){
        System.out.println("Hei " + mottaker + "\n");
        for (String linje : linjer){
            System.out.println(linje);
        }
        System.out.println();
        System.out.println("Hilsen fra, ");
        System.out.println(avsender);
    }
}

class Hovedprogram{
    public static void main(String[] args){
        Brev brevet = new Brev("Per Askeladd", "Espen Askeladd");
        brevet.skrivLinje("Hvordan har du det?");
        brevet.skrivLinje("Jeg har det bare bra!");
        brevet.lesBrev();
    }
}