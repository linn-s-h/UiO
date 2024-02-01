import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Iterator;
import java.lang.Iterable;
import java.io.FileWriter;

class Legesystem {

    private static Koe<Pasient> pasienter = new Koe<Pasient>();
    private static Koe<Legemiddel> legemiddler = new Koe<Legemiddel>();
    private static Prioritetskoe<Lege> leger = new Prioritetskoe<Lege>();
    private static Koe<Resept>  resepter = new Koe<Resept>();
    
    //main metode
    public static void main(String[] args){
        lesFraFil("stor_innlesingsfil.txt");
        lesFraFil("liten_innlesingsfil.txt");
        //vi klarte begge :)))))
        kommandolokke();
        
    }
    
    public static void lesFraFil(String filnavn){

        // ************************************************
        // LES FIL START **********************************
        // ************************************************

        Scanner sc = null;
        File fil = null;
        int teller = 0;
        

        try {
            fil = new File(filnavn);
            sc = new Scanner(fil);  
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }


        while (sc.hasNextLine()){

                String linje = sc.nextLine();
                String[] arrLinje = linje.split(",");

                if (linje.charAt(0) == '#') {
                    teller++;
                }
                
                // linje er ikke "#". Altså, les inn fil. 
                else{
            
                    /*      
                    if pasient, 
                    opprett nytt pasient objekt. 
                    Legg til liste pasienter.
                    */  

                    try{
                        if (teller == 1) {
                            Pasient pas = new Pasient(arrLinje[0], arrLinje[1]);
                            pasienter.leggTil(pas);
                        }
                    }
                    catch (Exception e){
                        System.out.println("Klarte ikke aa opprette pasient.");
                        System.out.println(e);
                    }
                    


                    // if legemiddel
                    try{
                        if (teller == 2) {

                            String navn = arrLinje[0];
                            String type = arrLinje[1];
                            int pris = (int)Double.parseDouble(arrLinje[2]);
                            double virkestoff = Double.parseDouble(arrLinje[3]);

                            if (type.equals("narkotisk")) {
                                int styrke = Integer.parseInt(arrLinje[4].replaceAll(" ", ""));
                                Narkotisk nark = new Narkotisk(navn, pris, virkestoff, styrke);
                                legemiddler.leggTil(nark);
                            } 
                            
                            else if (type.equals("vanedannende")) {
                                int styrke = Integer.parseInt(arrLinje[4].replaceAll(" ", ""));
                                Vanedannende vane = new Vanedannende(navn, pris, virkestoff, styrke);
                                legemiddler.leggTil(vane);
                            } 
                            
                            else if (type.equals("vanlig")) {
                                Vanlig vanlig = new Vanlig(navn, pris, virkestoff);
                                legemiddler.leggTil(vanlig);
                            }
                        }
                    }
                    catch (Exception e){
                        System.out.println("Klarte ikke aa opprette legemiddel");
                        System.out.println(e);

                        for (String l : arrLinje){
                            System.out.print(l);
                            System.out.print(", ");
                        }
                        System.out.println("");
                    }

                    // if leger
                    
                    try{                 
                        if (teller == 3) {

                            String navn = arrLinje[0];
                            String kontrollkode = arrLinje[1];

                            if (kontrollkode.equals("0")) {
                                Lege lege = new Lege(navn);
                                leger.leggTil(lege);
                            } else {
                                Spesialist spesialist = new Spesialist(navn, kontrollkode);
                                leger.leggTil(spesialist);
                            }
                        }
                    }
                    catch (Exception e){
                        System.out.println("Klarte ikke aa opprette lege");
                        System.out.println(e);
                    }

                        // if resepter
                    try {
                        if (teller == 4) {

                            int legemiddelNummer = Integer.parseInt(arrLinje[0]); // aka legemiddel id.
                            String legeNavn = arrLinje[1]; // Dr evanger
                            int pasientId = Integer.parseInt(arrLinje[2]);
                            String type = arrLinje[3];
                            int reit = 0;


                            // Finne Legemiddel objekt
                            Legemiddel legemiddel = null;
                            for (Legemiddel itLegemiddel : legemiddler){
                                if (legemiddelNummer == itLegemiddel.hentId()){
                                    legemiddel = itLegemiddel;
                                } 
                            }

                            // Finne Lege objekt
                            Lege lege = null;
                            for (Lege itLege : leger){
                                if (legeNavn.equals(itLege.hentNavn())){
                                    lege = itLege;
                                }
                            }

                            // Finne Pasient objekt 
                            Pasient pasient = null;
                            for (Pasient itPas : pasienter){
                                if (pasientId == itPas.hentPasientId()){
                                    pasient = itPas;
                                }
                            }

                            // skrive Resepter. 
                            // 1. sjekk for typer
                            // 2. kall på tilhørende skrivResept til tilhørende lege med passende parametere.  
                            if (type.equals("militaer")) {
                                try {
                                    MilResept resept = lege.skrivMilResept(legemiddel, pasient);
                                    resepter.leggTil(resept);
                                }
                                catch (UlovligUtskrift e){
                                    System.out.println("Legen " + lege + " har ikke lov å skrive dette reseptet: ");
                                    System.out.println("MilResept: " + legemiddel + ", " + pasient);
                                }
                            }

                            else {
                                reit = Integer.parseInt(arrLinje[4]);
                            }

                            if (type.equals("hvit")) {
                                try{
                                    HvitResept resept = lege.skrivHvitResept(legemiddel, pasient, reit);
                                    resepter.leggTil(resept);
                                }
                                catch (UlovligUtskrift e){
                                    System.out.println("Legen " + lege + " har ikke lov å skrive dette reseptet: ");
                                    System.out.println("Hvit: " + legemiddel + ", " + pasient);
                                }
                            } 
                            else if (type.equals("blaa")) {
                                try{
                                    BlaaResept resept = lege.skrivBlaaResept(legemiddel, pasient, reit);
                                    resepter.leggTil(resept);
                                }
                                catch (UlovligUtskrift e){
                                    System.out.println("Legen " + lege + " har ikke lov å skrive dette reseptet: ");
                                    System.out.println("Blaa: " + legemiddel + ", " + pasient);
                                }

                            } 
                            else if (type.equals("p")) {
                                try{
                                    Presept resept = lege.skrivPResept(legemiddel, pasient, reit);
                                    resepter.leggTil(resept);
                                }
                                catch (UlovligUtskrift e){
                                    System.out.println("Legen " + lege + " har ikke lov å skrive dette reseptet: ");
                                    System.out.println("p: " + legemiddel + ", " + pasient);
                                }
                            }
                        }
                    }
                    catch (Exception e){
                        System.out.println("Klarte ikke aa opprette resept.");
                        System.out.println(e);
                    }
                }
            }
            
        // ************************************************
        // LES FIL SLUTT **********************************
        // ************************************************
    }

