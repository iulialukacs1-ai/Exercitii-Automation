package Tema10;

import config.TestConfig;
import org.testng.annotations.Test;
import utils.TokenUtil;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

public class AuthTests {

    @Test
    public static  void loginAndGetProfileTest () {
        String token = TokenUtil.getToken();
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(TestConfig.DUMMY_DOMAIN + TestConfig.AUTH_ME_ENDPOINT)
                .then()
                .statusCode(200)
                .body("username", notNullValue())
                .body("email" ,notNullValue())
                .time(lessThan(3000L));


    }
}
