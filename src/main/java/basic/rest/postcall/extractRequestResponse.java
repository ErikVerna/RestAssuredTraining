package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

public class extractRequestResponse {
    @Test
    public void extractResponse() {
        RestAssured.baseURI = "https://api.github.com";
        String bearerToken = "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";

        String requestBody = "{\"name\":\"Api-testing-restcall-4\",\n" +
                "\"description\":\"Repository created via Rest Assured Call\",\n" +
                "\"homepage\":\"https://github.com\",\n" +
                "\"private\":false,\n" +
                "\"is_template\":true}";

       Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(requestBody).

                when().
                post("/user/repos").

                then()
                .assertThat().statusCode(201).and()
                .contentType(ContentType.JSON).
                extract().response();

       String jsonResponse = response.asString();

        JsonPath responseBody = new JsonPath(jsonResponse);

        System.out.println("Node Id: " + responseBody.get("node_id"));
        System.out.println("name: " + responseBody.get("name"));
        System.out.println("Full name: " + responseBody.get("full_name"));
//        System.out.println(response.asString());
    }
}