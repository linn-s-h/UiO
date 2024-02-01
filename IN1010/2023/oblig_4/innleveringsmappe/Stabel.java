public class Stabel <E> extends Lenkeliste<E>{
    @Override
    public void leggTil(E x){
        Node<E> node = new Node(x);
        if (rot == null){
            rot = node;
        }else{
            Node<E> foerste = finnFoerste();
            foerste.settForrige(node);
            node.settNeste(foerste);
            rot = finnFoerste();
        }
    }
}
