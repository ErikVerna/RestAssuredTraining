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
