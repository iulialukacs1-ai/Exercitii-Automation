package ExercitiuGrup;

// =====================
//        CAR
// =====================
public class Car extends Transport {
    private int numberOfWheels;

    public Car(String name, int speed, int numberOfWheels) {
        super(name, speed);
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public void move() {
        System.out.println(name + " conduce pe sosea cu " + speed + " km/h");
    }

    // Metoda specifica
    public void honk() {
        System.out.println(name + " claxoneaza: Beeep!");
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}