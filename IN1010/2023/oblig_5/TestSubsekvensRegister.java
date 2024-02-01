
import java.util.HashMap;
import java.io.FileNotFoundException;

class TestSubsekvensRegister {
    public static void main(String[] args){
        try {
            HashMap<String, Subsekvens> testFil1 = SubsekvensRegister.lesFil("fil1.csv");
            HashMap<String, Subsekvens> testFil2 = SubsekvensRegister.lesFil("fil2.csv");
            HashMap<String, Subsekvens> flettetHashmap = SubsekvensRegister.flettSammen(testFil1, testFil2);
            flettetHashmap.forEach((key, value) -> System.out.println(key + " = " + value));
        } catch (FileNotFoundException e){
            System.out.println("Fil ikke funnet. " + e);
        }
      
    }
}