import java.util.ArrayList;

class GeneriskBeholder <E> {
    ArrayList<E> array = new ArrayList<>(); 
    // T - Type, E element, K -  key,  V - value, N -  Number, men dette er bare konvensjoner, 
    //du kan gi type-parameteren ett eget navn om du ønsker
    // å tydeliggjøre mer hva som forventes av beholderen.s

    public void settInn(E x) {
        // Vi kan bruke typeparameteren i metodekall.
        array.add(x);
    }

    @Override 
    public String toString() {
        // Vi kan og bruke typen intern i klassemetoder. 
        String r = "";
        for (E x : array) {
            r += x + " "; 
        }
        return r;
    }

    public static void main(String[] args) {
        GeneriskBeholder<String> beholder = new GeneriskBeholder<>();
        for (int x = 0; x < 100; x++) beholder.settInn(""+x);
        System.out.println(beholder);

    }
}

class Firkant<N extends Number> {
    // Number er en abstrakt klasse som alle de innebygde talltypene i java arver fra.
    N ab; N bc; N cd; N da;
    public Firkant(N ab, N bc, N cd, N da) {
        this.ab = ab;
        this.bc = bc;
        this.cd = cd;
        this.da = da;
    }

    public static void main(String[] args) {

        new Firkant<Integer>(1, 2, 3, 4);  // Et heltall er et tallobjekt.
        new Firkant<Double>(2.1, 3.2, 3.2, 2.1); // Et flyttall er et tallobjekt.
        new Firkant<String>("en", "to", "tre", "fire"); // En streng er ikke et tallobjekt, så dette er ikke lov.
    }
}