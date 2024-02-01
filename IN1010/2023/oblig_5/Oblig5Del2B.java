

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;

class Oblig5Del2B{

    public static void main (String[] args) throws InterruptedException{

        final int ANTALL_TRAADER = 8; //Konstant settes til 8

        SubsekvensRegister subsekvensRegister = new SubsekvensRegister();
        Monitor2 monitor = new Monitor2(subsekvensRegister);
    
        try {

            File nyFil = new File(args[0] + "/metadata.csv");
            Scanner sc = new Scanner(nyFil);

            ArrayList<Thread> lesFilBeholder = new ArrayList<>();
        
            //Leser fra alle filene i metadata.csv som returner en hashmap hver og settes inn i monitoren
            while (sc.hasNextLine()){
                String fil = sc.nextLine();
                Thread traad = new Thread(new LeseTrad(args[0] + "/" + fil, monitor));
                lesFilBeholder.add(traad);
                traad.start();  
            }

            //Venter på at alle filene har blitt lest før det flettes sammen, for å unngå illegal argument
            for (Thread traad : lesFilBeholder){
                traad.join();
            }

            //Trådene fletter hashmap til det er 1 igjen //Setter CountDown
            CountDownLatch antTraader = new CountDownLatch(monitor.antHashMap() - 1);

            //Tråd-beholder
            Thread[] traadBeholder = new Thread[ANTALL_TRAADER];

            for (int i = 0; i < ANTALL_TRAADER; i++){
                traadBeholder[i] = new Thread(new FletteTrad(monitor, antTraader));
                traadBeholder[i].start();
            }

            //Barriere, venter på at alle trådene har gjort seg ferdig før programmet går videre i main
            try {
                antTraader.await(); //vil vente på alle trådene
                System.out.println("Alle traader ferdig.");
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            //Finner subsekvens objektet med flest ant forekomster og printer ut den
            if (monitor.antHashMap() == 1){ //gjør en if sjekk just in case
                HashMap<String, Subsekvens> h3 = monitor.taUtSubsekvenser(); //i monitoren ligger det kun en hashmap
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