package basic.rest.JSONResponseValidation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class handleJSONarray {
    @Test
    public void verifyResponseBody() {
        RestAssured.baseURI = "https://api.trello.com";
       Response response = given().
                param("key", ""). // key from atlassian goes here
                param("token", "").log().params(). //token from atlassian goes here
                when().
                get("/1/boards/L4ope4IX").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().extract().response();

       String jsonResponse = response.asString();
        JsonPath responseBody = new JsonPath(jsonResponse);

//        System.out.println("" + responseBody.get("name"));
//        System.out.println("Pref: " + responseBody.get("prefs"));
//        System.out.println("Background ID: " + responseBody.get("prefs.background"));
//        System.out.println("Background url: " + responseBody.get("prefs.backgroundImage"));
//        System.out.println("Background url Scaled: " + responseBody.get("prefs.backgroundImageScaled[4].url"));

        int backgroundSize = responseBody.getInt("prefs.backgroundImageScaled.size()");

        for (int i = 0; i < backgroundSize; i++) {

            int width = responseBody.get("prefs.backgroundImageScaled["+i+"].width");
            int height = responseBody.get("prefs.backgroundImageScaled["+i+"].height");

            System.out.println("Background Width at "+ i + " is : "+ width + " + and Height is: " + height);

        }
    }
    @Test
    public void verifyResponseHeader() {
        RestAssured.baseURI = "https://api.trello.com";
        given().
                param("key", ""). // key from atlassian goes here.
                param("token", ""). //token from atlassian goes here
                when().
                get("/1/boards/L4ope4IX").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
               header("Strict-Transport-Security", "max-age=63072000; preload").and().
                header("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");

    }
}