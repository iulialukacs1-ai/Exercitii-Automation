package Tema7;

public class BankAccount {

    String ownerName;
    double balance;

    public BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depunere: " + amount + " RON. Sold nou: " + balance + " RON");
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Fonduri insuficiente! Sold disponibil: " + balance + " RON");
        } else {
            balance -= amount;
            System.out.println("Retragere: " + amount + " RON. Sold nou: " + balance + " RON");
        }
    }

    public void displayBalance() {
        System.out.println("Contul lui " + ownerName + " → Sold: " + balance + " RON");
    }
}

