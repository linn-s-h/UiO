
class IndeksertListe <E> extends Lenkeliste<E>{
    
    public void leggTil(int pos, E x){
        int i = 0; //indeks-teller
        Node peker = foersteNode;
        Node nyNode = new Node(x);

        if (pos >= 0 && pos <= stoerrelse()){ //gjør et unntak her med <= stoerrelse() siden x kan bli lagt til helt sist i listen
            if (stoerrelse() == 0){
                super.leggTil(x);
            }else if (pos == 0 && stoerrelse() > 0){
                //samme funksjonalitet og logikk som i class Stabel
                foersteNode = nyNode; 
                foersteNode.neste = peker; 
                iBruk++;
            }else{
                while (peker.neste != null && i < (pos - 1)){
                    peker = peker.neste;
                    i++;
                }
                Node tmp = peker; //oppretter en lokal peker slik at operasjonen er mindre sårbar
                nyNode.neste = tmp.neste; //ny node skal få en neste som peker til forrige nodes neste
                tmp.neste = nyNode; //setter at forrige node sin neste nå peker til den nye noden
                iBruk++;
            }
        }else{
            throw new UgyldigListeindeks(0);
        }
    }

    public void sett(int pos, E x){
        int i = 0; //indeks-teller
        Node peker = foersteNode;
        if (pos >= 0 && pos < stoerrelse()){
            while (peker.neste != null && i < pos){ // 0 < 1
                peker = peker.neste;
                i++;
            }
            peker.data = x; //erstatter element i pos med ny verdi
        }else{
            throw new UgyldigListeindeks(0);
        }
    }

    public E hent(int pos){
        int i = 0; //indeks-teller
        Node peker = foersteNode; //jobber først fra start node og så videre mot høyere
        if (pos >= 0 && pos < stoerrelse()){
            while (peker.neste != null && i < pos){
                peker = peker.neste;
                i++;
            }
            return peker.data;
        }else{
            throw new UgyldigListeindeks(0);
        }
    }
    public E fjern(int pos){
        int i = 0; //indeks-teller
        Node peker = foersteNode;
        if (pos >= 0 && pos < stoerrelse()){
            if (pos == 0){
                E data = foersteNode.data;
                foersteNode = foersteNode.neste;
                iBruk--;
                return data;
            }else{
                while (peker.neste != null && i < (pos - 1)){
                    peker = peker.neste;
                    i++;
                }
                Node nodeUt = peker.neste; //oppretter en peker for node i pos
                peker.neste = nodeUt.neste; //setter
                iBruk--;

                return nodeUt.data;
            }
        }else{
            throw new UgyldigListeindeks(0);
        }
    }
}