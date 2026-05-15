package Tema10;

import config.TestConfig;
import data.TestData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class BinTests {

    @Test

    public static void customHeaderTest() {
        given()
                .header(TestData.COURSE_HEADER_NAME, TestData.COURSE_HEADER_VALUE)
                .when()
                .get(TestConfig.HTTP_BIN_DOMAIN + "/headers")
                .then()
                .statusCode(200)
                .body("headers.Course-Name", equalTo(TestData.COURSE_HEADER_VALUE))
                .time(lessThan(3000L));
    }

    @Test
    public static void basicAuthTest() {
        given()
                .auth()
                .basic("user", "passwd")
                .when()
                .get(TestConfig.HTTP_BIN_DOMAIN + "/basic-auth/user/passwd")
                .then()
                .statusCode(200)
                .body("authenticated" , equalTo(true))
                .time(lessThan(3000L));

    }
}
