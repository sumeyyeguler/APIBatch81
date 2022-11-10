package patch_request;

import baseURL.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonplaceholderBaseUrl {
    //kısmi güncelleme

    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */

    @Test
    public void patch01() {
        //set the url
        spec.pathParams("first","todos","second","198");

        //set the expected data
        JsonPlaceHolderTestData jsonPlaceHolderTestData=new JsonPlaceHolderTestData();
        Map<String,Object> expectedDataMap=jsonPlaceHolderTestData.expectedDataMethod(null,"Wash the dishes",null);
        System.out.println("expectedDataMap = " + expectedDataMap);

        //send the request get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).patch("/{first}/{second}");
        response.prettyPrint();

        //do assertion
        Map<String,Object>actualDataMap=response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);
        assertEquals(200,response.statusCode());
        assertEquals(expectedDataMap.get("tittle"),actualDataMap.get("tittle"));
    }
}
