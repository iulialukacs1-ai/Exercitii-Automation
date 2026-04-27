package Tema7;

public class Temperature {

    double celsius;

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    public double toFahrenheit() {
        return celsius * 9.0 / 5.0 + 32;
    }

    public double toKelvin() {
        return celsius + 273.15;
    }
}
