import java.util.ArrayList;

class Student{
    private String studentNavn;
    private int quizScore;
    private int antQuizer;

    public Student(String navn, int score, int ant){
        studentNavn = navn;
        quizScore = score;
        antQuizer = ant;
    }
    public String hentNavn(){
        return studentNavn;
    }
    public void leggTilQuizScore(int nyScore){
        quizScore += nyScore;
        antQuizer++;
    }
    public int hentTotalScore(){
        return quizScore;
    }
    public void hentGjennomsnittligScore(ArrayList<Student> studenter){
        double gjennomsnittScore = 0.0;
        for (Student student : studenter){
            gjennomsnittScore += student.hentTotalScore();
        }
        System.out.println(gjennomsnittScore / studenter.size());
    }

}