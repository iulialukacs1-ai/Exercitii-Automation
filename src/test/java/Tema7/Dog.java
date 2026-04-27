package Tema7;

public class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void bark() {
        System.out.println("Câinele " + name + " latră");
    }

    public int getAgeInHumanYears() {
        return age * 7;
    }
}
