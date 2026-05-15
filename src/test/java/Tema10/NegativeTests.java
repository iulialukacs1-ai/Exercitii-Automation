package Tema10;

import config.TestConfig;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class NegativeTests {

    // Test negativ 1 - produs inexistent
    @Test
    public void productNotFoundTest() {
        given()
                .header("Accept", "application/json")
                .when()
                .get(TestConfig.FAKE_STORE_API_DOMAIN + TestConfig.PRODUCTS_ENDPOINT + "/999")
                .then()
                .statusCode(200)
                .body(emptyString());
    }

    // Test negativ 2 - login cu parola gresita
    @Test
    public void invalidLoginTest() {
        String payload = "{\n" +
                "\"username\": \"emilys\",\n" +
                "\"password\": \"parolaGresita\"\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(TestConfig.DUMMY_DOMAIN + "/auth/login")
                .then()
                .statusCode(400)
                .body("message", notNullValue());
    }

    // Test negativ 3 - token invalid
    @Test
    public void invalidTokenTest() {
        given()
                .header("Authorization", "Bearer tokenInvalid123")
                .when()
                .get(TestConfig.DUMMY_DOMAIN + "/auth/me")
                .then()
                .statusCode(401)
                .body("message", notNullValue());
    }
}