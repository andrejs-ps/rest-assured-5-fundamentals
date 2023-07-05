package psrestassured.m7config;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GlobalVariablesDemo {

    @BeforeSuite
    void setup() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/users";
        RestAssured.rootPath = "data";
    }

    @Test
    void testOneUsingGlobalConstants() {

        RestAssured.get()
                .then()
                .body("id[0]", equalTo(1));
    }

    @Test
    void testTwoUsingGlobalConstants() {

        RestAssured.get()
                .then()
                .body("id[1]", equalTo(2));
    }
}
