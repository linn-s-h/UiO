
import java.util.Iterator;

interface Liste <E>{ //E er her en navnekonvensjon for typeparameter, E - Element
    int stoerrelse ();
    void leggTil (E x);
    E hent ();
    E fjern();
}

abstract class Lenkeliste <E> implements Liste<E>{
    protected int iBruk = 0; //teller for ant noder i listen
    protected Node foersteNode = null; //antar at 

    //Nøstet klasse
    protected class Node{
        Node neste = null; //en peker til neste node i listen
        E data = null; //en peker til data
        Node(E nyData){ //konstruktør
            data = nyData;
        }
    }
    public int stoerrelse(){
        return iBruk; //returnerer stoerrelse som er ant noder
    }

    public void leggTil(E x){
        Node peker = foersteNode;
        Node nyNode = new Node(x); //opretter ny node

        if (stoerrelse() == 0){ 
            foersteNode = nyNode; //ny node blir start node
        }else{  
            while (peker.neste != null){ //sjekker om siste node har en peker
                peker = peker.neste; //flytter på peker et hakk til høyre
            }
            peker.neste = nyNode; //setter peker
        }
        iBruk++;
    }

    public E hent(){
        return foersteNode.data; //returnerer foerste element
    }

    public E fjern(){
        if (stoerrelse() != 0){ //sjekker at listen ikke er tom for noder
            Node nodeUt = foersteNode; //lokal peker
            foersteNode = foersteNode.neste; 
            iBruk--;
            return nodeUt.data; //returnerer originale foersteNodes data
        }else{
            throw new UgyldigListeindeks(0); //ingen node
        }
    }
    @Override
    public String toString(){
        String svarStreng = ""; //tom streng
        Node peker = foersteNode;
        while (peker != null){
            svarStreng += peker.data;
            peker = peker.neste;
        }
        return svarStreng; //returnerer streng
    }
}