        //MENY
        public static void meny(){

                clearTerminal();
                System.out.println("");
                System.out.println("");
                System.out.println("****** MENY ******");
                System.out.println("");
                System.out.println("1. Opprett og legg til nye elementer i systemet");
                System.out.println("2. Bruk en gitt resept fra listen til pasient");
                System.out.println("3. Gi fullstendig oversikt over systemets innhold");
                System.out.println("4. Skriv ut forskjellig former for statistikk");
                System.out.println("5. Skriv all data til fil");
                System.out.println("0. Avslutt");
                System.out.println("");
                System.out.println("");
            }

        public static void kommandolokke(){

            Scanner input = new Scanner(System.in);
            int inputFraBruker = 69420; // le funny

            while (inputFraBruker != 0){

                meny();
                try{
                    inputFraBruker = Integer.parseInt(brukerInput());
                }catch(Exception e){}


                // Oprett og legg til nye elementer i systemet.
                if (inputFraBruker == 1){ 
                    //metode
                    opprettNyeElementer();

                } 
                
                // Bruke en gitt resept av pasient.
                else if (inputFraBruker == 2){
                    brukResept();
                } 

                else if (inputFraBruker == 3){
                    skrivOversikt();
                    
                } 
                
                else if (inputFraBruker == 4){
                    /*
                    skriver ut forskjellige former for statistikk
                     */
                    skrivStatistikk();
                }

                else if (inputFraBruker == 5){
                    skrivTilFil();
                }
                }
            }

