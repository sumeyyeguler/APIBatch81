package get;

import baseURL.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10ObjectMapper_Map extends JsonplaceholderBaseUrl {
     /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void ObjectMapper01() {
        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expected data
     String expectedDataInString=  new JsonPlaceHolderTestData().expectedDataInString(10,"quis eius est sint explicabo",true);

     Map expectedData=ObjectMapperUtils.convertJsonToJava(expectedDataInString, Map.class);

     //send the request get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //do assertion
        Map actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
    }
}
