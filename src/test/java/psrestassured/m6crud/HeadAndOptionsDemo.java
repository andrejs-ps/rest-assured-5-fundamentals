package psrestassured.m6crud;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;


public class HeadAndOptionsDemo {

    static final String BASE_URL = "https://api.github.com/";

    @Test
    void headTest() {
            RestAssured.head(BASE_URL)
                    .then()
                    .statusCode(200)
                    .body(emptyOrNullString());
    }

    @Test
    void optionsTest() {
        RestAssured.options(BASE_URL)
                .then()
                .statusCode(204)
                .header("access-control-allow-methods", equalTo("GET, POST, PATCH, PUT, DELETE"))
                .body(emptyOrNullString());
    }
}
