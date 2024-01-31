
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