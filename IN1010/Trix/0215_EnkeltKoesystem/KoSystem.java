import java.util.*;

class KoSystem{

    ArrayList<KoLapp> koLapper = new ArrayList<>();
    int teller = 0;

    public void trekkKoLapp(){
        KoLapp nyKoLapp = new KoLapp(teller);
        System.out.println(nyKoLapp.hentNummer() + " er i koe");
        koLapper.add(nyKoLapp);
        teller++;

    }
    public void betjenKunde(){
        if (koLapper.isEmpty()){
            System.out.println("Ingen i koe");
        }else{
            KoLapp foersteLapp = koLapper.get(0); //henter første indeks
            System.out.println(foersteLapp.hentNummer() + "blir betjent");
            koLapper.remove(foersteLapp);
        }
    }
    public int antKunder(){
        return koLapper.size();
    }
    public void printerKunderIKo(){
        for (KoLapp koLapp : koLapper){
            System.out.println(koLapp.hentNummer() + " er i koe");
        }
    }
}