package Tema10;

import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DummyJsonTests {

    @Test
    public static void getProductLimit() {
        given()
                .queryParam("limit", 5)
                .when()
                .get(TestConfig.DUMMY_DOMAIN + TestConfig.PRODUCTS_ENDPOINT)
                .then()
                .statusCode(200)
                .body("limit", equalTo(5))
                .body("products.size()", equalTo(5))
                .time(lessThan(3000L));

    }

    @Test
    public static void searchProductsTest() {
        given()
                .queryParam("q", "phone")
                .when()
                .get(TestConfig.DUMMY_DOMAIN+ TestConfig.PRODUCTS_ENDPOINT + "/search")
                .then()
                .statusCode(200)
                .body("products", not(empty()))
                .body("products[0].title", notNullValue())
                .body("products[0].price", greaterThan(0.0f))
                .time(lessThan(3000L));

    }
}
