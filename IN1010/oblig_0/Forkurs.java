
class Forkurs {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
        for (int i = 0; i < 5; i++){
            System.out.println(array[i]);
        }

        String[] biler = {"Volvo", "Honda", "BMW", "Audi"};
        for (String i : biler){
            System.out.println(i);
            if (i == "Audi"){
                biler[0] = "Opel";
                System.out.println(biler[0]);
                System.out.println(biler.length); //Output 4
            }
        }

        int[][] numbers = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10} };
        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers[i].length; j++){
                System.out.println(numbers[i][j]);
            }
        }
    }
}

    