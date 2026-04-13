package Tema8;

public class OnlineOrder extends  Order{
    public OnlineOrder(int orderID) {
        super(orderID);
    }

    public void trackOrder() {
        // acces direct la orderId pentru ca e protected
        System.out.println("Tracking order: " + orderID);
    }
}
