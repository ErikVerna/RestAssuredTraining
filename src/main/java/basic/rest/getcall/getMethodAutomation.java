package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

public class getMethodAutomation {

    public static String baseUri = "https://api.trello.com";

    public static void main(String[] args){
        RestAssured.baseURI = baseUri;

        given().
                param("key", ""). //the key goes here
                param("token",""). // the token goes here
                when().
                get("/1/boards/L4ope4IX").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("name", equalTo("Postman Testing 1")).and().
                body("desc", equalTo("Testing description of the board"));

        System.out.println("This First Get Automation Call.");
        System.out.println("Get Call, Executed Successfully");
    }
}