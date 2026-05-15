package utils;
import config.TestConfig;
import data.TestData;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class TokenUtil {

        public static String getToken() {
            String body = "{\n" +
                    "\"username\": \"" + TestData.USERNAME + "\",\n" +
                    "\"password\": \"" + TestData.PASSWORD + "\"\n" +
                    "}";

            Response response = given()
                    .header("Content-Type", "application/json")
                    .body(body)
                    .when()
                    .post(TestConfig.DUMMY_DOMAIN + TestConfig.LOGIN_ENDPOINT);

            return response.jsonPath().getString("accessToken");
        }
    }

