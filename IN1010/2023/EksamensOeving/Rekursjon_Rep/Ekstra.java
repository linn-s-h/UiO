package Rekursjon_Rep;

import java.util.ArrayList;

public class Ekstra {

    // oppg1: skriv en metode som gitt et array av int'er returnerer det minste tallet i arrayet
    // [6,3,7,1] --> 1

    //antar at listen inneholder minst 1 tall
    //[1,2]

    public static int finnMinsteTall(int[] array){
        int minst = finnMinstRekursivt(array, 0, 100000);
        return minst;
    }

    public static int finnMinstRekursivt(int[] arr, int indeks, int minstSaaLangt){
        if(indeks == arr.length){
            return minstSaaLangt;
        }
        if(arr[indeks] < minstSaaLangt){
            minstSaaLangt = arr[indeks];
        }
        minstSaaLangt = finnMinstRekursivt(arr, indeks+1, minstSaaLangt);
        return minstSaaLangt;
    }

    // oppg2: skriv en rekursiv metode som tar inn en arraylist av tall, og et tall å lete etter. Metoden
    // teller antall ganger tallet forekommer i listen
    // [2,6,4,2,2], 2 --> 3
    // [5,4,2], 8 --> 0


    public static int finnAntallAv(ArrayList<Integer> liste, int leteEtter){
        return finnAntallAvRekursivt(liste, leteEtter, 0);
    }

    public static int finnAntallAvRekursivt(ArrayList<Integer> liste, int leteEtter, int sum){
        if(liste.isEmpty()) return sum;

        int tall = liste.remove(0);
        if(tall == leteEtter) sum++;

        sum = finnAntallAvRekursivt(liste, leteEtter, sum);
        return sum;
    }

    // oppg3: Skriv funksjonen substringRekursivt(). 
    // Denne skal gitt en string, en startindeks og en sluttindeks returnere en streng som 
    // har bokstavene fra strengens indeks «startindeks» til indeks «sluttindeks-1». Ta hensyn til at brukeren kan skrive inn ulogiske indekser.
    // "haheiha", 2, 5 --> "hei"

    public static String subStringRekursivt(String streng, int start, int slutt){
        if(start >=slutt-1 || start == streng.length() -1){
            return "" + streng.charAt(start);
        }

        return streng.charAt(start) + subStringRekursivt(streng, start+1, slutt);
    }

}