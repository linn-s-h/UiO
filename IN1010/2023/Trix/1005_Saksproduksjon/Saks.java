
class Kniv {}

class Saks {

    Kniv[] knivblader = new Kniv[2];

    public Saks(Kniv k1, Kniv k2){
        k1 = knivblader[0];
        k2 = knivblader[1];
    }
}

=======SAKS MONITOR======

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SaksMonitor {

    ArrayList<Saks> saksbeholder = new ArrayList<>();
    Lock laas = new ReentrantLock();

    public void settInnSaks(Saks s){
        laas.lock();
        try {
            saksbeholder.add(s);
        } finally {
            laas.unlock();
        }
    }
    public int hentAntSakser(){
        laas.lock();
        try {
            return saksbeholder.size();
        } finally {
            laas.unlock();
        }
    }
}