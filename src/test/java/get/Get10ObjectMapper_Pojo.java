package get;

import baseURL.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
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

    //ObjectMapper + Pojo = En İyi Yöntem


    @Test
    public void pojo01() {
        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expected data
        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(10,"quis eius est sint explicabo",true);

        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //do assertion
       JsonPlaceHolderPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
       assertEquals(200,response.statusCode());
       assertEquals(expectedData.getUserId(),actualData.getUserId());
       assertEquals(expectedData.getTitle(),actualData.getTitle());
       assertEquals(expectedData.getCompleted(),actualData.getCompleted());
    }
}