        public static void opprettNyeElementer(){
            
            clearTerminal();
            boolean ferdig = false;

            while (!ferdig){

                System.out.println("");
                System.out.println("****** Hvilket element vil du oprette? ******");
                System.out.println("1. Ny pasient ");
                System.out.println("2. Ny lege ");
                System.out.println("3. Ny legemiddel ");
                System.out.println("4. Skriv ny resept");
                System.out.println("");
                System.out.println("0. <<Tilbake til hovedmeny");

                /*
                Spoer om input til den er gyldig
                 */
                boolean tilGyldig1 = true;
                int brukerInput = 0;
                while(tilGyldig1){
                    try{
                        brukerInput = Integer.parseInt(brukerInput());
                        tilGyldig1 = false;
                    }catch(Exception e){
                        System.out.println("Du skrev ikke inn et tall, fra menyen, prøv igjen!");
                    }
                }


                if (brukerInput == 0){
                    ferdig = true;
                    return;
                }

                // if opprett ny pasient
                if (brukerInput == 1){

                    System.out.println("Oppretter ny pasient...");
                    System.out.println("Hva heter pasienten?");
                    String navn = brukerInput();

                    System.out.println("Hva er fodselsnummeret til pasienten?");
                    String fodselnummer = brukerInput();

                    Pasient nyPas = new Pasient(navn, fodselnummer);
                    pasienter.leggTil(nyPas);

                    System.out.println("");
                    System.out.println("Ny pasient opprettet!");
                    System.out.println(nyPas);
                    System.out.println("");

                }

                // if opprett ny lege
                if (brukerInput == 2){

                    System.out.println("Oppretter ny lege...");
                    System.out.println("Hva heter legen?");
                    String navn = brukerInput();

                    System.out.println("Hva er kontroll koden til legen?");
                    System.out.println("(0 om legen ikke har kontrollkode)");
                    String kontrollkode = brukerInput();

                    if (kontrollkode.equals("0")){
                        Lege nyLege = new Lege(navn);
                        System.out.println("Ny lege opprettet: " + nyLege);
                        leger.leggTil(nyLege);
                    }
                    else{
                        Spesialist nyLege = new Spesialist(navn, kontrollkode);
                        System.out.println("Ny lege opprettet: " + nyLege);
                        leger.leggTil(nyLege);
                    }


                }

                // if opprett ny legemiddel
                if (brukerInput == 3){

                    int styrke = 0;

                    System.out.println("Oppretter nytt legemiddel...");
                    System.out.println("Hva heter legemiddelet?");
                    String navn = brukerInput();

                    System.out.println("Hvilken type er legemiddelet?");
                    System.out.println("1. Vanlig");
                    System.out.println("2. Narkotisk");
                    System.out.println("3. Vanedannende");

                    String type = brukerInput();

                    // hent styrke. Sjekker om type er vanlig. Om vanlig -> ikke be bruker om å oppgi styrke. 
                    if (!type.equals("1")){
                        System.out.println("Hva er styrken til legemiddelet?");
                        styrke = Integer.parseInt(brukerInput());
                    }

                    // PRIS!
                    System.out.println("Hva er prisen til legemiddelet?");
                    int pris = Integer.parseInt(brukerInput());

                    // VIRKESTOFF (DOUBLE, skriver med .)
                    System.out.println("Hva er virkestoffet til legemiddelet? (0.0-1.0)");
                    double virkestoff = Double.parseDouble(brukerInput());


                    // Opprett legemiddel med tilsvarende type. 
                    if (type.equals("1")){
                        Vanlig leg = new Vanlig(navn, pris, virkestoff);
                        legemiddler.leggTil(leg);
                        System.out.println("Nytt legemiddel opprettet: " + leg);
                    }
                    else if (type.equals("2")){
                        Narkotisk leg = new Narkotisk(navn, pris, virkestoff, styrke);
                        legemiddler.leggTil(leg);
                        System.out.println("Nytt legemiddel opprettet: " + leg);
                    }
                    else if (type.equals("3")){
                        Vanedannende leg = new Vanedannende(navn, pris, virkestoff, styrke);
                        legemiddler.leggTil(leg);
                        System.out.println("Nytt legemiddel opprettet: " + leg);
                    }
                    else {
                        System.out.println("Ugyldig.");
                    }
                }

                // if opprett ny resept // skriv ny resept. 
                if (brukerInput == 4){

                    int index = 1;
                    int valgt_index = 0;

                    System.out.println("");
                    System.out.println("Velg en lege som skal skrive resept");

                    //  skrive ut alle leger med tilhørende index.
                    for (Lege lege : leger){
                        System.out.println(index + ". " + lege);
                        index++;
                    }

                   // hent brukerinput (som integer)
                    valgt_index = Integer.parseInt(brukerInput());

                    // finne lege som bruker leter etter. 
                    index = 1;
                    Lege lege = null;
                    for (Lege itLege : leger){
                        if (index == valgt_index){
                            lege = itLege;
                        }
                        index++;
                    }

                    // Finne legemiddel basert paa eksisterende legemiddler. 
                    index = 1;
                    System.out.println("Velg et legemiddel:");
                    for (Legemiddel lm : legemiddler){
                        System.out.println(index + ". " + lm);
                        index++;
                    }

                    valgt_index = Integer.parseInt(brukerInput());
                    index = 1;
                    Legemiddel legemiddel = null;
                    for (Legemiddel lm : legemiddler){
                        if (valgt_index == index){
                            legemiddel = lm;
                        }
                        index++;
                    }


                    // La bruker velge pasient objekt....
                    index = 1;

                    for (Pasient itPas : pasienter){
                        System.out.println(index + ". " + itPas);
                        index++;
                    }

                    valgt_index = Integer.parseInt(brukerInput());
                    index = 1;
                    Pasient pasient = null;
                    for (Pasient itPas : pasienter){
                        if (index == valgt_index){
                            pasient = itPas;
                        }
                        index++;
                    }


                    // la bruker velge type resept:

                    System.out.println("");
                    System.out.println("Velg en type resept som skal skrives ut: ");
                    System.out.println("1. P resept");
                    System.out.println("2. Hvit resept");
                    System.out.println("3. Blaa resept");
                    System.out.println("4. Militaer resept");
                    System.out.println("");

                    /*
                    Ber bruker om aa skrive inn input til det er gyldig
                     */
                    boolean tilGyldig2 = true;
                    while(tilGyldig2){
                        try{
                            valgt_index = Integer.parseInt(brukerInput());
                            tilGyldig2 = false;
                        }catch(NumberFormatException e){
                            System.out.println("Du skrev ikke inn et tall, fra menyen, prøv igjen!");
                        }
                    }

                    int reit = 0;

                    // sjekk om militaer og ddermed ikke trenger reit
                    // bruker try/catch på alle skriv resept pga den thrower UlovligUtskrift.
                    if (valgt_index == 4){
                        try {
                            lege.skrivMilResept(legemiddel, pasient);
                        }
                        catch (UlovligUtskrift e){
                            System.out.println("Legen du valgte er ikke spesialist!");
                        }
                    }

                    // Ikke milresept, dermed kan vi be om REIT!
                    System.out.println("Hvor mange reit skal du ha? (Antall bruk)");
                    reit = Integer.parseInt(brukerInput());
                    Resept r;

                    // if Blaa respet
                    if (valgt_index == 3){
                        try {
                            r = lege.skrivBlaaResept(legemiddel, pasient, reit);
                            resepter.leggTil(r);
                        }
                        catch (UlovligUtskrift e){
                            System.out.println("Legen du valgte er ikke spesialist!");
                        }
                    }

                    // if Hvit respet
                    if (valgt_index == 2){
                        try {
                            r = lege.skrivHvitResept(legemiddel, pasient, reit);
                            resepter.leggTil(r);
                        }
                        catch (UlovligUtskrift e){
                            System.out.println("Legen du valgte er ikke spesialist!");
                        }
                    }

                    // if p_resept respet
                    if (valgt_index == 1){
                        try {
                            r = lege.skrivPResept(legemiddel, pasient, reit);
                            resepter.leggTil(r);
                        }
                        catch (UlovligUtskrift e){
                            System.out.println("Legen du valgte er ikke spesialist!");
                        }
                    }
                }

                // Avsluttnings setning, vil du legge til noe nytt?
                System.out.println("_________________________________________________________");
                System.out.println("");
                System.out.println("1. Legg til noe annet");
                System.out.println("0. Gaa tilbake til hovedmeny");

                // avslutt løkka. Om ikke looper while løkka om igjen.
                /*
                Spoer om input til den er gyldig
                 */

                //brukerInput = Integer.parseInt(brukerInput());
                

                brukerInput = 0;
                boolean tilGyldig3 = true;
                while(tilGyldig3){
                    try{
                        brukerInput = Integer.parseInt(brukerInput());
                        tilGyldig3 = false;
                    }catch(Exception e){
                        System.out.println("Du skrev ikke inn et tall, fra menyen, prøv igjen!");
                    }
                }


                if (brukerInput != 1){
                    ferdig = true;
                }
            }
        }

