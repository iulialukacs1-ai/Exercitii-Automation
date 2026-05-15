package Tema10;

import config.TestConfig;
import data.TestData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FakeStoreTests {

    @Test
    public static void getProductIDTest() {
        given()
                .when()
                .get(TestConfig.FAKE_STORE_API_DOMAIN + TestConfig.PRODUCTS_ENDPOINT + "/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("price", greaterThan(0.0f))
                .time(lessThan(3000L));
    }

    @Test
    public static void firstProductDetailsTest () {
        given()
                .when()
                .get(TestConfig.FAKE_STORE_API_DOMAIN +TestConfig.PRODUCTS_ENDPOINT)
                .then()
                .statusCode(200)
                .body(not(empty()))
                .body("[0].title", notNullValue())
                .body("[0].category", notNullValue())
                .body("[0].image", notNullValue())
                .time(lessThan(3000L));
    }

    @Test
    public static void postProductTest() {
        String payload = """
                {
                "title": "Automation Course Product",
                "price": 99.20,
                "description": "Created during API automation session",
                "image": "https://i.pravatar.cc",
                "category": "electronics"
}
""";
        given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post(TestConfig.FAKE_STORE_API_DOMAIN+ TestConfig.PRODUCTS_ENDPOINT)
                .then()
                .statusCode(201)
                .body("title", equalTo(TestData.PRODUCT_TITLE))
                .body("category", equalTo(TestData.PRODUCT_CATEGORY))
                .time(lessThan(3000L));

    }
}
