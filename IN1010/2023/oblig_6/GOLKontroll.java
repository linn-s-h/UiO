

//Kommunikasjon mellom utsynet og modellen
//Denne klassen har implmentasjoner for å bla. kunne interagere med metoder i modell klassen 
class GOLKontroll implements Runnable{

    private GOLView view;
    private GOLModell modell;
    int antRader;
    int antKolonner;
    boolean kjoer; //booelan for Run-metoden

    public GOLKontroll(int rad, int kol){
        antRader = rad;
        antKolonner = kol;
    }

    public void startProgram(){
        view = new GOLView(antRader, antKolonner, this);
        modell = new GOLModell(antRader, antKolonner);
    }
    //setter alle celler i view til død (selv om de egt er døde ved oppretting av celle...)
    public void lagRutenett(){
        Celle[][] rutenett = modell.hentAlleCeller();
        for (int r = 0; r < rutenett.length; r++){
            for (int k = 0; k < rutenett[r].length; k++){
                view.oppdaterView(r,k,false);
            }
        }
    }

    //Metode som blir kalt på når en celle-JButton blir trykket på og endrer statusen
    //En celle-JButton skal representere en celle
    public boolean oppdaterCelle(int r, int k){
        Celle celle = modell.hentCelle(r,k);
        if(!modell.hentCelleStatus(celle)){
            modell.settLevende(celle);
            return true;
        }
        modell.settDoed(celle);
        return false;
    }
    //Metode som oppdaterer ant levende celler og sender det inn tekstområde i View
    public void endreAntLevendeCeller(){
        view.oppdaterAntLevendeCeller(modell.antallLevende());
    }
    //Metode som oppdaterer rutenettet i View
    public void oppdaterView(Celle[][] celler){
        boolean status;
        for (int r = 0; r < celler.length; r++){
            for (int k = 0; k < celler[r].length; k++){
                if (modell.hentStatus(r,k)){
                    status = true;
                } else {
                    status = false;
                }
                view.oppdaterView(r,k,status);
            }

        }
    }
    public void start(){
        kjoer = true;
        new Thread(this).start();
    }
    public void avslutt(){
        kjoer = false;
        System.exit(0);
    }

    @Override
    public void run(){
        while(kjoer){
            try {

                Celle[][] celler = modell.hentAlleCeller();
                oppdaterView(celler);
                modell.oppdaterVerden();
                endreAntLevendeCeller();
                Thread.sleep(2000);

            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
