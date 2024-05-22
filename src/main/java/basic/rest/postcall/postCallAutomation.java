package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

public class postCallAutomation {
    @Test
    public void createBoard() {
        RestAssured.baseURI = "https://api.trello.com";
        String board_name = "My Board From API " + (int)(Math.random() * 100);
        System.out.println(board_name);

        given().
                queryParam("key", ""). // key from atlassian goes here.
                queryParam("token", ""). // token from atlassian goes here.
                queryParam("name", board_name).
                header("Content-Type", "application/json").
                when().
                post("/1/boards").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("name", equalTo(board_name));
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
