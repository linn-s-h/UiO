import java.util.Iterator;
import java.util.NoSuchElementException;

//abstract class LenkeListe <E> implements liste <E>
abstract class Lenkeliste <E> implements Liste<E>{
    Node<E> rot = null;

    public E hent() {
        if (stoerrelse() == 0) {
            throw new UgyldigListeindeks(0);
        }
        return rot.hentInnhold();
    }

    public E fjern(){
        if(rot == null) {
            throw new UgyldigListeindeks(0);
        }
        Node<E> temp = rot;
        rot = rot.hentNeste();
        return temp.hentInnhold();
    }

    public int stoerrelse(){
        Node<E> node = rot;
        int teller = 0;
        while(node != null){
            teller++;
            node = node.hentNeste();
        }
        return teller;
    }

    public void leggTil(E x){
        Node<E> node = new Node(x);
        if(rot == null){
            rot = node;
        }else{
            Node<E> siste = finnSiste();
            siste.settNeste(node);
            node.settForrige(siste);
        }
    }

    public Node<E> finnSiste(){
        Node<E> node = rot;
        if (node != null){
            while(node.harNeste()){
                node = node.hentNeste();
            }
        }
        return node;
    }

    public Node<E> finnFoerste(){
        Node<E> node = rot;
        if(node != null){
            while(node.harForrige()){
                node = node.hentForrige();
            }
        }
        return node;
    }


    // Node
    public class Node <E>{
        
        E data;
        Node<E> neste;
        Node<E> forrige;

        public Node(E data) {
            this.data = data;
        }

        public boolean harNeste(){
            return neste != null;
        }

        public void settNeste(Node<E> neste){
            this.neste = neste;
        }

        public void settInn(E innhold){
            data = innhold;
        }

        public E hentInnhold(){
            //Henter objektet
            return data;
        }

        public Node<E> hentNeste(){
            return neste;
        }

        public void settForrige(Node<E> forrige){
            this.forrige = forrige;
        }

        public Node<E> hentForrige(){
            return forrige;
        }

        public boolean harForrige(){
            return forrige != null;
        }

    }
    class LenkelisteIterator implements Iterator<E> {

        private Node<E> denne;
        public LenkelisteIterator() {
            denne = rot;
        }

        public boolean hasNext() {
            return denne != null;
        }

        public E next() {
            Node tmpNode = denne;
            denne = denne.neste;
            return (E)tmpNode.data;
        }
    }

    public Iterator<E> iterator() {
        return new LenkelisteIterator();
    }
    /*
    //Iterator metode
    public Iterator<E> iterator(){
        return new LenkelisteIterator();
    }
    
    //LenkelisteIterator klasse
    public class LenkelisteIterator<E> implements Iterator<E>{

        Node peker = rot;
        
        public boolean hasNext(){
            return peker != null; //True or False
        }
        
        public E next() {
            E element = (E)peker.hentInnhold();
            peker = peker.hentNeste();
            return element;
        }
    }
    */
}

