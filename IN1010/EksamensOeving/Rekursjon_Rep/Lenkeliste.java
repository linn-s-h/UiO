package Rekursjon_Rep;

class Lenkeliste{

    class Node{
        
        String data;
        Node neste;
        Node(String d){
            data = d;
        }
    }

    Node hode; 

    public void leggTil(String s){
        Node nyNode = new Node(s);
        if(hode == null) hode = nyNode;
        else{
            leggTilRekursivt(hode, nyNode);
        }
    }

    public void leggTilRekursivt(Node naavaerende, Node ny){
        if(naavaerende.neste == null){
            naavaerende.neste = ny;
            return;
        }
        leggTilRekursivt(naavaerende.neste, ny);
    }
}