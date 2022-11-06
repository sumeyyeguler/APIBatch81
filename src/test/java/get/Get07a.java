package get;

import baseURL.HerokuappBaseURL;
import baseURL.ReqresBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get07a extends HerokuappBaseURL {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/91
        When
            I send GET Request to the url
        Then
            Response body should be like that;
             {
            "firstname": "Sally",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2013-02-23",
                "checkout": "2014-10-23"
            },
            "additionalneeds": "Breakfast"
            }
     */

    @Test
    public void test01() {
        //set the url
        spec.pathParams("first","booking","second",91);
        //Set The Expected Data ==> Payload
        //aslında get icin boyle birseye gerek yok, bunu body ile yapabiliriz. fakat put ve post'ta bunları kullanacagız
        //expected data olustururken once innerdan baslamamiz gerekir(bookingdate)
        Map<String,String> bookingDatesMap=new HashMap<>();
        bookingDatesMap.put("checkin","2013-02-23");
        bookingDatesMap.put("checkout","2014-10-23");

        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("firstname","Sally");
        expectedData.put("lastname","Brown");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingDatesMap);
        expectedData.put("additionalneeds","Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingDatesMap.get("checkin"), ((Map)(actualData.get("bookingdates"))).get("checkin"));//Key-Value ikilileri String-Object şeklinde olduğundan, Bookingdata value kısmını casting ile Map yaptık.
        assertEquals(bookingDatesMap.get("checkout"), ((Map)(actualData.get("bookingdates"))).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));
    }
}
