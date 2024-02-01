import java.util.Scanner;

class Gruppemoete{

    private String[] navn = new String[14];
    private boolean[] oppmoete = new boolean[14];
    int totalStudenter = 0;

    public void lesFraFil(String filnavn) throws Exception{
        Scanner lesFraFil = new Scanner(filnavn);
        while (lesFraFil.hasNextLine() && totalStudenter < navn.length){
            navn[totalStudenter] = lesFraFil.nextLine();
            totalStudenter++;
        }
        lesFraFil.close();
    }
    public void registrerOppmoete(String student){
        for (int i = 0; i < totalStudenter; i++){
            if (student.equals(navn[i])){
            oppmoete[i] = true;
            }
        }
    }
    public void ropOpp(){
        for (int i = 0; i < totalStudenter; i++){
            if (oppmoete[i]){
                System.out.println(navn[i] + "har moett opp.");
            }
            else{
                System.out.println(navn[i] + "har ikke moett opp.");
            }
        }
    }
}

