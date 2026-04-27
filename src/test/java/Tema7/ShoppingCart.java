package Tema7;

public class ShoppingCart {

    double totalPrice;

    public ShoppingCart() {
        this.totalPrice = 0;
    }

    public void addProduct(double price) {
        totalPrice += price;
        System.out.println("Produs adăugat: " + price + " RON. Total: " + totalPrice + " RON");
    }

    public void removeProduct(double price) {
        if (totalPrice - price < 0) {
            System.out.println("Eroare: totalul nu poate deveni negativ! Total curent: " + totalPrice + " RON");
        } else {
            totalPrice -= price;
            System.out.println("Produs eliminat: " + price + " RON. Total: " + totalPrice + " RON");
        }
    }

    public double getTotal() {
        return totalPrice;
    }
}

