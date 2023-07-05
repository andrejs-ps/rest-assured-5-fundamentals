package psrestassured.m8codeorg.ratelimit;

import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.DEFAULT_PATH;
import static io.restassured.RestAssured.DEFAULT_URI;

public class BaseRateLimit {

    @BeforeMethod
    void setup() {
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.basePath = "/rate_limit";
    }

    @AfterMethod
    void cleanup() {
        RestAssured.baseURI = DEFAULT_URI;
        RestAssured.basePath = DEFAULT_PATH;
    }
}
