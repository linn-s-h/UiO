public class IndeksertListe <E> extends Lenkeliste <E>{

    public void leggTil(int pos, E x){
        if(pos < 0 || pos > stoerrelse()){
            throw new UgyldigListeindeks(pos);
        }

        Node<E> nyNode = new Node(x);

        if (rot == null){
            rot = nyNode;
        }else{
            if(pos == 0){
                rot.settForrige(nyNode);
                nyNode.settNeste(rot);
                rot = finnFoerste();
            }else{
                Node<E> node = rot;
                int teller = 0;
                while(node.harNeste() && teller < pos - 1){
                    node = node.hentNeste();
                    teller++;
                }


                nyNode.settNeste(node.hentNeste());
                node.settNeste(nyNode);
                nyNode.settForrige(node);

                if (nyNode.hentNeste() != null){
                    Node<E> neste = nyNode.hentNeste().hentForrige();
                    neste.settForrige(nyNode);
                }
            }
        }
    }

    public void sett(int pos, E x){
        if(pos < 0 || pos >= stoerrelse()){
            throw new UgyldigListeindeks(pos);
        }
        Node<E> node = rot;
        int teller = 0;
        while(node.harNeste() && teller < pos){
            node = node.hentNeste();
            teller++;
        }

        node.settInn(x);
    }

    public E hent(int pos){
        if(pos < 0 || pos > stoerrelse()){
            throw new UgyldigListeindeks(pos);
        }
        Node<E> node = rot;
        int teller = 0;
        while(node.harNeste() && teller < pos){
            node = node.hentNeste();
        }
        return node.hentInnhold();
    }

    public E fjern(int pos){
        if(pos < 0 || pos >= stoerrelse()){
            throw new UgyldigListeindeks(pos);
        }

        if(rot == null){
            return null;
        }
        Node<E> node = rot;
        int teller = 0;
        while(node.harNeste() && teller < pos){
            node = node.hentNeste();
            teller++;
        }

        if(rot == node){
            rot = node.hentNeste();
        }

        if(node.harNeste()){
            node.hentNeste().settForrige(node.hentForrige());
        }

        if(node.harForrige()){
            node.hentForrige().settNeste(node.hentNeste());
        }

        return node.hentInnhold();
    }
}
