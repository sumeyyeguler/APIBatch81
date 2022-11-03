package get;

import baseURL.ReqresBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get02 extends ReqresBaseURL {
      
    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void test() {
        spec.pathParams("first", "users", "second", 23);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        assertEquals("cloudflare", response.getHeader("Server"));
        assertEquals(2, response.asString().replaceAll("\\s","").length());

    }
}
