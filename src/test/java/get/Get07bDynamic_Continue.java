package get;

import baseURL.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get07bDynamic_Continue extends GoRestBaseUrl {
    //DYNAMIC

        /*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
      {
    "meta": null,
    "data": {
        "id": 2986,
        "name": "Brijesh Kocchar",
        "email": "kocchar_brijesh@prosacco.com",
        "gender": "female",
        "status": "active"
    }
}
     */

    @Test
    public void test01() {
        //set the url
        spec.pathParams("first", "public", "second", "v1", "third", "users", "fourth", 2986);
        //Set The Expected Data ==> Payload(API'e gonderilecek olan veri)
        //oncelikle inner dataları yapıyoruz.
        GoRestTestData goRestTestData = new GoRestTestData();
        Map<String, String> innerDataMap = goRestTestData.innerMapDataMethod("Shanti Deshpande DVM", "deshpande_dvm_shanti@funk.io", "male", "inactive");

        Map<String, Object> expectedDataMap = goRestTestData.expectedData(null, innerDataMap);


        //Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{fourth}");
        response.prettyPrint();

        //do assertion
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedDataMap.get("meta"), actualDataMap.get("meta"));
        assertEquals(innerDataMap.get("name"), ((Map) (actualDataMap.get("data"))).get("name"));
        assertEquals(innerDataMap.get("email"), ((Map) (actualDataMap.get("data"))).get("email"));
        assertEquals(innerDataMap.get("gender"), ((Map) (actualDataMap.get("data"))).get("gender"));
        assertEquals(innerDataMap.get("status"), ((Map) (actualDataMap.get("data"))).get("status"));


    }
}
