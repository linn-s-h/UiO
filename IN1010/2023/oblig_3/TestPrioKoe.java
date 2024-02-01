
class TestPrioKoe{
    public static void main(String[] args){
        Prioritetskoe<Integer> koe = new Prioritetskoe<>();

        koe.leggTil(1);
        koe.leggTil(5);
        koe.leggTil(2);
        koe.leggTil(2);
        koe.leggTil(9);
        koe.leggTil(7);
        koe.fjern();

        System.out.println(koe);

        System.out.println("Forventet output: " + "22579");
    }
}