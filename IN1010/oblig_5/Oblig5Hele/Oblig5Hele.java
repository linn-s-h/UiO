

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

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
                String[] fData = linje.split(","); //fData[0] er filnavn, fData[1] er smittestatus

                if (fData[1].equals("True")){
                    Thread traad = new Thread(new LeseTrad(args[0] + "/" + fData[0], smittet));
                    traader.add(traad);
                    traad.start();
                } else {
                    Thread traad = new Thread(new LeseTrad(args[0] + "/" + fData[0], frisk));
                    traader.add(traad);
                    traad.start();
                }
            }
            for (Thread traad : traader){
                traad.join();
            } 
            //Filer er ferdig lest

            System.out.println("Ferdig med aa lese filer ( " + smittet.antHashMap() + " smittet filer / " + frisk.antHashMap() + " friske filer ) ");

            //Starter å flette hashmaps i de to beholderne 
            CountDownLatch antSmittetTraader = new CountDownLatch(smittet.antHashMap() - 1);
            CountDownLatch antFriskeTraader = new CountDownLatch(frisk.antHashMap() - 1); 

            Thread[] smittetTraader = new Thread[ANTALL_TRAADER];
            Thread[] friskTraader = new Thread[ANTALL_TRAADER];

            //Sender inn forventet antall fletting til monitor, for å unngå deadlock
            smittet.settAntFlettinger(smittet.antHashMap() - 1);
            frisk.settAntFlettinger(frisk.antHashMap() - 1);

            for (int i = 0; i < ANTALL_TRAADER; i++){
                smittetTraader[i] = new Thread(new FletteTrad(smittet, antSmittetTraader));
                smittetTraader[i].start();
                friskTraader[i] = new Thread(new FletteTrad(frisk, antFriskeTraader));
                friskTraader[i].start();
            }

            System.out.println("Venter paa flette traader");

            //Barriere //Venter på at trådene har gjort seg ferdig før programmet går videre i main
            try {
                antSmittetTraader.await();
                System.out.println("Smittet traader ferdig.");
                antFriskeTraader.await();
                System.out.println("Friske traader ferdig.");
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            //Skal finne dominante subsekvenser

            HashMap<String, Integer> dominante = new HashMap<>();

            HashMap<String, Subsekvens> hSmittet = smittet.taUtSubsekvenser();
            HashMap<String, Subsekvens> hFrisk = frisk.taUtSubsekvenser();
            
            for (String subsekvens : hSmittet.keySet()){
                Subsekvens subsekvensObj = hSmittet.get(subsekvens);
                if (hFrisk.get(subsekvens) != null){
                    if (subsekvensObj.hentAntForekomster() - hFrisk.get(subsekvens).hentAntForekomster() > 6){
                        dominante.put(subsekvens, subsekvensObj.hentAntForekomster());
                    }
                } else {
                    if (hSmittet.get(subsekvens).hentAntForekomster() > 6){
                        dominante.put(subsekvens, subsekvensObj.hentAntForekomster());
                    }
                }
            }
            //Printer ut med en forEach
            dominante.forEach((key, value)->
            System.out.println(key + "," + value));

            sc.close();

        } catch (FileNotFoundException e){
            System.out.println(e);
        } 

    }
}