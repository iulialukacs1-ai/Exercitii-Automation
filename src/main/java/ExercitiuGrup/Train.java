package ExercitiuGrup;

// =====================
//       TRAIN
// =====================
public class Train extends Transport {
    private int numberOfWagons;

    public Train(String name, int speed, int numberOfWagons) {
        super(name, speed);
        this.numberOfWagons = numberOfWagons;
    }

    @Override
    public void move() {
        System.out.println(name + " merge pe sine cu " + speed + " km/h");
    }

    // Metoda specifica
    public void whistle() {
        System.out.println(name + " fluiera: Tuuuut!");
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }
}