        public static void brukResept(){
            //HER SKAL DEN BRUKE RESEPT
            clearTerminal();
            boolean ferdig = false;
            int tallListe = 1;
            int inp = 0;
            int reitinp = 0;
            int inp2 = 0;
            
            while(!ferdig){
                if(pasienter == null){ //skal sjekke om pasient lista er tom
                    System.out.println("Ikke noe pasienter registrert i lista!");
                    ferdig = true;
                }
                
                System.out.println("---Hvilke pasient vil du se resepter for?---");
                System.out.println("Tast 0 for å gå tilbake til hovedmeny");
                for(Pasient pas: pasienter){
                    if (pas.hentPasientResepter().stoerrelse() > 0){
                        System.out.println("Pasientnr: " + tallListe + "." + pas.toString() + " (" + (pas.hentPasientResepter().stoerrelse()) + " respter) ");
                        tallListe++;
                    }
                }
                

                inp = Integer.parseInt(brukerInput()); //henter inn forste input der hvor de faar velge pasient

                // la bruker avslutte.
                if (inp == 0){  //for hvis brukeren vil allerede gaa tilbake til hovedmeny
                    ferdig = true;
                    meny();
                    return;
                }


                // finne pasient. 
                int teller = 1;
                Pasient valgtPasient = null; // pasienten som brukeren velger
                for(Pasient pas : pasienter){ //henter ut pasienten som brukeren velger
                    if (pas.hentPasientResepter().stoerrelse() > 0){
                        if (inp == teller){
                            valgtPasient = pas;
                        }
                        teller++;
                    }
                    
                }


                // printe ut pasienters resept.
                System.out.println("Valgt pasient: " + valgtPasient);
                System.out.println("Hvilke Resept vil du bruke?");
                System.out.println("");                
                
                teller = 1;
                Koe<Resept> pasRespter = valgtPasient.hentPasientResepter();
                for (Resept r : pasRespter){

                    String navn = r.hentPasient().hentNavn();
                    String lm = r.hentLegemiddel().hentNavn();
                    String lege = r.hentLege().hentNavn();
                    int reit = r.hentReit();

                    System.out.println(teller + ". " + navn + ", " + lm + ", Skrevet ut av: " + lege + " (" + reit + " reit igjen)." );
                    teller++;

                }


                // bruke reit fra valgt resept
                if(inp <= tallListe || inp >= 0){ //sjekker om det er et lovlig input
                        
                    reitinp = Integer.parseInt(brukerInput())-1; //ny input naar brukeren velger resept
                    teller = 0;
                    
                    Resept valgtResept = null; //velgResept variabel som skal brukes for aa hente ut valgte resepten
                    inp2 = 69420; //huehuehue
                    
                    //henter ut den valgte resepten
                    for(Resept resept: valgtPasient.resepter){
                        if(teller == reitinp){
                            valgtResept = resept;
                            break;
                        }
                    teller++;
                    }

                    if (valgtResept == null) {
                     System.out.println("");
                     System.out.println("ADVARSEL! Vennlig velg reseptene som kun vises frem!");
                     System.out.println("");
                    }
                        
                    Legemiddel valgtLegemiddel = valgtResept.hentLegemiddel(); //omgjor valgteResepten til valgt legemiddel
                    
                    if(valgtResept.bruk()){  //henter brukReit metoden for å sjekke om det nok reit i legemiddelen
                     System.out.println("Brukte resept paa " +valgtLegemiddel.hentNavn()+   ". Antall gjenvaerende reit: " + valgtResept.hentReit());
                     System.out.println("");
                     System.out.println("Tast 0 for aa gaa tilbake til hovedmeny"); 
                     inp2 = 69420;        
                         }
                        
                    else{ //hvis ikke det er reit gjenstaende
                     System.out.println("Kunne ikke bruke resept paa: " + valgtLegemiddel.hentNavn() + ". Fordi reit er tom");
                     System.out.println("");
                     System.out.println("Tast 0 for aa gaa tilbake til hovedmeny");
                     inp2 = 69420;
                     }
    
                    inp2 = Integer.parseInt(brukerInput()); //gir brukeren ny input for aa gaa tilbake til meny
                    
                    if (inp2 == 0){ // avslutter brukResept() 
                     ferdig = true;
                    }  
                }
                else{
                    System.out.println("Feil har oppstatt");
                }
                
            }      
        }

