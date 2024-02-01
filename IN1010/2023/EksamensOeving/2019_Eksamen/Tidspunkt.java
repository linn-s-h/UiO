
class Tidspunkt implements Comparable<Tidspunkt>{
    
    public int aar, mnd, dag, time, min, sek;
    public Tidspunkt(int aar, int mnd, int dag, int time, int min, int sek){
        this.aar = aar;
        this.mnd = mnd;
        this.dag = dag;
        this.time = time;
        this.min = min;
        this.sek = sek;
     
    }
    //Kan ikke bruke compareTo på varibaler som ikke er objekter
    public int compareTo(Tidspunkt annen){
        if (aar != annen.aar) return aar - annen.aar;
        if (mnd != annen.mnd) return mnd - annen.mnd;
        if (dag != annen.dag) return dag - annen.dag;
        if (time != annen.time) return time - annen.time;
        if (min != annen.min) return min - annen.min;
        return sek - annen.sek;
    }
    @Override
    public String toString(){
        return String.format("%02d.%02d.&04d kl %02d:%02d:%02d", dag, mnd, aar, time, min, sek);
    }
}