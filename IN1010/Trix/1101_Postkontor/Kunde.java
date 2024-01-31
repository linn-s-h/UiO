
class Kunde implements Runnable{

    String navn;
    Post.Postkontor postkontor;
    Kunde(String navn, Post.Postkontor postkontor){
        this.navn = navn;
        this.postkontor = postkontor;
    }
    public String hentNavn(){
        return navn;
    }
    //koe er en while loop som alltid kjøres
    public void run(){
        while (true) {
            Post p = postkontor.hentPost(navn);
            if (p != null){
                System.out.println(p);
            }
        }
    }
    public String toString(){
        return navn;
    }
}