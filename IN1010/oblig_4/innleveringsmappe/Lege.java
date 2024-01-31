
import java.util.ArrayList;

 class Lege implements Comparable<Lege>{ //skrev om på abstract og implementerer Comparable
    protected String navn;
    protected IndeksertListe<Resept>utskrevneResepter = new IndeksertListe<>();
    public Lege(String navn){
        this.navn = navn;
    }
    public String hentNavn(){
        return this.navn;
    }

    public String toString(){
        return String.format(navn + ",0");
        
    }

    public int compareTo(Lege annenLege){ //skal compare //kanskje utvide til å tenke på om det er en liste med flere leger
        if(this.navn.compareTo(annenLege.navn) < 0) return -1;
        if(this.navn.compareTo(annenLege.navn)> 0) return 1;
        else{
            return 0;
        }
    }
    //ArrayList<Lege> legeListe = new ArrayList<Lege>();
    //legger til lege i en liste?
   // Array.sort(legerListe);
    
    public IndeksertListe<Resept> hentUtskrevneResepter(){ //funksjonaliteten for å hente listen
        return utskrevneResepter;
    }
    
    //oppgave D3: opprette Metodesignaturene
    public HvitResept skrivHvitResept(Legemiddel legemiddel,Pasient pasient,int reit) throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this,legemiddel);
        }
        HvitResept nyHvitResept = new HvitResept(legemiddel,this,pasient,reit);
        utskrevneResepter.leggTil(nyHvitResept);
        pasient.leggtilResept(nyHvitResept);
        return nyHvitResept;


    }
    
    public MilResept skrivMilResept(Legemiddel legemiddel,Pasient pasient) throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this,legemiddel);
        }
        MilResept nyMilResept = new MilResept(legemiddel,this,pasient);
        utskrevneResepter.leggTil(nyMilResept);
        pasient.leggtilResept(nyMilResept);
        return nyMilResept;

    }

    public Presept skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this,legemiddel);
        }

        Presept nyPresept = new Presept(legemiddel,this,pasient, reit);
        utskrevneResepter.leggTil(nyPresept);
        pasient.leggtilResept(nyPresept);
        return nyPresept;
    }
    public BlaaResept skrivBlaaResept (Legemiddel legemiddel,Pasient pasient,int reit) throws UlovligUtskrift{
        
        if(legemiddel instanceof Narkotisk){
            if(this instanceof Spesialist){
                BlaaResept nyBlaaResept = new BlaaResept(legemiddel,this,pasient,reit);
                utskrevneResepter.leggTil(nyBlaaResept);
                pasient.leggtilResept(nyBlaaResept);
                return nyBlaaResept;
            }
            else{
                 throw new UlovligUtskrift(this,legemiddel);
                 }
         }   
        else{
            BlaaResept nyBlaaResept = new BlaaResept(legemiddel,this,pasient,reit);
            utskrevneResepter.leggTil(nyBlaaResept);
            pasient.leggtilResept(nyBlaaResept);
            return nyBlaaResept;
        }
    } 
}