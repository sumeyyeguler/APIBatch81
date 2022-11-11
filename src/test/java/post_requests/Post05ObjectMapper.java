package post_requests;

import baseURL.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper extends JsonplaceholderBaseUrl {
     /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
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
    public void post01() throws IOException {
        //set the url
        spec.pathParam("first","todos");

        //set the expected data
/*
       String jsonInString="{\n" +
                "                                    \"userId\": 55,\n" +
                "                                    \"title\": \"Tidy your room\",\n" +
                "                                    \"completed\": false,\n" +
                "                                    \"id\": 201\n" +
                "                                    }";



 */
        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
       String jsonInString= obj.expectedDataInString(55,"Tidy your room",false);
        Map<String,Object>expectedData=new ObjectMapper().readValue(jsonInString, HashMap.class);

        //send the request get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //do assertion
        HashMap<String,Object>actualData=new ObjectMapper().readValue(response.asString(),HashMap.class);
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("tittle"),actualData.get("tittle"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));



    }
}
