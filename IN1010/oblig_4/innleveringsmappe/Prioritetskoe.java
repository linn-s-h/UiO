public class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E> {
    @Override
    public void leggTil(E x){
        Node<E> nyNode = new Node(x);
        if(rot == null){
            rot = nyNode;
            return;
        }
        Node<E> temp = rot;
        while(temp != null && temp.hentInnhold().compareTo(x) < 0){
            temp = temp.hentNeste();
        }

        if(temp == null){
            Node<E> siste = finnSiste();
            siste.settNeste(nyNode);
            nyNode.settForrige(siste);
        }else if (temp.hentForrige() == null){
            nyNode.settNeste(rot);
            rot.settForrige(nyNode);
            rot = nyNode;
        } else{
            nyNode.settForrige(temp.hentForrige());
            nyNode.settNeste(temp);
            temp.hentForrige().settNeste(nyNode);
            temp.settForrige(nyNode);
        }
    }
}