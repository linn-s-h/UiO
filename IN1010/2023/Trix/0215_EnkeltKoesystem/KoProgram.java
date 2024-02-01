import java.util.Scanner;

class KoProgram{
    public static void main(String[] args){
        KoSystem koSystem = new KoSystem();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Velg");
        int velgBetjening = scanner.nextInt();

        while (velgBetjening != 4){
            hentMeny();
            System.out.println("Velg");
            velgBetjening = scanner.nextInt();

            if (velgBetjening == 1){
                koSystem.trekkKoLapp();
            }
            else if (velgBetjening == 2){
                koSystem.betjenKunde();
            }
            else if (velgBetjening == 3){
                koSystem.printerKunderIKo();
            }
            else{
                System.out.println("Vennligst velg 1, 2, 3 eller 4");
            }
        }
    }
    public static void hentMeny(){
        String meny = "\n *** MENY *** \n";
        meny += "1. Trekk ny koelapp \n";
        meny += "2. Betjen kunde \n";
        meny += "3. Print antall i koe \n";
        meny+= "4. Avslutt \n";

        System.out.println(meny);
    }
}