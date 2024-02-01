
class Utskrift{

    public static void vent(int tid){
        try {
            Thread.sleep(tid);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }

    public static void rekursivUtskrift(int i){
        if (i > 10){
            return;
        }
        System.out.println(i);
        vent(1000);
        rekursivUtskrift(i + 1);
    }
    public static void main(String[] args){
        rekursivUtskrift(1);
    }
}