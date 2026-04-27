package Tema7;

public class Main {

        public static void main(String[] args) {

            // ===== EXERCITIUL 1: Dog =====
            System.out.println("===== EXERCITIUL 1: Dog =====");

            Dog dog1 = new Dog("Rex", 3);
            Dog dog2 = new Dog("Bella", 5);

            dog1.bark();
            System.out.println(dog1.name + " are " + dog1.getAgeInHumanYears() + " ani în ani umani");

            dog2.bark();
            System.out.println(dog2.name + " are " + dog2.getAgeInHumanYears() + " ani în ani umani");

            // ===== EXERCITIUL 2: BankAccount =====
            System.out.println("\n===== EXERCITIUL 2: BankAccount =====");

            BankAccount cont = new BankAccount("Ion Popescu", 500);
            cont.displayBalance();
            cont.deposit(300);
            cont.deposit(200);
            cont.withdraw(400);
            cont.withdraw(1000);
            cont.displayBalance();

            // ===== EXERCITIUL 3: Temperature =====
            System.out.println("\n===== EXERCITIUL 3: Temperature =====");

            Temperature temp = new Temperature(100);
            System.out.println(temp.celsius + "°C = " + temp.toFahrenheit() + "°F");
            System.out.println(temp.celsius + "°C = " + temp.toKelvin() + " K");

            Temperature temp2 = new Temperature(0);
            System.out.println(temp2.celsius + "°C = " + temp2.toFahrenheit() + "°F");
            System.out.println(temp2.celsius + "°C = " + temp2.toKelvin() + " K");

            // ===== EXERCITIUL 4: Employee =====
            System.out.println("\n===== EXERCITIUL 4: Employee =====");

            Employee emp1 = new Employee("Maria Ionescu", 4000);
            Employee emp2 = new Employee("Andrei Popa", 5500);

            System.out.println(emp1.name + " → Salariu initial: " + emp1.getSalary() + " RON");
            System.out.println(emp2.name + " → Salariu initial: " + emp2.getSalary() + " RON");

            emp1.increaseSalary(10);

            System.out.println(emp1.name + " → Salariu final: " + emp1.getSalary() + " RON");
            System.out.println(emp2.name + " → Salariu final: " + emp2.getSalary() + " RON");

            // ===== EXERCITIUL 5: ShoppingCart =====
            System.out.println("\n===== EXERCITIUL 5: ShoppingCart =====");

            ShoppingCart cart = new ShoppingCart();
            cart.addProduct(150.0);
            cart.addProduct(89.99);
            cart.addProduct(45.50);
            cart.removeProduct(89.99);
            cart.removeProduct(500.0);
            System.out.println("Total final în coș: " + cart.getTotal() + " RON");
        }
    }