        //todo
        public static void skrivStatistikk(){
            clearTerminal();
            boolean ferdig = false;
            int inp = 0;

            while(!ferdig){
                System.out.println("****** Innhold ******");
                System.out.println("1. Se totalt antall utskrevene resepter");
                System.out.println("2. Se totalt antall utskrevene vanedannende");
                System.out.println("3. Se totalt antall utskrevene narkotiske");
                System.out.println("4. Statistikk om mulig misbruk av narkotika");
                System.out.println("5. Pasienter med gyldig resept paa narkotisk");

                System.out.println("0. <<Tilbake til hovedmeny");
                boolean gyldig = true;
                while (gyldig){
                    try{
                        inp = Integer.parseInt(brukerInput());
                        gyldig = false;
                    }catch(Exception e){
                        System.out.println("Du skrev ikke inn et tall, fra menyen, prøv igjen!");
                    }
                }
                clearTerminal();

                int total = 0;
                int totalVanedannende = 0;
                int totalNarkotiske = 0;

                /*
                Printer ut totalt antall resepter
                 */
                if(inp == 1){
                    for(Pasient p : pasienter){
                        for(int i = 0; i < p.resepter.stoerrelse(); i++){
                            total++;
                        }
                    }
                    System.out.println("Totalt antall resepter: " + total);
                }

                if(inp == 2){
                    //gaa igjennom legemiddler og instanceof
                    for(Legemiddel l : legemiddler){
                        if(l instanceof Vanedannende){
                            totalVanedannende++;
                        }
                    }
                    System.out.println("Totalt antall vanedannende legemiddler: " + totalVanedannende);
                }

                if(inp == 3){
                    //totalt antall utskrvene narkotiske
                    for(Legemiddel l : legemiddler){
                        if(l instanceof Narkotisk){
                            totalNarkotiske++;
                        }
                    }
                    System.out.println("Totalt antall narkotiske legemiddler: " + totalNarkotiske);
                }

                if(inp == 4){
                    IndeksertListe<Lege> legerMedRisiko = new IndeksertListe<>();
                    for(Lege l : leger){
                        for(Resept r : l.utskrevneResepter){
                            if(r.hentLegemiddel() instanceof Narkotisk){
                                /*
                                Passer paa at vi ikke legger til den samme
                                legen flere ganger, siden vi kun er ute etter
                                minst "en" narkotisk utskrevet
                                 */
                                legerMedRisiko.leggTil(l);
                            }
                        }

                        //iterer over listen og fjerner duplikater
                        for(int i = 0; i < legerMedRisiko.stoerrelse() - 1; i++){
                            for(int j = i + 1; j < legerMedRisiko.stoerrelse(); j++){
                                if(legerMedRisiko.hent(i).equals(legerMedRisiko.hent(j))){
                                    legerMedRisiko.fjern(j);
                                    j--;
                                }
                            }
                        }


                    }
                    /*
                    skrive ut legen, og alle de risikable utskriftene
                     */

                    if (legerMedRisiko.stoerrelse() > 0){

                        System.out.println("=== LEGER MED RISIKO ===");

                        for(Lege riskLege : legerMedRisiko){
                            int teller = 0;
                            for(Resept resept : riskLege.utskrevneResepter){
                                if (resept.hentLegemiddel() instanceof Narkotisk){
                                    teller++;
                                }
                            }


                            System.out.println("Legen: " + riskLege.navn + " har skrevet ut: " + teller + " narkotiske legemiddler.");  
                            }
                    }
                    else {
                        System.out.println("Ingen leger med risiko!");
                    }
                }


                if (inp == 5){

                    int teller = 0;


                    System.out.println("=== RISIKO PASIENTER ===");
                    
                    for (Pasient pas : pasienter){
                        Koe<Resept> reseptPas = pas.hentPasientResepter();
                        for (Resept res : reseptPas){
                            if (res.hentLegemiddel() instanceof Narkotisk && res.hentReit() > 0){
                                teller++;
                            }
                        }
                        if (teller > 0){
                            System.out.println(pas.hentNavn() + " har " + teller + " gyldige narkotsike resepter");
                        }
                    }
                }




                if (inp == 0){
                    ferdig = true;
                    return;
                }

                System.out.println("_________________________________________________________");
                System.out.println("");
                System.out.println("1. Sjekk noe annet");
                System.out.println("0. Gaa tilbake til hovedmeny");

                // avslutt løkka. Om ikke looper while løkka om igjen.
                inp = Integer.parseInt(brukerInput());
                clearTerminal();
                if (inp != 1){
                    ferdig = true;
                }
            }

        }

