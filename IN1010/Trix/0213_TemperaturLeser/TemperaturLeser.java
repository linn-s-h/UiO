import java.io.File;
import java.util.Scanner;
import java.io.*;

class TemperaturLeser{

    public static void main(String[] args){
        try{ //try catch

            int antPlass = 12;
            String[] temperaturArray = new String[antPlass];

            File fil = new File("Temperatur.txt");
            Scanner scanner = new Scanner(fil); //skal lese fra fil
            int forrigeIndeks = 0;

            while (scanner.hasNextInt()){ //så lenge løkken finner uleste linjer i filen
                int data = scanner.nextInt();
                for (int i = 0; i < forrigeIndeks + 1; i++){
                    if (temperaturArray[i] == null){
                        temperaturArray[i] = Integer.toString(data); //konverterer int til String
                    }
                }
                forrigeIndeks++; //øker forrigeIndeks når for løkken har kjørt ferdig 1 gang
            }
            for (int i = 0; i < temperaturArray.length; i++){ //test løkke
                System.out.println(temperaturArray[i]);
            }
            scanner.close();
        }
        catch (FileNotFoundException error){
            System.out.println("Uforventet resultat.");
            error.printStackTrace();
        }
    }

}

/* 
import java.util.Scanner;
import java.io.File;

class TemperaturLeser {
    public static void main(String[] args) throws Exception {
        Scanner fil = new Scanner(new File("Temperatur.txt"));
        String[] temperaturer = new String[12];
        int teller = 0;

        while(fil.hasNextLine()) {
            temperaturer[teller] = fil.nextLine();
            teller++;
        }

        for(int i = 0; i < temperaturer.length; i++) {
            System.out.println(temperaturer[i]);
        }
    }
} */