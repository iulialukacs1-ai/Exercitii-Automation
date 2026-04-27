package Tema7;

public class Employee {

        String name;
        double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public void increaseSalary(double percent) {
            double majorare = salary * percent / 100;
            salary += majorare;
            System.out.println("Salariul lui " + name + " a crescut cu " + percent + "%. Salariu nou: " + salary + " RON");
        }

        public double getSalary() {
            return salary;
        }
    }

