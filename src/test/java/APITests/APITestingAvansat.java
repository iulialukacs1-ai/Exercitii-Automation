package APITests;

import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.auth;
import static org.hamcrest.Matchers.equalTo;

public class APITestingAvansat {

    @Test
    public void dummyJsonLimit5() {
        given()
                .queryParam("limit", 5)
                .when()
                .get(TestConfig.DUMMY_DOMAIN + TestConfig.PRODUCTS_ENDPOINT)
                .then()
                .statusCode(200)
                .body("limit", equalTo(5));
    }

    @Test
    public void dummyJsonSearch() {
        given()
                .queryParam("q", "phone")
                .when()
                .get(TestConfig.DUMMY_DOMAIN + TestConfig.SEARCH_ENDPOINT)
                .then()
                .statusCode(200);
    }

    @Test
    public void courseNameAPIAutomation() {
        given()
                .header("Course-Name", "API Automation")
                .when()
                .get(TestConfig.HTTP_BIN_DOMAIN + TestConfig.HEADERS_ENDPOINT)
                .then().statusCode(200)
                .body("headers.Course-Name", equalTo("API Automation"));
    }

    @Test
    public void contentTypeVerification() {

        String payload = "{\n\t\"name\": \"Add your name in the body\"\n}";
        given()
                .header("Content-Type", "application/json")
                .when()
                .post(TestConfig.HTTP_BIN_DOMAIN + "/post")
                .then()
                .statusCode(200);

    }

    @Test
    public void basicAuth() {
        given()
                .auth()
                .basic("user", "passwd")
                .when()
                .get(TestConfig.HTTP_BIN_DOMAIN + "/basic-auth/user/passwd")
                .then()
                .statusCode(200);
    }
}
