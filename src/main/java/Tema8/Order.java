package Tema8;

public class Order {
    protected int orderID;

    public Order (int orderID) {
        this.orderID = orderID;
    }
    public void printOrder() {
        System.out.println("Order ID: " + orderID);
    }
}
