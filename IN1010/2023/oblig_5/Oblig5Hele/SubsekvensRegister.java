
import java.util.ArrayList;
import java.util.HashMap;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class SubsekvensRegister {

    ArrayList<HashMap<String, Subsekvens>> hashBeholder = new ArrayList<HashMap<String, Subsekvens>>();

    //Metode som skal sette inn 
    public void settInnSubsekvenser(HashMap<String, Subsekvens> hashmap){
        hashBeholder.add(hashmap);
    }
    //Metode skal fjerne vilkårlig hashmap og returne den
    public HashMap<String, Subsekvens> taUtSubsekvenser(){
        if (antHashMap() > 0){
            return hashBeholder.remove(0);
        } return null;
    }
    //Metode returner ant hashmaps
    public int antHashMap(){
        return hashBeholder.size();
    }
 
    public static HashMap<String, Subsekvens> lesFil(String filnavn) throws FileNotFoundException {

        File fil = new File(filnavn);
        Scanner sc = new Scanner(fil); //Lese fil


        //oppretter ny hashmap med subsekvenser
        HashMap<String, Subsekvens> hashmap = new HashMap<>();

        while (sc.hasNextLine()){
            String linje = sc.nextLine();

            for (int i = 0; i < linje.length() - 2; i++){ //vil ikke sjekke forbi de 3 siste sifrene
                String str = linje.substring(i, i + 3);
                Subsekvens subsekvens = new Subsekvens(str);
                hashmap.put(str, subsekvens);
            }
        } sc.close(); return hashmap; 
    }
    public static HashMap<String, Subsekvens> flettSammen(HashMap<String, Subsekvens> h1, HashMap<String, Subsekvens> h2){
        
        HashMap<String, Subsekvens> flettetHashMap = new HashMap<String, Subsekvens>();

        ArrayList<HashMap<String, Subsekvens>> hashmaps = new ArrayList<HashMap<String, Subsekvens>>();
        hashmaps.add(h1);
        hashmaps.add(h2);

        for (HashMap<String, Subsekvens> hashmap : hashmaps){

            for (HashMap.Entry<String, Subsekvens> h : hashmap.entrySet()){
                String str = h.getKey();
                Subsekvens s = h.getValue();
                if (!flettetHashMap.containsKey(str)){
                    flettetHashMap.put(str, s);
                   
                } else {
                    //Hvis subsekvensen allerede har forekommet før, så finner vi ant forekomster begge steder og endrer
                    //ant forekomster i beholderen med flettet hashmapper
                    //Bruker Map.Entry
                    for (HashMap.Entry<String, Subsekvens> hData : flettetHashMap.entrySet()){
                        String strData = hData.getKey();
                        Subsekvens sData = hData.getValue();    
                        if (strData.equals(str)){
                            int nyAnt = sData.hentAntForekomster() + s.hentAntForekomster(); //ikke + 1 !
                            sData.endreAntForekomster(nyAnt);
                            //System.out.println(strEntry + " " + nyAnt);
                           
                        }
                    }
                }
            }
        } return flettetHashMap;
       
    }
}