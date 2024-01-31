
class TestResepter{
    public static void main(String[] args){
     
        //oppretter legemiddel-objekter
        Vanlig ibux = new Vanlig("Ibux", 49, 400.0);
        Vanedannende nicorette = new Vanedannende("Nicorette", 189, 2.0, 2);

        Narkotisk cannabis = new Narkotisk("Cannabis", 720, 60.0, 60);
        Narkotisk tramadol = new Narkotisk("Tramadol", 299, 50.0, 50);

        //oppretter lege-objekter
        Lege lege = new Lege("Linn Jun");
        Spesialist spesialist = new Spesialist("Mari Notland", "4864");

        //oppretter resept-objekter
        BlaaResept blaaResept = new BlaaResept(cannabis, spesialist, 0001, 2);
        HvitResept hvitResept = new HvitResept(nicorette, lege, 0002, 8);
        MilResept milResept = new MilResept(tramadol, spesialist, 0003, 5); //reit skal settes til 3 når objektet opprettes selv om 5 sendes inn
        PResept pResept = new PResept(ibux, lege, 0004, 2);

        testFarge(pResept, "hvit"); //gir true
        System.out.println();
        testFarge(blaaResept, "blaa"); //gir true
        System.out.println();
        testReit(milResept, 3); //gir true //reit til milResept SKAL være 3
        System.out.println();
        testReit(milResept, 0); //gir false 
        System.out.println();
        testId(hvitResept, 1); //gir true
        System.out.println();
        testId(pResept, 3); //gir true
    }
    //test-metode for farge på resept 
    public static void testFarge(Resept testResept, String forventetFarge){
        if (testResept.farge() == forventetFarge){
            System.out.println(testResept);
            System.out.println();
            System.out.println("Forventet resultat: *** farge: " + forventetFarge + " ***");
        }
        else{
            System.out.println(testResept);
            System.out.println();
            System.out.println("Uforventet resultat.");
        }
    }

    //test-metode for reit på resept
    public static void testReit(Resept testResept, int forventetReit){
        if (testResept.hentReit() == forventetReit){
            System.out.println(testResept);
            System.out.println();
            System.out.println("Forventet resultat: *** reit: " + forventetReit + " ***");
        }
        else{
            System.out.println(testResept);
            System.out.println();
            System.out.println("Uforventet resultat.");
        }
    }
    //test-metode for legemiddel id
    public static void testId(Resept testResept, int forventetId){
        if (testResept.hentId() == forventetId){
            System.out.println(testResept);
            System.out.println();
            System.out.println("Forventet resultat: *** id: " + forventetId + " ***");
        }
        else{
            System.out.println(testResept);
            System.out.println();
            System.out.println("Uforventet resultat.");
        }
    }
}