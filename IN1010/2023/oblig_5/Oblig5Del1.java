

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Oblig5Del1{

    public static void main (String[] args){

        SubsekvensRegister subsekvensRegister = new SubsekvensRegister();
    
        try {

            File nyFil = new File("metadata.csv");
            Scanner sc = new Scanner(nyFil);
        
            //Leser fra alle filene i metadata.csv som returner en hashmap hver og settes inn i registeret
            while (sc.hasNextLine()){
                String fil = sc.nextLine();
                HashMap<String, Subsekvens> hashmap = SubsekvensRegister.lesFil(fil);
                subsekvensRegister.settInnSubsekvenser(hashmap);
            }
            
            //Fletter sammen hashmapene helt til det gjenstår en igjen
            while (subsekvensRegister.antHashMap() > 1){
                HashMap<String, Subsekvens> h1 = subsekvensRegister.taUtSubsekvenser();
                HashMap<String, Subsekvens> h2 = subsekvensRegister.taUtSubsekvenser();
                HashMap<String, Subsekvens> flettetHashmap = SubsekvensRegister.flettSammen(h1, h2);
                subsekvensRegister.settInnSubsekvenser(flettetHashmap);
            }
            
            //Finner subsekvens objektet med flest ant forekomster og printer ut den
            if (subsekvensRegister.antHashMap() == 1){ //gjør en if sjekk just in case
                HashMap<String, Subsekvens> h3 = subsekvensRegister.taUtSubsekvenser();
                Subsekvens maxSubsekvens = h3.values().iterator().next(); //henter første subsekvens som startverdi
                for (Subsekvens s : h3.values()){
                    if (s.hentAntForekomster() > maxSubsekvens.hentAntForekomster()){
                        maxSubsekvens = s;
                    }
                } System.out.println(maxSubsekvens);
            } 
            sc.close();

        } catch (FileNotFoundException e){
            System.out.println("Fil ikke funnet. " + e);
        }

    }
}