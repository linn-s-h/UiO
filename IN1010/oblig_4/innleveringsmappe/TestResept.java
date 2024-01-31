/*
class TestResept {
    private static void sjekk(String hva, boolean test){
        if(!test){
            System.out.println("Sjekken '" + hva + "' feilet!");
            System.exit(1);
        }
    }

    public static void testHvitResept(){
        String navn = "Morfin";
        int pris = 100;
        double virkestoff = 10;
        int styrke = 10;

        Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
        Lege lege = new Lege("Per");
        HvitResept hvit = new HvitResept(narkotisk, lege, 4);
        sjekk("testHvitResept().farge()", hvit.farge() == "Hvit");
        sjekk("testHvitResept().prisAaBetale()", hvit.prisAaBetale() == 100);

        System.out.println("testHvitResept(): Alt riktig!");
    }

    public static void testBlaaResept(){
        String navn = "Morfin";
        int pris = 100;
        double virkestoff = 10;
        int styrke = 10;

        Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
        Lege lege = new Lege("Per");
        BlaaResept bla = new BlaaResept(narkotisk, lege,3);
        sjekk("testBlaaResept().farge()", bla.farge() == "Blaa");
        sjekk("testBlaaResept().prisAaBetale()", bla.prisAaBetale() == 75);

        System.out.println("testBlaaResept(): Alt riktig!");
    }

    public static void testMilResept(){
        String navn = "Morfin";
        int pris = 100;
        double virkestoff = 10;
        int styrke = 10;

        Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
        Lege lege = new Lege("Per");
        MilResept milResept = new MilResept(narkotisk, lege);
        //pasientid og reit
        sjekk("test.MilResept.hentPris()", milResept.prisAaBetale() == 0);
        sjekk("test.MilResept.hentReit()", milResept.hentReit() == 3);

        System.out.println("testMilResept(): Alt riktig!");
    }

    public static void testPresept(){
        String navn = "Morfin";
        int pris = 100;
        double virkestoff = 10;
        int styrke = 10;

        Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
        Lege lege = new Lege("Per");
        Presept presepter = new Presept(narkotisk, lege, 4);
        sjekk("testPresept().prisAaBetale()", presepter.prisAaBetale() == 1);
        sjekk("testPresept().hentReit()", presepter.hentReit() == 4);

        System.out.println("testPresept(): Alt riktig!");
    }

    public static Resept testToString(){
        String navn = "Nikotin";
        int pris = 40;
        double virkestoff = 3;
        int styrke = 3;

        Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
        System.out.println(narkotisk);

        Lege lege = new Lege("Per");
        Pasient pasient = new Pasient("Hei");
        MilResept milResept = new MilResept(narkotisk, lege);
        return milResept;
    }



    public static void main(String[] args) {
        System.out.println("** Test Resept subklasser **");
        // testHvitResept();
        // testBlaaResept();
        // testMilResept();
        // testPresept();
        System.out.println(testToString());



    }
}
 */