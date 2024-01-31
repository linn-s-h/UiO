

//Main

class GameOfLife{

    public static void main(String[] args){
        int rad = Integer.parseInt(args[0]);
        int kol = Integer.parseInt(args[1]);
        GOLKontroll kontroller = new GOLKontroll(rad, kol);
        kontroller.startProgram();
    }
}