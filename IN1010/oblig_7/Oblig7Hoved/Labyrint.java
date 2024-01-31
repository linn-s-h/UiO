

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Labyrint{

    int rader;
    int kolonner;
    Rute[][] labyrint;

    //Konstruktør 
    public Labyrint(String filnavn){

        try{

            Scanner sc = new Scanner(new File(filnavn));
            int linjeTeller = 0;
            int radTeller = 0;
            
            //LesFraFil
            while (sc.hasNextLine()){
                if (linjeTeller < 1){
                    String linje = sc.nextLine();
                    String[] tegn = linje.strip().split(" ");

                    //Setter verdien til ant rad og ant kolonner
                    rader = Integer.parseInt(tegn[0]);;
                    kolonner = Integer.parseInt(tegn[1]);
                    labyrint = new Rute[rader][kolonner]; //Opretter to-dimensjonal array med gitt rad og kol

                    linjeTeller++;
                }
                //Fyller to-dimensjonal array med SortRute eller HvitRute
                String linje = sc.nextLine();
                String[] tegn = linje.strip().split("");
                for (int i = 0; i < tegn.length; i++){

                    if (tegn[i].equals("#")){
                        labyrint[radTeller][i] = new SortRute(radTeller, i, this);
                    } else if (tegn[i].equals(".")) {
                        labyrint[radTeller][i] = new HvitRute(radTeller, i, this);
                    } else {
                        sc.close();
                        throw new IllegalArgumentException("Ugyldig tegn: " + tegn);
                    }
                }
                radTeller++;

            }
            //Setter naboer til alle ruter i labyrinter
            kobleRuter();

        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.exit(0); //Programmet termineres
        }
    }

    //Metode som finner og skriver ut åpninger i labyrinten
    public String finnAapninger(){

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        
        //Sjekker kant til nord: (0,0) (0,1) (0,2) (0,3) ...
        for (int k = 0; k < kolonner; k++){
            if (labyrint[0][k] instanceof HvitRute && hentRute(0,k).nord == null){
                labyrint[0][k] = new Aapning(0,k,this);
                sb.append("(" + 0 + "," + k + ")");
                sb.append("\n");
            }
        }
        //Sjekker kant til syd: (3,0) (3,1) (3,2) (3,3) ...
        for (int k = 0; k < kolonner; k++){
            if (labyrint[rader-1][k] instanceof HvitRute && hentRute(rader-1,k).syd == null){
                labyrint[rader-1][k] = new Aapning(rader-1,k,this);
                sb.append("(" + (rader-1) + "," + k + ")");
                sb.append("\n");
            }
        }
        //Sjekker kant til vest: (0,0) (1,0) (2,0) (3,0) ...
        for (int r = 0; r < rader; r++){
            if (labyrint[r][0] instanceof HvitRute && hentRute(r,0).vest == null){
                labyrint[r][0] = new Aapning(r,0,this);
                sb.append("(" + r + "," + 0 + ")");
                sb.append("\n");
            }
        }
        //Sjekker kant til oest (0,3) (1,3) (2,3) (3,3) ...
        for (int r = 0; r < rader; r++){
            if (labyrint[r][kolonner-1] instanceof HvitRute && hentRute(r,kolonner-1).oest == null){
                labyrint[r][kolonner-1] = new Aapning(r,kolonner-1,this);
                sb.append("(" + r + "," + (kolonner-1) + ")");
                sb.append("\n");
            }
        } 
        return sb.toString();
    }

    public Rute hentRute(int r, int k){

        boolean gyldig = false;
        if (r < rader && r > -1){
            if (k < kolonner && k > -1){
                gyldig = true;
            }
        }
        if (!gyldig){
            return null;
        }
        return labyrint[r][k];
    }

    public void settNaboer(int r, int k){
        Rute rute = hentRute(r, k);
        rute.leggTilNabo(hentRute(r-1, k)); //Nord
        rute.leggTilNabo(hentRute(r+1, k)); //Syd
        rute.leggTilNabo(hentRute(r, k-1)); //Vest
        rute.leggTilNabo(hentRute(r, k+1)); //Oest
        //Naborute kan være null
    }

    public void kobleRuter(){
        for (int r = 0; r < labyrint.length; r++){
            for (int k = 0; k < labyrint[r].length; k++){
                settNaboer(r,k);
            }
        }
    }
    public void finnVeiUtFra(int rad, int kol){
        if (!(labyrint[rad][kol] instanceof SortRute)){
            labyrint[rad][kol].finn(null);
            System.out.println(finnAapninger());
        } else {
            System.out.println("Kan ikke starte fra sort rute\n");
        }
    }

    public int hentAntRader(){
        return rader;
    }
    public int hentAntKolonner(){
        return kolonner;
    }
   
    //toString som skriver ut labyrinter med ruter i terminalen og åpningene med koordinater
    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("\n\n");
        sb.append("Rader: " + Integer.toString(rader) + "  " + "Kolonner: " + Integer.toString(kolonner));
        sb.append("\n\n\n");
        
        for (int i = 0; i < labyrint.length; i++){
            for (int j = 0; j < labyrint[i].length; j++){
                sb.append(labyrint[i][j]);
                sb.append(" "); 
            }
            sb.append("\n\n");
        }

        //Finner aapninger når labyrint blir printet ut i Main
        String aapninger = finnAapninger(); 
        sb.append(aapninger);

        return sb.toString(); //Kaller på toString til rutene
    }
}