import com.github.dockerjava.api.model.PeerNode;

public class Person {

    String name;
    int age;

    public Person(String nameParam, int ageParam) {
        this.name = nameParam;
        this.age = ageParam;
    }

    public  void  dsplayInfo() {
        System.out.println(this.name +" are " + this.age+ " ani.");

    }


    public static void main (String []args){
        Person p1 = new Person("Gratiela", 28);

        //p1.name = "Gratiela";
        //p1.age = 28;

        Person p2 = new Person("Horatiu", 25);

        //p2.name = "Horatiu";
        //p2.age = 25;

        p1.dsplayInfo();
        p2.dsplayInfo();
    }
}

