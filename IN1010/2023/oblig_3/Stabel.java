
class Stabel <E> extends Lenkeliste<E>{

    @Override
    public void leggTil(E x){
        
        Node peker = foersteNode; //lokal peker
        Node nyNode = new Node(x);

        if (stoerrelse() == 0){ //dersom listen er tom for noder
            foersteNode = nyNode;
        }else{
            foersteNode = nyNode; //setter peker til start node
            foersteNode.neste = peker; //setter den nye noden sin neste med peker
        }
        iBruk++; //oppdaterer ant noder
    }
}
