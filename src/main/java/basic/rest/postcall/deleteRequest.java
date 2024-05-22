package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;
public class deleteRequest {
        public String baseUri = "https://api.github.com";
        public String bearerToken = ""; // this should be updated with a new token using the GitHub token generator.

        public String repoName;
        @Test
        public void createRepo() {
            RestAssured.baseURI = baseUri;


            String requestBody = "{\"name\":\"Api-testing-restcall-3\",\n" +
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

            repoName = responseBody.get("full_name");
        }
        @Test
        public void deleteRepo(){
        RestAssured.baseURI = baseUri;

        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken).
                when().
                delete("/repos/" + repoName).
                then()
                .assertThat().statusCode(204);

            System.out.println("Repository Delete: " + repoName);
    }
    }



