package psrestassured.m5body;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ValidatableResponseBodyDemo {

    static final String BASE_URL = "https://api.github.com/";

    @Test
    void matcherExample() {

        RestAssured.get(BASE_URL)
                .then()
                .body("current_user_url", equalTo(BASE_URL + "user"))
                .body(containsString("feeds_url"))
                .body(containsString("feeds_url"), containsString("current_user_url"));
    }
}
