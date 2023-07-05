package psrestassured.m6crud;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class OtherMethodsDemo {

    static final String REPOS_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "your token goes here ";

    @Test(description = "Create a repo")
    void postTest() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
//                    .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"deleteme\"}")
                .when()
                    .post(REPOS_EP)
                .then()
                .statusCode(201);
    }

    @Test(description = "Update a repo")
    void patchTest() {
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"deleteme-patched\"}")
                .when()
                    .patch("https://api.github.com/repos/andrejs-ps/deleteme")
                .then()
                .statusCode(200);
    }

    @Test(description = "Delete a repo")
    void deleteTest() {
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                .when()
                    .delete("https://api.github.com/repos/andrejs-ps/deleteme-patched")
                .then()
                    .statusCode(204);
    }
}
