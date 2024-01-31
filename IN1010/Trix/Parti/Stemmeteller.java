

class Stemmeteller implements Runnable {

    private MonitorStemmesystem monitor; //dele på tvers av trådene for å dele ressursene

    private int id;
    private int antStemmer;

    public Stemmeteller(int id, int antStemmer, MonitorStemmesystem m){ 
        monitor = m;
        this.id = id;
        this.antStemmer = antStemmer;
    }
    @Override
    public void run(){
        try {
            for (int i = 0; i < antStemmer; i++){
                Parti stemme = monitor.taUtStemme();
                System.out.println("Stemmeteller: " + id + "talte en stemme til " + stemme);
            }
        } catch (InterruptedException e ){
            System.out.println(e + ". Stemme tellingen er avbrutt");
        }
    }
}