    public static void skrivOversikt(){

            // meny type beeat
            clearTerminal();
            boolean ferdig = false;
            int inp = 0;

            while (!ferdig){

                System.out.println("");
                System.out.println("****** Innhold ******");
                System.out.println("1. Se alle leger ");
                System.out.println("2. Se alle pasienter");
                System.out.println("3. Se alle legemidler");
                System.out.println("4. Se alle skrevne resepter");
                System.out.println("");
                System.out.println("0. <<Tilbake til hovedmeny");

                boolean gyldig = true;
                while (gyldig){
                    try{
                        inp = Integer.parseInt(brukerInput());
                        gyldig = false;
                    }catch(Exception e){
                        System.out.println("Du skrev ikke inn et tall, fra menyen, prøv igjen!");
                    }
                }
                clearTerminal();

                // Skriv ut alle leger:
                if (inp == 1){
                    System.out.println("Her er alle legene i systemet:");

                    for (Lege lege : leger){
                        System.out.println(lege);
                    }   
                }

                // skriv ut alle pasienter
                if (inp == 2){
                    System.out.println("Her er alle pasientene i systemet:");

                    for (Pasient pas : pasienter){
                        System.out.println(pas);
                    }
                }

                // skriv ut alle legemidler
                if (inp == 3){
                    System.out.println("Her er alle legemidler i systemet:");

                    for (Legemiddel lm : legemiddler){
                        System.out.println(lm);
                    }
                }

                // skriv ut resepter. 
                // hent alle leger, hent reseptlisten deres.
                if (inp == 4){
                    System.out.println("Her er alle reseptene skrevet ut:");
                    System.out.println("_________________________________________________________");

                    for (Lege lege : leger){
                        System.out.println("");


                        if (lege.hentUtskrevneResepter().stoerrelse() > 0){  // kun kjoer om legen har skrevet ut resepter. 
                            System.out.println("Her er reseptene til " + lege + ":");
                            for (Resept r : lege.hentUtskrevneResepter()){


                                String lm = r.hentLegemiddel().hentNavn();
                                String l = r.hentLege().hentNavn();
                                int reit = r.hentReit();
                                String type = r.farge();

                                try{
                                    String navn = r.hentPasient().hentNavn();
                                    System.out.println(" - " + navn + ", " + lm + ", type: " + type +", Skrevet ut av: " + l + "(" + reit + " igjen).");
                                }
                                // I tilfelle der resept ikke har navn, oppstår noen steder? ;_;
                                catch (Exception e){
                                    System.out.println(" - ingen navn" + lm + ", type: " + type + ", Skrevet ut av: " + l + "(" + reit + " igjen).");
                                    
                                }
                                

                                
                            
                            }
                        }
                    }
                }
                // avslutt tidlig.
                if (inp == 0){
                    ferdig = true;
                    return;
                }

                System.out.println("_________________________________________________________");
                System.out.println("");
                System.out.println("1. Sjekk noe annet");
                System.out.println("0. Gaa tilbake til hovedmeny");

                // avslutt løkka. Om ikke looper while løkka om igjen. 
                inp = Integer.parseInt(brukerInput());
                clearTerminal();
                if (inp != 1){
                    ferdig = true;
                }
            }
        }

