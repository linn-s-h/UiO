

class Eksempler{
    public static void main(String[] args){

        final int TALL = 3;
        int tall = TALL; //Setter variabel til å være konstant verdi av tall

        tellNedRekursivt(tall);
    }

    public static int tellNed(int tall){
        System.out.println("teller ned: " + tall);
        vent(1000); //1000 millisekunder er 1 sekund
        return tall - 1; //returner telt ned tall
    }

    //Rekursjon er noe som kaller på seg selv, med et ikke-rekursivt tilfelle og rekursivt tilfelle (if else)
    public static void tellNedRekursivt(int tall){

        if (tall < 1){ //Skal kun telle ned fra 3 til og med 1
            tellOppRekursivt(tall + 1);
            return;
        }
        System.out.println("teller ned rekursivt: " + tall);
        vent(1000);
        tellNedRekursivt(tall - 1);
    }

    public static void tellOppRekursivt(int tall){
        if (tall > 3){
            return;
        }
        System.out.println("teller opp rekursivt: " + tall);
        vent(1000);
        tellOppRekursivt(tall + 1);
    }
    
    // Hjelpemetode
    public static void vent(int tid){
        try{
            Thread.sleep(tid);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
}