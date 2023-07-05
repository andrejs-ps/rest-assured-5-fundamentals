package psrestassured.m5body;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class DefaultParserDemo {

    static final String BASE_URL = "https://api.github.com/";

    @Test
    void parserAndSyntacticSugar() {

        RestAssured.given()
                .get(BASE_URL)
                .then()
                .using()
                    .defaultParser(Parser.XML)
                .body("current_user_url", equalTo(BASE_URL + "user"));
    }
}
