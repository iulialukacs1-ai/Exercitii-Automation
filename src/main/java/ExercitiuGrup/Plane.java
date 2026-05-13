package ExercitiuGrup;

// =====================
//       PLANE
// =====================
public class Plane extends Transport {
    private int altitude;

    public Plane(String name, int speed, int altitude) {
        super(name, speed);
        this.altitude = altitude;
    }

    @Override
    public void move() {
        System.out.println(name + " zboara la " + altitude + "m altitudine cu " + speed + " km/h");
    }

    // Metoda specifica
    public void land() {
        System.out.println(name + " aterizeaza!");
    }

    public int getAltitude() {
        return altitude;
    }
}