    public static void skrivTilFil(){

        String filnavn = "legesystem_data.txt";

        // opprette ny fil eller sjekke om den eksisterer;
        try { 
            
            File nyFil = new File(filnavn);

            if (nyFil.createNewFile()){
                System.out.println("Opprettet ny fil: " + filnavn);
            }
            else {
                System.out.println("Overskriver " + filnavn);
            }  
        } 
        catch (Exception e){
            System.out.println("Klarte ikke aa opprette en fil");
            System.out.println(e);
            System.out.println();
            System.out.println("Trykk ENTER for aa komme tilbake til hovedmenyen.");
            brukerInput();
        }



        // skrive til filen.
        Koe<Lenkeliste> megaListe = listeAvLister(); // samler alle lister i en koe. Til iterering under.
        String[] rekkefolge = {"Pasienter (navn, fnr, id)", "Legemidler (navn,type,pris,virkestoff,[styrke])", "Leger (navn,kontrollid / 0 hvis vanlig lege)", "Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])"};
        
        int indexListe = 0;
        int indexObjek = 0;

        try {

            FileWriter filAapnet = new FileWriter(filnavn);
            

            for (Lenkeliste liste : megaListe){
                filAapnet.write("# " + rekkefolge[indexListe] + "\n");
                for (Object type : liste){
                    filAapnet.write(type + "\n");
                    indexObjek++;
                }
                indexListe++;
                
            }
            filAapnet.close();

            clearTerminal();
            System.out.println("Suksess!");
            System.out.println("Skrev " + indexObjek + " linjer til " + filnavn + ".");

            System.out.println("Trykk ENTER for aa komme tilbake til hovedmenyen.");
            brukerInput();

        }
        catch (Exception e){
            System.out.println(e);
            System.out.println();
            System.out.println("Trykk ENTER for aa komme tilbake til hovedmenyen.");
            brukerInput();
        }
    }

        // bruke scanner obj til å hente bruker input.
        public static String brukerInput(){

            System.out.println("");
            Scanner inp = new Scanner(System.in);
            System.out.print(">> "); // print uten linje skift. gir >> til input
            String inputFraBruker = inp.nextLine();
            return inputFraBruker;
        }

        // skriv 200 linjer over slik at alt over blir fjernet. 
        public static void clearTerminal(){
            for (int i = 0; i < 200; i++){
                System.out.println("");
            }
        }

        public static Koe<Lenkeliste> listeAvLister(){
            Koe<Lenkeliste> megaListe = new Koe<Lenkeliste>();

            megaListe.leggTil(pasienter);
            megaListe.leggTil(legemiddler);
            megaListe.leggTil(leger);
            megaListe.leggTil(resepter);

            return megaListe;
        }
}

