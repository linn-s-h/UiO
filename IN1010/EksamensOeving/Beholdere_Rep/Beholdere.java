
class Beholdere {
    // Et dynamisk array (som en ArrayList) er egentlig bare et array, men som utvider seg selv etter behov.
    int[] tallbeholder =  new int [30];
    int storrelse = 0;

    public void settInn(int x) {
        // Hvis det plass til flere objekter, kan vi bare plassere i arrayet.
        if (storrelse < tallbeholder.length) {
            tallbeholder[storrelse] = x;
            storrelse++;

        } else {
            // Hvis det ikke er mer plass må vi utvide arrayet.
            utvid();
            settInn(x);
        }
    }

    private void utvid() {
        // Her gjør vi arrayet dobelt så stort. 
        int nyStorrelse = tallbeholder.length * 2;
        int[] nyttArray = new int[nyStorrelse];
        int i = 0;
        // Siden vi har laga ett nytt array må vi kopiere over alle verdiene vi hadde i det originale
        // inn i det nye.
        for (int x : tallbeholder) {
            nyttArray[i++] = x;
        }
        // Nå kan vi sette beholderen til å bli det nye arrayet. 
        tallbeholder = nyttArray;
    }

    public void skrivUt() {
        // skriver ut alle de opptatte plassene i arrayet.
        for (int i = 0; i < storrelse; i++) {
            System.out.println(tallbeholder[i]);
        }
    }

    public static void main(String[] args) {
        Beholdere b = new Beholdere();
        // Forsøker å sette inn 100 elementer i arrayet.
        for (int i = 0; i < 100; i++) b.settInn(i);
        b.skrivUt();
    }
}