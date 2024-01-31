
import java.util.HashMap;
import java.util.Scanner;

class Telefonbok {
     public static void main(String[] args){
        HashMap<String, String> telefonbok = new HashMap<String, String>();
        telefonbok.put("Arne", "22334455");
        telefonbok.put("Lisa", "95959595");
        telefonbok.put("Jonas", "97959795");
        telefonbok.put("Peder", "12345678");

        Scanner scanner = new Scanner(System.in);

        boolean avslutt = false;

        while (avslutt == false){
            System.out.print("Navn?\n> ");
            String input = scanner.nextLine();  

            if (!input.equals("i")){ // alltid bruk equals fra nå av
                for (String person : telefonbok.keySet()){
                    if (person.equals(input)){ // må bruke .equals() fordi vi sammneligner String variabler
                        System.out.println(telefonbok.get(person));
                    }
                }  
                if(!(telefonbok.containsKey(input))){ //hvis input ikke er i telefonbok
                    System.out.println("Personen finnes ikke i telefonkatalogen.");
                }
            }
            else{
                avslutt = true;
            }
        }

        telefonbok.forEach((key, value)->
        System.out.println(key + ": " + value));
    }
}
