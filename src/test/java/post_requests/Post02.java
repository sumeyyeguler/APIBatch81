package post_requests;

import baseURL.HerokuappBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuappTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02 extends HerokuappBaseURL {
       /*
        Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 5315,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2021-09-09",
                                                        "checkout": "2021-09-21"
                                                    }
                                                }
                                             }
     */

    @Test
    public void post01() {
        //set the url
        spec.pathParam("first","booking");

        //Set the expected Data
        HerokuappTestData herokuappTestData=new HerokuappTestData();
        Map<String,String>bookingdatesMap=herokuappTestData.bookingDatesDataInnerMapMethod("2021-09-09","2021-09-21");
       Map<String,Object> expectedData= herokuappTestData.expectedDataMapMethod("John","Doe",11111,true,bookingdatesMap);
        //send the request get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{first}");
        System.out.println("response = " + response);
        response.as(HashMap.class);
        //do assertion

    }
}
