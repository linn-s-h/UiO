

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Oblig5Del2A{

    public static void main (String[] args) throws InterruptedException{

        SubsekvensRegister subsekvensRegister = new SubsekvensRegister();
        Monitor1 monitor = new Monitor1(subsekvensRegister);
    
        try {

            File nyFil = new File(args[0] + "/metadata.csv");
            Scanner sc = new Scanner(nyFil);

            //Beholder for trådene
            ArrayList<Thread> lesFilBeholder = new ArrayList<>();
        
            //Leser fra alle filene i metadata.csv som returner en hashmap hver og settes inn i registeret
            while (sc.hasNextLine()){
                String fil = sc.nextLine();
                Thread traad = new Thread(new LeseTrad(args[0] + "/" + fil, monitor));
                lesFilBeholder.add(traad);
                traad.start();
                
            }
             //Vente på at alle filene har blitt lest før det flettes sammen
             for (Thread traad : lesFilBeholder){
                traad.join();
            }

            //Fletter sammen hashmapene helt til det gjenstår en igjen
            while (monitor.antHashMap() > 1){
                HashMap<String, Subsekvens> h1 = monitor.taUtSubsekvenser();
                HashMap<String, Subsekvens> h2 = monitor.taUtSubsekvenser();
                HashMap<String, Subsekvens> flettetHashmap = SubsekvensRegister.flettSammen(h1, h2);
                monitor.settInn(flettetHashmap);
            }
            
            //Finner subsekvens objektet med flest ant forekomster og printer ut den
            if (monitor.antHashMap() == 1){ //gjør en if sjekk just in case
                HashMap<String, Subsekvens> h3 = monitor.taUtSubsekvenser();
                Subsekvens maxSubsekvens = h3.values().iterator().next(); //henter første subsekvens som startverdi
                for (Subsekvens s : h3.values()){
                    if (s.hentAntForekomster() > maxSubsekvens.hentAntForekomster()){
                        maxSubsekvens = s; //endrer subsekvens-peker
                    }
                } System.out.println(maxSubsekvens);
            } 
            sc.close();

        } catch (FileNotFoundException e){
            System.out.println("Fil ikke funnet. " + e);
        }

    }
}