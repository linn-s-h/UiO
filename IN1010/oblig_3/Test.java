class Test{
    public static void main(String[] args){
        IndeksertListe<Integer> liste = new IndeksertListe<Integer>();
        liste.leggTil(1);
        liste.leggTil(2);
        liste.leggTil(1,3);
        liste.leggTil(4);
        liste.leggTil(5);
        liste.fjern(0);
        System.out.println(liste); 
    }
}