import java.util.ArrayList;

class MainProgram{
    public static void main(String[] args){
        ArrayList<Student> studenter = new ArrayList<Student>();

        Student joakim = new Student("Joakim", 20, 2);
        Student kristin = new Student("Kristin", 28, 3);
        Student dag = new Student("Dag", 32, 2);

        joakim.leggTilQuizScore(10);
        kristin.leggTilQuizScore(12);
        dag.leggTilQuizScore(15);

        studenter.add(joakim);
        studenter.add(kristin);
        studenter.add(dag);

        for (Student student : studenter){
            System.out.println(student.hentTotalScore());
        }

        joakim.hentGjennomsnittligScore(studenter);

    }
}