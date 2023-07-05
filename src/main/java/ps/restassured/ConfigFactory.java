package ps.restassured;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.listener.ResponseValidationFailureListener;

import static io.restassured.config.FailureConfig.failureConfig;
import static io.restassured.config.RedirectConfig.*;

public class ConfigFactory {

    public static RestAssuredConfig getDefaultConfig() {

        ResponseValidationFailureListener failureListener =
                (reqSpec, resSpec, response) ->
                        System.out.printf("We have a failure, " +
                                        "response status was %s and the body contained: %s",
                                response.getStatusCode(), response.body().asPrettyString());

        return RestAssured.config()
                .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL))
                .redirect(redirectConfig().maxRedirects(1))
                .failureConfig(failureConfig().failureListeners(failureListener));
    }
}
