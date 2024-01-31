import java.util.concurrent.locks.*;

class MultiThreading{

    Condition ikkeNeste;
    Lock laas;

    MultiThreading(){ //konstruktør

        laas = new ReentrantLock();
        ikkeNeste = laas.newCondition();
        Monitor m = new Monitor(); //oppretter og sender inn monitor som argument

        //for loop oppretter 10 multiple concurring threads 
        for (int i = 0; i < 10; i++){
            //new Thread(new MinRun(i, 1000, i, m)).start();
            MinRun nyRun = new MinRun(i, 1000, i, m); //i er threadNummer
            Thread nyThread = new Thread(nyRun);
            nyThread.start(); 
        }
    }
    public static void main(String[] args){
        new MultiThreading();

        /* 
         990 from thread 0
        991 from thread 1
        992 from thread 2
        993 from thread 3
        994 from thread 4
        995 from thread 5
        996 from thread 6
        997 from thread 7
        998 from thread 8
        999 from thread 9
        1000 from thread 0
        */
    }

    class Monitor{

        int tall = -1;
        
        public void skrivUt(int i, int id){
            laas.lock();
            try {
                while (i - 1 != tall){
                    ikkeNeste.await(); //sparker ut tråd, for den må vente
                }
                tall = i; //tråd gir fra seg et tall som er neste i rekka
                System.out.println(tall + " from thread " + id);
                ikkeNeste.signalAll(); //trådene som ble sparka ut kan prøve igjen

            } catch (InterruptedException e){
                System.out.println("Error.");
            } finally {
                laas.unlock();
            }
        }
    }
}