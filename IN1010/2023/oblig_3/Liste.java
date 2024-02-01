
interface Liste <E>{ //E er her en navnekonvensjon for typeparameter, E - Element
    int stoerrelse ();
    void leggTil (E x);
    E hent ();
    E fjern();
}