
class TestLenkeliste{

    public static void main(String[] args){

        Koe<String> liste = new Koe<>();

        liste.leggTil("markus");
        liste.leggTil("linn");
        liste.leggTil("abdi");
        liste.leggTil("knut");
        liste.leggTil("marius");

        for (String element : liste){
            System.out.println(element);
        }
    }
}