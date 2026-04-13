package Tema8;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Exercitiul 1
        Book book = new Book();

        book.setTitle("Harry Potter");
        book.setAuthor("J.K. Rowling");

        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());

        //Exercitiul 2
        System.out.println("---");
        Product product = new Product();

        // Valoare valida
        product.setName("Laptop");
        product.setPrice(2999.99);
        System.out.println("Name: " + product.getName());
        System.out.println("Price: " + product.getPrice());

        System.out.println("---");

        // Valoare invalida
        product.setPrice(-100);
        System.out.println("Pretul dupa set invalid: " + product.getPrice());

        System.out.println("---");

        // Valoare zero
        product.setPrice(0);
        System.out.println("Pretul dupa set zero: " + product.getPrice());

        //Exercitiul 3

        System.out.println("---");
        Device device = new Device ();
        device.powerOn();

        System.out.println("---");

        Phone phone = new Phone();
        phone.powerOn(); //mostenita din Device
        phone.call();//proprie din phone

        //Exercitiul 4
        System.out.println("---");

        Account account = new Account();
        account.setusername("ion444");
        System.out.println("Username: " + account.getusername());
        account.login();

        System.out.println("---");

        AdminAccount admin = new AdminAccount();
        admin.setusername("admin999");
        admin.login(); //mostenita din Account
        admin.deleteUser("ion444"); //proprie din AdminAccount

        //Exercitiul 5
        System.out.println("---");

        Course course = new Course("Java Basic", 40);
        course.displayInfo();

        System.out.println("---");

        OnlineCourse onlineCourse = new OnlineCourse("Selenium Testing", 60,"Udemy");
        onlineCourse.displayInfo();

        //Exercitiul 6
        System.out.println("---");
        Notification notification = new Notification();
        notification.send();

        System.out.println("---");
        EmailNotification email = new EmailNotification();
        email.setEmailAddress("test@yopmail.com");
        System.out.println("Email address: " + email.getEmailAddress());
        email.send();

        //Exercitiul 7
        System.out.println("---");
        Order order = new Order(1001);
        order.printOrder();

        System.out.println("---");

        OnlineOrder onlineOrder = new OnlineOrder(2002);
        onlineOrder.printOrder(); //mostenita din Order
        onlineOrder.trackOrder(); //proprie din OnlineOrder

        //access direct la orderID din Main
        System.out.println("Order ID din Main: " + onlineOrder.orderID);

        //Exercitiul 10
        // Creeaza lista de teste
        List<TestCase> tests = new ArrayList<>();
        tests.add(new LoginTest());
        tests.add(new SearchTest());

        // Ruleaza toate testele
        System.out.println("=== Starting Test Suite ===");
        for (TestCase test : tests) {
            test.runTest();
            System.out.println("---");
        }
        System.out.println("=== Test Suite Finished ===");
    }
}







