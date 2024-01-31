
class Test{
    public static void main(String[] args){
        Drikke glass = new Drikke(15);
        Ol ol_glass = new Ol(12);
        ol_glass.drikkGlass();
        glass.drikkGlass();
        glass.drikkGlass();
        glass.drikkGlass();
        glass.drikkGlass();
        System.out.println(glass);
        System.out.println(ol_glass);
    }
}