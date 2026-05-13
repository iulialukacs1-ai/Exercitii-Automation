package ExercitiuGrup;

public class Transport {
    protected String name;
    protected int speed;

    public Transport(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void move() {
        System.out.println(name + " se misca cu " + speed + " km/h");
    }
}
