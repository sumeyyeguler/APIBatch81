package get;

import baseURL.HerokuappBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04b extends HerokuappBaseURL {
    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
            //bu url'de soru isaretinden sonrası sorgudur,
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

     */

    @Test
    public void name() {

        //set the url
        spec.pathParam("firs","booking").queryParams("firstname","Almedin","lastname","Alikadic");
        //set the expected data
        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //do assertion


    }
}
