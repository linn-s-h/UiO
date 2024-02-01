
class Stabel <T> implements Liste<T> {
    public Node startNode = null;
    public int antNoder = 0;

    class Node{
        public T data;
        public Node neste = null;
        public Node(T nyData){
            data = nyData;
        }
    }
    public void settInn(T data){
        Node nyNode = new Node(data);
        Node peker = startNode;
        if (antNoder == 0){
            startNode = nyNode;
        }else{
            startNode = nyNode;
            startNode.neste = peker;
        }
    }

    public T taUt(){}

    public T kikk(){}
}