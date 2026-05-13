package Abstractizare;

public class Main {
    public static void main (String []args) {
        Circle cerc = new Circle();

        int ariaCerc = cerc.calculateArea(13, 0);
        System.out.println("Aria cerc " + ariaCerc);

        Rectangle dreptunghi = new Rectangle();

        int ariaDreptunghi = dreptunghi.calculateArea(4,5);
        System.out.println("Aria dreptunghi " + ariaDreptunghi);

        String deseneazaCerc = cerc.draw();
        System.out.println(deseneazaCerc);
    }
}
