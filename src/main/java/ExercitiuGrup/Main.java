package ExercitiuGrup;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("BMW", 200, 4);
        car.move();
        car.honk();
        System.out.println("Numar roti: " + car.getNumberOfWheels());

        System.out.println("---");

        Train train = new Train("CFR", 120, 10);
        train.move();
        train.whistle();
        System.out.println("Numar vagoane: " + train.getNumberOfWagons());

        System.out.println("---");

        Plane plane = new Plane("Boeing 747", 900, 10000);
        plane.move();
        plane.land();
        System.out.println("Altitudine: " + plane.getAltitude() + "m");
    }
}
