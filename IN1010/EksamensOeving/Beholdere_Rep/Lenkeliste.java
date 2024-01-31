import java.util. Iterator;
import java.util.NoSuchElementException;

class Lenkeliste implements Iterable<Integer> {
    class LenkelisteIterator implements Iterator<Integer> {
        Node neste;
        public LenkelisteIterator() {
            neste = forste;
        }

        public boolean hasNext() {
            return neste != null;
        }

        public Integer next() {
            if (neste == null) {
                throw new NoSuchElementException();
            }
            Integer n = neste.element;
            neste = neste.neste;
            return n;
        }
    }

    class Node {
        public int element;
        Node neste;
        Node forrige;
        public Node (int e) {
            element = e;
        }
    }
    Node forste;
    Node siste;

    public void settInn(int e) {
        if (forste == null) {
            forste = new Node(e);
            siste = forste;
        } else {
            Node nyNode = new Node(e);
            siste.neste = nyNode;
            nyNode.forrige = siste;
            siste = nyNode;
        }
    }
    public LenkelisteIterator iterator() {
        return new LenkelisteIterator();
    }

    public static void main(String[] args) {
        Lenkeliste lenkeliste = new Lenkeliste();
        for (int i = 0; i < 100; i++) lenkeliste.settInn(i);

        for (int x : lenkeliste) {
            System.out.println(x);
        }

        Iterator<Integer> i = lenkeliste.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}