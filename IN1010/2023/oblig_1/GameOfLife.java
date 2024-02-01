import java.util.Scanner;

class GameOfLife {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Antall rader: ");
        int rad = scan.nextInt();
        System.out.print("Antall kolonner: ");
        int kol = scan.nextInt();
        
        Verden gameOfLife = new Verden(rad, kol);

        String fortsett = scan.nextLine();
        do {
            gameOfLife.tegn();
            gameOfLife.oppdatering();
            fortsett = scan.nextLine();
        }
        while (!fortsett.equals("q")); //bruker må trykke q og enter for å avslutte program
    }
}