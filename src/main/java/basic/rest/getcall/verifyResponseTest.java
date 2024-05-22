package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

public class verifyResponseTest {
    @Test
    public void verifyResponseBody() {
        RestAssured.baseURI = "https://api.trello.com";
        given().
                param("key", ""). // key from atlassian goes here
                param("token", "").log().params(). // token from atlassian goes here
                when().
                get("/1/boards/L4ope4IX").
                then().log().body().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("name", equalTo("Postman Testing 1")).and().
                body("desc", equalTo("Testing description of the board"));

    }
    @Test
    public void verifyResponseHeader() {
        RestAssured.baseURI = "https://api.trello.com";
        given().
                param("key", ""). // key from atlassian
                param("token", ""). // token from atlassian
                when().
                get("/1/boards/L4ope4IX").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
               header("Strict-Transport-Security", "max-age=63072000; preload").and().
                header("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");

    }
}