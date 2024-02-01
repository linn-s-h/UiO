
class Person {

    private String navn;
    private String telefonnummer;
    private String adresse;

    public Person(String navn, String telefonnummer, String adresse) {
        this.navn = navn;
        this.telefonnummer = telefonnummer;
        this.adresse = adresse;
    }

    public String toString() {
        String str =  "Navn: " + navn + "\n";
        str += "Telefonnummer: " + telefonnummer + "\n";
        str += "Adresse: " + adresse + "\n";
        return str;
    }

    public String hentNavn() {
        return navn;
    }
}