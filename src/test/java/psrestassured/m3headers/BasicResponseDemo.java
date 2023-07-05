package psrestassured.m3headers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasicResponseDemo {

    static final String BASE_URL = "https://api.github.com";

    @Test
    void convenienceMethods() {
        Response response = RestAssured.get(BASE_URL);
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
    }

    @Test
    void genericHeader() {
        Response response = RestAssured.get(BASE_URL);

        assertEquals(response.getHeader("server"), "GitHub.com");
        assertEquals(response.getHeader("x-ratelimit-limit"), "60");

        // OR
        assertEquals(Integer.parseInt(response.getHeader("x-ratelimit-limit")), 60);
    }
}
