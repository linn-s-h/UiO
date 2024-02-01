

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

class Oblig5Hele{
    public static void main(String[] args) throws InterruptedException{
        final int ANTALL_TRAADER = 8;
        //Beholder for smittet
        SubsekvensRegister smittetRegister = new SubsekvensRegister();
        Monitor2 smittet = new Monitor2(smittetRegister);
        //Beholder for ikke-smittet
        SubsekvensRegister friskRegister = new SubsekvensRegister();
        Monitor2 frisk = new Monitor2(friskRegister);
        try {
            //Leser filer
            File metafil = new File(args[0] + "/metadata.csv");
            Scanner sc = new Scanner(metafil);

            ArrayList<Thread> traader = new ArrayList<>();

            while(sc.hasNextLine()){
                String linje = sc.nextLine();
                String[] fData = linje.strip().split(","); //fData[0] er filnavn, fData[1] er smittestatus

                if (fData[1].equals("True")){
                    Thread smittetTraad = new Thread(new LeseTrad(args[0] + "/" + fData[0], smittet));
                    traader.add(smittetTraad);
                    smittetTraad.start();
                    System.out.println("SMITTET!");
                } 
                else {
                    Thread friskTraad = new Thread(new LeseTrad(args[0] + "/" + fData[0], frisk));
                    traader.add(friskTraad);
                    friskTraad.start();
                    System.out.println("FRISK!");
                }
            }
            for (Thread traad : traader){
                traad.join();
            } //Filer er ferdig lest

            System.out.println("Ferdig med aa lese filer"); sc.close();

        } catch (FileNotFoundException e){
            System.out.println(e);
        } 

            Thread[] smittetTraader = new Thread[ANTALL_TRAADER];
            Thread[] friskTraader = new Thread[ANTALL_TRAADER];

            System.out.println(smittet.antHashMap());
            System.out.println(frisk.antHashMap());

            //Sender inn antall forventet flettinger inn til monitoren, for å unngå deadlock
            smittet.settAntFlettinger(smittet.antHashMap()-1);
            frisk.settAntFlettinger(frisk.antHashMap()-1);

            for (int i = 0; i < ANTALL_TRAADER; i++){
                smittetTraader[i] = new Thread(new FletteTrad(smittet));
                friskTraader[i] = new Thread(new FletteTrad(frisk));
                smittetTraader[i].start();
                friskTraader[i].start();
            }
            System.out.println("Venter paa traader");

            //Venter på at trådene har gjort seg ferdig før programmet går videre i main
            try {
                for (Thread traad : smittetTraader){
                    traad.join();
                }
                System.out.println("Smittet traader ferdig.");

                for (Thread traad : friskTraader){
                    traad.join();
                }
                System.out.println("Friske traader ferdig.");
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(smittet.antHashMap());
            System.out.println(frisk.antHashMap());

            //Skal finne dominante subsekvenser //TestData //TestDataLiten

            HashMap<String, Integer> dominante = new HashMap<>();

            HashMap<String, Subsekvens> hSmittet = smittet.hentBeholder().get(0);
            HashMap<String, Subsekvens> hFrisk = frisk.hentBeholder().get(0);
      
            //iterere gjennom smittet beholder og hente ut subsekvens for hver iterasjon
            //if sjekk på om subsekvensen oppstår i frisk beholder, med hFrisk.get(subsekvens)
            //sjekke at den ikke allerede er lagt til i dominante // sjekke at den forekommer 7 ganger fler enn i frisk
            //legge til i dominante
            //else på om subsekvens bare er i smittet
            //sjekke om den har minst 7 forkomster før legges til

            for (String subsekvens : hSmittet.keySet()){
                Subsekvens subsekvens_objekt = hSmittet.get(subsekvens);
                if (hFrisk.get(subsekvens) != null){
                    if (subsekvens_objekt.hentAntForekomster() - hFrisk.get(subsekvens).hentAntForekomster() > 6){
                        int ant = hSmittet.get(subsekvens).hentAntForekomster() - hFrisk.get(subsekvens).hentAntForekomster();
                        dominante.put(subsekvens, ant);
                    }
                } else {
                    if (hSmittet.get(subsekvens).hentAntForekomster() > 6){
                        int ant = hSmittet.get(subsekvens).hentAntForekomster() - hFrisk.get(subsekvens).hentAntForekomster();
                        dominante.put(subsekvens, ant);
                    }
                }
            }
            //Printer ut med en forEach
            dominante.forEach((key, value)->
            System.out.println(key + " har " + value + " flere forekomster."));
            System.out.println(dominante);

    }
}