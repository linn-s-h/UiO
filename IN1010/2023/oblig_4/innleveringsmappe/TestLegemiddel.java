/*
class TestLegemiddel {
    private static void sjekk(String hva, boolean test){
        if (!test){
            System.out.println("Sjekken '" + hva + "' feilet!");
            System.exit(1);
        }
    }
    public static void testNarkotisk(){
        String navn = "Morfin";
        int pris = 100;
        double virkestoff = 10;
        int styrke = 10;

        Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
        sjekk("testNarkotisk.hentPris()", narkotisk.hentPris() == 100);
        narkotisk.settPris(150);
        sjekk("testNarkotisk.settPris()", narkotisk.hentPris() == 150);

        sjekk("testNarkotisk.hentId()", narkotisk.hentId() == 0);
        Narkotisk narkotisk2 = new Narkotisk(navn, pris, virkestoff, styrke);
        sjekk("testNarkotisk.hentId()", narkotisk2.hentId() == 1);

        System.out.println("testNarkotisk(): Alt riktig!");
    }
    public static void testVanedannende(){
        String navn = "Tobakk";
        int pris = 98;
        double virkestoff = 4;
        int styrke = 4;

        Vanedannende vanedannende = new Vanedannende(navn, pris, virkestoff, styrke);
        Vanedannende vanedannende2 = new Vanedannende(navn, pris, virkestoff, styrke);

        sjekk("testVanedannende().hentPris()", vanedannende.hentPris() == 98);
        vanedannende.settPris(101);

        sjekk("test.Vanedannende().hentPris()", vanedannende.hentPris() == 101);
        sjekk("test.Vanedannende().hentId()", vanedannende.hentId() == 2);
        sjekk("test.Vanedannende().hentId()", vanedannende2.hentId() == 3);
        System.out.println("testVanedannende(): Alt riktig!");
    }
    public static void testVanlig(){
        String navn = "Nikotin";
        int pris = 40;
        double virkestoff = 3;
        int styrke = 3;

        Vanlig vanlig = new Vanlig(navn, pris, virkestoff, styrke);
        sjekk("testVanlig().hentPris()", vanlig.hentPris() == 40);
        vanlig.settPris(45);
        sjekk("testVanlig().settPris()", vanlig.hentPris() == 45);
        sjekk("testVanlig().hentId()", vanlig.hentId() == 4);

        Vanlig vanlig2 = new Vanlig(navn, pris, virkestoff, styrke);
        sjekk("testVanlig().hentId()", vanlig2.hentId() == 5);

        System.out.println("testVanlig(): Alt riktig!");
    }

    public static void testToString(){
        String navn = "Nikotin";
        int pris = 40;
        double virkestoff = 3;
        int styrke = 3;

        Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
        System.out.println(narkotisk);
    }


    public static void main(String[] args) {
        System.out.println("** Test Legemiddel subklasser **");
        // testNarkotisk();
        // testVanedannende();
        // testVanlig();
        // testToString();
    }
}
 */