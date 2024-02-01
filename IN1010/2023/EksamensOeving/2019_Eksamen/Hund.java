
class Hund implements Comparable<Hund>{

    String navn;
    Kull mittKull;
    Tidspunkt minFodselstid;
    Hund neste = null;
    public Hund(Kull k, String n, Tidspunkt fodt){
        navn = n;
        mittKull = k;
        minFodselstid = fodt;
    }
    
    public Hund mor(){
        return mittKull.mor;
    }
    public Hund far(){
        return mittKull.far;
    }
    @Override
    public int compareTo(Hund h){
        
        //Dette går fordi minFodselstid er en referanse til klassen Tidspunkt
        
        int resultat = minFodselstid.compareTo(h.minFodselstid);
        if (resultat > 0){
            System.out.println(this + " ble fodt for " + h);
            return 1;
        } else if (resultat < 0){
            System.out.println(this + " ble fodt etter " + h);
            return -1;
        } else {
            System.out.println(this + " og " + h + " ble fodt samtidig");
            return 0;
        }
        //eller !!! :
        return minFodselstid.compareTo(h.minFodselstid);
    }
    
    public boolean erHelsosken(Hund h){
        return (this.mor().compareTo(h.mor()) == 0 && this.far().compareTo(h.far()) == 0);
    
    }
    public boolean erHalvsosken(Hund h){
        if (!erHelsosken(h)){
            return (this.mor().compareTo(h.mor()) == 0 || this.far().compareTo(h.far()) == 0);
        }
        return false; //For da er de helsosken
    }

    //se nærmere på dette :)
    public Hund finnEldsteKjenteOpphav(){
    
        if (mor() == null){
            return far().finnEldsteKjenteOpphav();
        }
        if (far() == null){
            return mor().finnEldsteKjenteOpphav();
        }
        Hund morsEldsteOpphav = mor().finnEldsteKjenteOpphav();
        Hund farsEldsteOpphav = far().finnEldsteKjenteOpphav();
        
        if (morsEldsteOpphav.compareTo(farsEldsteOpphav) < 0){
            return morsEldsteOpphav;
        } return farsEldsteOpphav;
    }
    
}