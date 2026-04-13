package Inheritance;

public class Student extends Person {
    private int grade;
    private String name;
    private int age;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;

    }

    public void displayStudentInfo() {
        System.out.println("Grade " + this.grade);

    }

    public int getGrade() {
        return grade;
    }
}
