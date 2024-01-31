
class Legesystem{

        public void meny(){

            System.out.println("****** MENY ******");
            System.out.println("1. Opprett og legg til nye elementer i systemet");
            System.out.println("2. Bruk en gitt resept fra listen til pasient");
            System.out.println("3. Skriv ut forskjellig former for statistikk");
            System.out.println("4. Skriv all data til fil");
            System.out.println("0. Avslutt");
        }

        public void kommandolokke(){

            Scanner input = new Scanner(System.in);
            int inputFraBruker = -1;

            while (inputFraBruker != 0){
                if (inputFraBruker == 1){
                    //metode
                } else if (inputFraBruker == 2){
                    //metode
                } else if (inputFraBruker == 3){
                    //metode
                } else if (inputFraBruker == 4){
                    //metode
                }
                meny();
                inputFraBruker = Integer.parseInt(input.nextLine());
            }
        }
}