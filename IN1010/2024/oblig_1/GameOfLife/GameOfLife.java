import java.util.Scanner;

class GameOfLife{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Antall rader? ");
        int r = scanner.nextInt();
        System.out.println("Antall kolonner? ");
        int k = scanner.nextInt();

        Verden verden = new Verden(r,k);

        String fortsett = scanner.nextLine();

        do {
            verden.tegn();
            verden.oppdatering();
            fortsett = scanner.nextLine();
        }
        while (!(fortsett.equals("q")));
    }
}