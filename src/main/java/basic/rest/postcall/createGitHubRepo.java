package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

public class createGitHubRepo {
    @Test
    public void createRepository() {
        RestAssured.baseURI = "https://api.github.com";
        String bearerToken = ""; // token from GitHub goes here.

        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body("{\"name\":\"Api-testing-restcall\",\n" +
                        "\"description\":\"Repository created via Rest Assured Call\",\n" +
                        "\"homepage\":\"https://github.com\",\n" +
                        "\"private\":false,\n" +
                        "\"is_template\":true}").
                when().
                post("/user/repos").
                then().
                assertThat().statusCode(201).and().
                contentType(ContentType.JSON).and().
                body("name", equalTo("Api-testing-restcall")).and()
                .body("description", equalTo("Repository created via Rest Assured Call"));

        System.out.println("Completed Create repo Test case");
    }
}
