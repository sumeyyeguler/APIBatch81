package post_requests;

import baseURL.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonplaceholderBaseUrl {
      /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01() {
        //Set the Url
        spec.pathParam("first", "todos");

        //Set the expected Data
        JsonPlaceHolderTestData jsonPlaceHolderTestData=new JsonPlaceHolderTestData();
        Map<String,Object>expectedDataMap =jsonPlaceHolderTestData.expectedDataMethod(55,"Tidy your room",false);

        //Send the Request and Get the response
        //body'e java turunde bir map giriyoruz ve json turune cevirerek sorgu yapıyor (serialization)
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}");
        response.prettyPrint();

        //do assertion
        Map<String,Object>actualData=response.as(HashMap.class);

        assertEquals(expectedDataMap.get("completed"),actualData.get("completed"));
        assertEquals(expectedDataMap.get("tittle"),actualData.get("tittle"));
        assertEquals(expectedDataMap.get("userId"),actualData.get("userId"));
    }
}
