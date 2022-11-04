package get;

import baseURL.HerokuappBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get04b extends HerokuappBaseURL {
    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Dane&lastname=Combs
            //bu url'de soru isaretinden sonrası sorgudur,
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Dane" and lastname is "Combs"
    "firstname": "Dane",
    "lastname": "Combs",
     */

    @Test
    public void name() {

        //set the url
        spec.pathParam("first","booking").queryParams("firstname","Dane","lastname","Combs");
        //set the expected data
        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //do assertion
        assertEquals(200,response.statusCode());
        //response.then().statusCode(200);
        //response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));



    }
}
