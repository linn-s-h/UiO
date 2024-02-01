/*
import java.util.ArrayList;
import java.util.List;
class Integrasjonstest {
    public static void main(String[] args) {
        // Liste med objekter
        List<Object> objektListe = new ArrayList<>();

        // Variabler
        String navn = "Heroin";
        int pris = 100;
        double virkestoff = 2.0;
        int styrke = 2;

        // Legemiddel objekter
        Narkotisk narko = new Narkotisk(navn, pris, virkestoff, styrke);
        objektListe.add(narko);
        Vanedannende vane = new Vanedannende(navn, pris, virkestoff, styrke);
        objektListe.add(vane);
        Vanlig vanlig = new Vanlig(navn, pris, virkestoff);
        objektListe.add(vanlig);


        // Lege objekt
        Lege lege = new Lege("Per");
        objektListe.add(lege);

        //Spesialist objekt
        Spesialist spesialist = new Spesialist("Ola");
        objektListe.add(spesialist);

        // Resept objekter
        HvitResept hvit = new HvitResept(narko, lege, 3);
        objektListe.add(hvit);
        BlaaResept blaa = new BlaaResept(vane, lege, 4);
        objektListe.add(blaa);
        MilResept mil = new MilResept(vanlig, lege);
        objektListe.add(mil);
        Presept presept = new Presept(vane, lege, 4);
        objektListe.add(presept);

        for(Object objekt : objektListe){
            System.out.println(objekt);
            System.out.println("___________");
        }

    }
}


 */