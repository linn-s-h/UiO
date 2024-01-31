
class KnivProdusent implements Runnable {

    private KnivMonitor monitor;
    private int lagAntKniver;

    public KnivProdusent(KnivMonitor m, int lagAntKniver){
        monitor = m;
        this.lagAntKniver = lagAntKniver;
    }
    public void run(){
        
        for (int i = 0; i < lagAntKniver; i++){
           Kniv k = new Kniv();
           monitor.leggTilKniv(k);
        }
    }
}