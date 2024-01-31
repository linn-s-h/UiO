import java.util.ArrayList;
import java.util.HashMap;

class Telefonbok{

    public static void main(String[] args){
        Person lars = new Person("Lars", "000 00 000", "Vakås");
        Person kristin = new Person("Kristin", "000 00 001", "Billingstad");
        Person julie = new Person("Julie", "000 00 002", "Lommedalen");

        //ArrayList<Person> telefonbok = new ArrayList<Person>(10);
        //telefonbok.add(lars);
        //telefonbok.add(kristin);
        //telefonbok.add(julie);

        HashMap<String, Person> telefonbok = new HashMap<String, Person>();
        telefonbok.put(lars.hentNavn(), lars);
        telefonbok.put(kristin.hentNavn(), kristin);
        telefonbok.put(julie.hentNavn(), julie);

        telefonbok.forEach((person, personObj)->System.out.println(person + "\n" + personObj));
    }
}