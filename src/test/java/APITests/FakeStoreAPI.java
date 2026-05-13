package APITests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FakeStoreAPI {

    @Test
    public void products1Test() {
        given()
                .when()
                .get("https://fakestoreapi.com/products/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue());
    }

    @Test

    public void product2Test() {
        given()
                .when()
                .get("https://fakestoreapi.com/products/2")
                .then()
                .statusCode(200)
                .body("price", greaterThan(0.0f))
                .body("category", notNullValue())
                .body("description", not(emptyOrNullString()));
    }

    @Test
    public void postProductTest() {
        String title = "Automation Course Product";  // fix 1 - title corect
        double price = 99.20;
        String category = "electronics";

        String payload = "{\n" +
                "\"title\" : \"" + title + "\",\n" +
                "\"price\" : " + price + ",\n" +
                "\"description\" : \"Created during API automation session\",\n" +
                "\"image\" : \"https://i.pravatar.cc\",\n" +
                "\"category\" : \"" + category + "\"\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(payload)  // fix 2 - folosesti payload-ul construit
                .when()
                .post("https://fakestoreapi.com/products")
                .then()
                .statusCode(201)
                .body("title", equalTo("Automation Course Product"));
    }

    @Test
    public void responseTimeTest() {
        given()
                .when()
                .get("https://fakestoreapi.com/products")
                .then()
                .statusCode(200)
                .time(lessThan(3000L));
    }

  @Test
    public void productNotExisting() {
        given()
                .header("Accept", "application/json")
                .when()
                .get("https://fakestoreapi.com/products/999")
                .then()
                .statusCode(200)
                .body(emptyString());



    }
}





