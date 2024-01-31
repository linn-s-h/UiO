import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Oblig5Hele {
    public static void main(String[] args){
        Monitor2 friskMonitor = new Monitor2();
        Monitor2 sykMonitor = new Monitor2();

        ArrayList<String> friskeFiler = new ArrayList<String>();
        ArrayList<String> sykeFiler = new ArrayList<String>();
        String filbane = args[0];

        try{
            File fil = new File(filbane + "metadata.csv");
            Scanner leser = new Scanner(fil);
            while (leser.hasNextLine()){
                String linje = leser.nextLine();
                String[] deltLinje = linje.strip().split(",");
                if (deltLinje[1].equals("True")){ //mulig at \n skaper krøll
                    sykeFiler.add(deltLinje[0]);
                } else {
                    friskeFiler.add(deltLinje[0]);
                } 
            }
        } catch(FileNotFoundException e){
            System.out.println("gikk galt med fillesning");
        }
        // syke fillesning

        ArrayList<Thread> sykLesetradListe = new ArrayList<Thread>();
        for (String navn : sykeFiler){
            Thread trad = new Thread(new LeseTrad(filbane + navn, sykMonitor));
            sykLesetradListe.add(trad);
            trad.start();
        }

        // frisk fillesning

        ArrayList<Thread> friskLesetradListe = new ArrayList<Thread>();
        for (String navn : friskeFiler){
            Thread trad = new Thread(new LeseTrad(filbane + navn, friskMonitor));
            friskLesetradListe.add(trad);
            trad.start();
        }

        // venter på lesere 
        for (Thread trad : sykLesetradListe){
            try{
                trad.join();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        for (Thread trad : friskLesetradListe){
            try{
                trad.join();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        sykMonitor.lestFerdig();
        friskMonitor.lestFerdig();

        ArrayList<Thread> sykFlettetradListe = new ArrayList<Thread>();
        ArrayList<Thread> friskFlettetradListe = new ArrayList<Thread>();

        for (int i = 0; i < 8; i++){
            Thread syktraad = new Thread(new FletteTrad(sykMonitor));
            Thread frisktraad = new Thread(new FletteTrad(friskMonitor));

            sykFlettetradListe.add(syktraad);
            friskFlettetradListe.add(frisktraad);

            syktraad.start();
            frisktraad.start();
        }

        //venter på flettere

        for (Thread trad : sykFlettetradListe){
            try{
                trad.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        for (Thread trad : friskFlettetradListe){
            try{
                trad.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        HashMap<String,Subsekvens> flettetSyk = sykMonitor.hentListe().get(0);
        HashMap<String,Subsekvens> flettetFrisk = friskMonitor.hentListe().get(0);
        for(String key : flettetSyk.keySet()){
            Subsekvens sekvens = flettetFrisk.get(key);
            if (sekvens == null){
                if (flettetSyk.get(key).hentAntall() >= 7){
                    System.out.println(flettetSyk.get(key));
                }
            }else if (sekvens.hentAntall() <= flettetSyk.get(key).hentAntall() - 7){
                System.out.println(flettetSyk.get(key));
            }
        }
    }
}


