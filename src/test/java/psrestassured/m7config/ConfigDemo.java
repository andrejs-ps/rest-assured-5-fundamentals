package psrestassured.m7config;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.config.FailureConfig.*;
import static io.restassured.config.FailureConfig.failureConfig;
import static io.restassured.config.RedirectConfig.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class ConfigDemo {

    static final String BASE_URL = "https://api.github.com/";

    @Test
    void failureConfigExample() {

        ResponseValidationFailureListener failureListener =
                (reqSpec, resSpec, response) ->
                        System.out.printf("We have a failure, " +
                                        "response status was %s and the body contained: %s",
                                response.getStatusCode(), response.body().asPrettyString());

        RestAssured.config = RestAssured.config()
                .failureConfig(failureConfig().failureListeners(failureListener));

        RestAssured.get(BASE_URL + "users/andrejs-ps")
                .then()
                .body("some.path", equalTo("a thing"));
    }


    @Test
    void maxRedirectsTest() {

        RestAssured.config = RestAssured.config()
                .redirect(redirectConfig().followRedirects(true).maxRedirects(0));

        RestAssured.get(BASE_URL + "repos/twitter/bootstrap")
                .then()
                .statusCode(equalTo(200));
    }
}
