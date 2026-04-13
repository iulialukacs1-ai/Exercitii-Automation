package Tema8;

public class Product {

    private String name;
    private double price;

    // Getteri
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Setteri
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Pret invalid! Pretul trebuie sa fie mai mare decat 0.");
        }

    }
}
