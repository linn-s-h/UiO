
class Integrasjonstest{
    public static void main(String[] args){
        Spesialist doktorEvanger = new Spesialist("Markus Evanger", "3112");
        Lege legeHoltet = new Lege("Knut Holtet");

        Vanlig pPiller = new Vanlig("P-piller", 90, 75.0);
        Vanedannende metadon = new Vanedannende("Metadon Abcur", 435, 40.0, 40);
        Narkotisk fentanyl = new Narkotisk("Fentanyl Sandoz", 166, 0.0125, 0);

        BlaaResept blaaResept = new BlaaResept(fentanyl, doktorEvanger, 1111, 1);
        HvitResept hvitResept = new HvitResept(metadon, legeHoltet, 2222, 1);
        PResept pResept = new PResept(pPiller, legeHoltet, 3333, 8);
        MilResept milResept = new MilResept(fentanyl, doktorEvanger, 4444, 1);

        //hver klasse har egen toString() metode
        System.out.println(blaaResept);
        System.out.println();
        System.out.println(hvitResept);
        System.out.println();
        System.out.println(pResept);
        System.out.println();
        System.out.println(milResept);
    }
}