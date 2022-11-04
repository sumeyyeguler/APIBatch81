package get;

import baseURL.ReqresBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get02b extends ReqresBaseURL {
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

    //server'a headers'tan ulaşıyoruz.


    @Test
    public void get02() {
        //Set the URL
        spec.pathParams("first","users","second",23);
        //Set the expected data
        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Do assertion  (assertion'u assertEquals, assertTrue ya da response üuzerinden de yapabiliriz.)
        //System.out.println(response.statusCode()); 404
        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare",response.getHeader("Server"));
        //getHeader() ve header() aynı sonucu verir.
        assertEquals(2,response.asString().replaceAll("\\s","").length());

    }
}
