

import java.util.Scanner;

class Oblig7{

    public static void main(String[] args){

        Labyrint labyrint = new Labyrint("labyrinter/" + args[0]);
        System.out.println(labyrint); //Printer ut labyrint og samt. finner aapninger

        System.out.print("Skriv inn koordinater <rad> <kolonne> ('q' for aa avslutte)\n> ");
        Scanner sc = new Scanner(System.in);
       

        while (true){

            String linje = sc.nextLine();
            String[] koordinater = linje.strip().split(" ");

            if (linje.equals("-1")){
                return;
            }
            if (Integer.parseInt(koordinater[0]) < 0 || Integer.parseInt(koordinater[0]) > labyrint.hentAntRader() || Integer.parseInt(koordinater[1]) < 0 || Integer.parseInt(koordinater[1]) > labyrint.hentAntKolonner()){
                System.out.print("\nUgyldige koordinater. Skriv igjen.\n> ");
            } else {
                labyrint.finnVeiUtFra(Integer.parseInt(koordinater[0]), Integer.parseInt(koordinater[1]));
                System.out.print("Skriv inn koordinater <rad> <kolonne> ('q' for aa avslutte)\n> ");
            }
    
        }

    
    }
}