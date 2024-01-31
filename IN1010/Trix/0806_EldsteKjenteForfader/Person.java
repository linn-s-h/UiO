
class Person{

    String navn;
    int aar;
    Person mor, far;
    public Person(int aar, String navn, Person mor, Person far){
        this.navn = navn;
        this.aar = aar;
        this.mor = mor;
        this.far = far;
    }
    public Person mor(){
        return mor;
    }
    public Person far(){
        return far;
    }
    public int hentAar(){
        return aar;
    }
    public int compareTo(Person p){
        if (aar != p.aar) return aar - p.aar; //-1 betyr eldre
        return 0;
    }
    public Person finnEldsteKjenteForfader(){

        if (mor() == null){
            if (far() == null){
                return this;
            } else {
                return far().finnEldsteKjenteForfader();
                //prøver å finne forfader på farsiden
            }
        }
        if (far == null){ //hvis de to første if-sjekkene ikke gikk gjennom
            return mor.finnEldsteKjenteForfader();
        }
        Person morside = mor().finnEldsteKjenteForfader();
        Person farside = far().finnEldsteKjenteForfader();

        if (morside.compareTo(farside) < 0){ //morside er eldre
            return morside;
        } return farside;
    }

    public String toString(){
        String str = "\nNavn : " + navn + " ";
        str += "(" + aar + ")\n";
        str += "Mor: " + mor + "\n";
        str += "Far: " + far + "\n";
        return str;
    }
}

class TestPerson{
    public static void main(String[] args) {
      Person p1 = new Person(1672, "Inga", null, null);
      Person p2 = new Person(1690, "Karsten", p1, null );
      Person p3 = new Person(1694, "Petra", null, null);
      Person p4 = new Person(1715, "Ole", p3, p2);
      Person p5 = new Person(1718, "Ingeborg", null, null);
      Person p6 = new Person(1738, "Knut", p5, p4);
      Person p7 = new Person(1715, "Kai", null, null);
      Person p8 = new Person(1740, "Kari", null, p7);
      Person p9 = new Person(1761, "Sigrid", p8, p6);
  
      System.out.println("Sigrids eldste forfader er " + p9.finnEldsteKjenteForfader());
      //Sigrids eldste forfader er Inga.
      System.out.println("Riktig? " + (p9.finnEldsteKjenteForfader() == p1));
      System.out.println();
  
      System.out.println("Karis eldste forfader er " + p8.finnEldsteKjenteForfader());
      //Karis eldste forfader er Kai.
      System.out.println("Riktig? " + (p8.finnEldsteKjenteForfader() == p7));
      System.out.println();
  
      System.out.println("Ingas eldste forfader er " + p1.finnEldsteKjenteForfader());
      //Ingas eldste forfader er Inga selv.
      System.out.println("Riktig? " + (p1.finnEldsteKjenteForfader() == p1));
      System.out.println();
    }
}
  