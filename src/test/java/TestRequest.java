import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TestRequest {
    @Test
    public void test_get(){
baseURI = "https://reqres.in";
        given().param("page", 2).get("api/users").
                then().body("data.id[1]", equalTo(8)).
                body("data.last_name",hasItems("Lawson","Ferguson", "Funke")).
                statusCode(200).log().all();

    }

}
