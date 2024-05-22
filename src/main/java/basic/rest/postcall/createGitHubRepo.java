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
        String bearerToken = "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";

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
