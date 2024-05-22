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
                param("key", "e82bbe4b751afbe94c23e21ae91197f6").
                param("token", "ATTA14155fb8bc911d717542b55c5c5a02c8ce72bc8ee1a51f143d8f4ccf3c1474a28A71F7C3").
                when().
                get("/1/boards/L4ope4IX").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
               header("Strict-Transport-Security", "max-age=63072000; preload").and().
                header("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");

    }
}