
class SaksProdusent implements Runnable {

    private KnivMonitor knivMonitor;
    private SaksMonitor saksMonitor;

    public SaksProdusent(KnivMonitor km, SaksMonitor sm){
        knivMonitor = km;
        saksMonitor = sm;
    }
    public void run(){
        while (knivMonitor.hentAntKniver() > 1){
            Kniv[] kniver = knivMonitor.taUtToKniver();
            Saks nySaks = new Saks(kniver[0], kniver[1]);
            saksMonitor.settInnSaks(nySaks);
        }
    }
}