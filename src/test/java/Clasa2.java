import org.testng.annotations.*;

public class Clasa2  {

    @BeforeGroups("smoke")
    public void setup (){
        System.out.println("Clasa 2 setup");


    }
    @AfterGroups ("regression")
    public void tearDown (){
        System.out.println("Clasa 2 tearDown");

    }

@Test(groups = {"regression"})
public void clasa2Test1 (){

}

@Test(groups = {"smoke"})
public void clasa2Test2 (){

}
@Test(groups = {"regression","slow"})
public void clasa2Test3 (){

}
}
