
class TestLegemiddel{
    public static void main(String[] args){
        Vanlig paracet = new Vanlig("Paracetamol", 29, 500.0);
        Vanedannende sobril = new Vanedannende("Sobril", 114, 15.0, 15);
        Narkotisk cannabis = new Narkotisk("Cannabis", 720, 60.0, 60);

        if (testLegemiddelId(paracet, 0)){
            System.out.println();
            System.out.println(paracet);
            System.out.println("*** Paracet har sin unike id ***");
        }
        else{
            System.out.println("Uforventet resultat.");
        }

        if (testLegemiddelId(sobril, 1)){
            System.out.println();
            System.out.println(sobril);
            System.out.println("*** Sobril har sin unike id ***");
        }
        else{
            System.out.println("Uforventet resultat.");
        }

        if (testLegemiddelId(cannabis, 2)){
            System.out.println();
            System.out.println(cannabis);
            System.out.println("*** Cannabis har sin unike id ***");
        }
        else{
            System.out.println("Uforventet resultat.");
        }
    }

    public static boolean testLegemiddelId(Legemiddel legemiddel, int forventetId){
        return legemiddel.id == forventetId; //sammenligner instansen til legemiddel med parameter
    }
}