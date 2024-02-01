
class PostSystem{

    public static void main(String[] args){
        
        Post p = new Post("", "");
        Post.Postkontor postkontor = p.new Postkontor(); // må skrive det sånn når klassen er inni en klasse x.new g()

        Postmann postmann = new Postmann(postkontor);
        Thread thread = new Thread(postmann);
        thread.start();

        Kunde kundeEn = new Kunde("Tommy", postkontor);
        thread = new Thread(kundeEn);
        thread.start();

        Kunde kundeTo = new Kunde("Mina", postkontor);
        thread = new Thread(kundeTo);
        thread.start();

    }
}