package get;

import baseURL.HerokuappBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Get03 extends HerokuappBaseURL {

    /* Given
        https://restful-booker.herokuapp.com/booking/1
    When
        User send a GET Request to the url
    Then
        HTTP Status code should be 404
    And
        Status Line should be HTTP/1.1 404 Not Found
    And
        Response body contains "Not Found"
    And
        Response body does not contain "TechProEd"
    And
        Server is "Cowboy"
 */

    @Test
    public void name() {
        spec.pathParams("first","booking","second",1);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        response.getBody().prettyPrint();
        Assert.assertTrue(response.getBody().asString().contains("Not Found"));
        Assert.assertFalse(response.getBody().asString().contains("TechProEd"));
        Assert.assertEquals("Cowboy",response.getHeader("Server"));

    }
}
