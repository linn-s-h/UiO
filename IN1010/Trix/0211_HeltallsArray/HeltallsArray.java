
class HeltallsArray{

    public static void main(String[] args){
        
        int[] arrayOfint = new int[5];

        for (int i = 0; i < 5; i++){
            arrayOfint[i] = i;
        }
        
        int indeks = 0;
        while (indeks < 5){
            System.out.println(arrayOfint[indeks]);
            indeks ++;
        }
    }
}