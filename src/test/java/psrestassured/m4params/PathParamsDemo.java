package psrestassured.m4params;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class PathParamsDemo {

    static final String REPO_EP = "https://api.github.com/repos";

    @Test
    void withoutParamHardcoded() {
        RestAssured
                .get(REPO_EP + "/andrejs-ps/automated-web-testing-in-java-with-playwright")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(412446871));

        RestAssured
                .get(REPO_EP + "/andrejs-ps/Getting-Started-With-TestNG")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(227642020));
    }


    static final String ANDREJS_PS = "/andrejs-ps";
    static final String REPO_PLAYWRIGHT = "/automated-web-testing-in-java-with-playwright";
    static final String REPO_TESTNG = "/Getting-Started-With-TestNG";


    @Test
    void withoutParamWithConcatenation() {

        RestAssured
                .get(REPO_EP + ANDREJS_PS + REPO_PLAYWRIGHT)
                .then()
                .statusCode(200)
                .body("id", equalTo(412446871));


        RestAssured
                .get(REPO_EP + ANDREJS_PS + REPO_TESTNG)
                .then()
                .statusCode(200)
                .body("id", equalTo(227642020));


        RestAssured
                .get(String.format("https://api.github.com/repos/%s/%s",
                        "andrejs-ps", "automated-web-testing-in-java-with-playwright"))
                .then()
                .statusCode(200);

    }


    @Test
    void withOverloadedGet() {
        RestAssured
                .get("https://api.github.com/repos/{user}/{repo}", "andrejs-ps", "automated-web-testing-in-java-with-playwright")
                .then()
                .statusCode(200)
                .body("id", equalTo(412446871));
    }


    @Test
    void withParam() {
        RestAssured
                .given()
                .pathParam("user", "andrejs-ps")
                .pathParam("repo_name", "automated-web-testing-in-java-with-playwright")
                .get(REPO_EP + "/{user}/{repo_name}")
                .then()
                .statusCode(200)
                .body("id", equalTo(412446871));
    }


    @Test
    void withParamAsMap() {

        Map<String, String> reusableMap = Map.of("user", "andrejs-ps",
                "repo_name", "automated-web-testing-in-java-with-playwright");
        RestAssured
                .given()
                .pathParams(reusableMap)
                .get(REPO_EP + "/{user}/{repo_name}")
                .then()
                .statusCode(200)
                .body("id", equalTo(412446871));
    }
}
