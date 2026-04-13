public class Car {
    static String brand = "vw";
    static String model;
    static boolean isSport;
    int year;

    // GRESEALA 1: parametrii constructorului trebuie sa aiba tip SI nume
    // GRESEALA 2: constructorul nu folosea parametrii, ci tot variabilele clasei
    public Car(String brand, String model, boolean isSport) {
        this.brand = brand;
        this.model = model;
        this.isSport = isSport; // GRESEALA 3: era hardcodat "true" in loc de parametru
    }

    // GRESEALA 4: "maine" in loc de "main"
    public static void main(String[] args) {
        System.out.println(brand);
        System.out.println(model);
        int year = 0;
        System.out.println(year);

        if (isSport) {
            System.out.println("Este masina sport");
        } else {
            System.out.println("Nu este masina sport");
        }

        // GRESEALA 5: new Car() fara parametrii, dar constructorul cere 3 parametri
        Car c1 = new Car("BMW", "X5", true);
        c1.year = 2019;

        System.out.println(c1.brand);
        System.out.println(c1.model);
        System.out.println(c1.year);
        System.out.println(c1.isSport);
    }
}
