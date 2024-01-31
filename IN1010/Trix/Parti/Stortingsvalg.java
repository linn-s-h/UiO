

import java.util.concurrent.CountDownLatch;

//Main klassen!!!

class Stortingsvalg {
    
    public static final int ANTALL_URNER = 4;
    public static final int ANTALL_STEMMER_PER_URNE = 10;

    public static final int ANTALL_STEMMETELLERE = 5; //konstanter skrives med store bokstaver
    public static final int ANTALL_STEMMER_PER_TELLER = ANTALL_URNER * ANTALL_STEMMER_PER_URNE / ANTALL_STEMMETELLERE;
    public static void main (String[] args) throws InterruptedException{

        Stemmesystem stemmesystem = new Stemmesystem();
        MonitorStemmesystem monitor = new MonitorStemmesystem(stemmesystem);

        System.out.println("Stortingsvalget er i gang");

        //beholder med tråder
        Thread[] stemmetellere = new Thread[ANTALL_STEMMETELLERE];

        for (int i = 0; i < ANTALL_STEMMETELLERE; i++){
            stemmetellere[i] = new Thread(new Stemmeteller(i, ANTALL_STEMMER_PER_TELLER, monitor)); //sender inn runnable objekt
            stemmetellere[i].start(); //evaluerer til et Thread-objekt, kaller på run() metoden
        }

        CountDownLatch antallUrner = new CountDownLatch(ANTALL_URNER);
    
        Thread blindern = new Thread(new Valglokale(monitor, "Blindern", antallUrner, ANTALL_STEMMER_PER_URNE));
        Thread nydalen = new Thread(new Valglokale(monitor, "BI", antallUrner, ANTALL_STEMMER_PER_URNE));

        blindern.start();
        nydalen.start();

        for (Thread stemmeteller : stemmetellere){
            stemmeteller.join(); //barriere //tråden må kjøre ferdig før hovedprogram kan fortsette
        }
        System.out.println("\nStortingsvalget er over!");
    }
}