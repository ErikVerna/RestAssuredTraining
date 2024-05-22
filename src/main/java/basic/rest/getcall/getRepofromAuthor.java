package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class getRepofromAuthor {

    @Test
    public void getRepoGitHub() {
        RestAssured.baseURI = "https://api.github.com";
        Response response = given().
                param("token", "").log().params(). // remember to put the token from GitHub here
                when().
                get("/users/ErikAPIdummy/repos").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().extract().response();

        String jsonResponse = response.asString();
        JsonPath responseBody = new JsonPath(jsonResponse);

        System.out.println("0th Index Repository: " + responseBody.get("[0].name"));
        System.out.println("1st Index Repository: " + responseBody.get("[1].name"));
    }
}
