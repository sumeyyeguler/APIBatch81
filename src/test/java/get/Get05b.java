package get;

import baseURL.ReqresBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get05b extends ReqresBaseURL {
     /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void test01() {
        //set the url
        spec.pathParams("first", "unknown", "second", 3);
        //set the expected data
        //send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //do assertion
        //response.then().statusCode(200);
        //assertEquals(200,response.statusCode());
       /* response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id",equalTo(3)
                ,"data.name",equalTo("true red")
                ,"data.year",equalTo(2002)
                ,"data.color",equalTo("#BF1932")
                ,"data.pantone_value",equalTo("19-1664")
                ,"support.url",equalTo("https://reqres.in/#support-heading")
                ,"support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
       -bu haliyle yapmıs olmam soft asserttur(tek bir body icine alarak), soft assert objesi olusturarakta yapabiliriz
       -body methodunda kontrol etmek amacıyla kullanıyoruz fakat icindeki datalara ulasıp kullanamıyorum
       -bunun icin jsonPath data formatına donusturmem gerekiyor.
        */

        //Do assertion
        SoftAssert softAssert=new SoftAssert();
        JsonPath jsonPath=response.jsonPath();
        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(jsonPath.getInt("data.id"),3,"id degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.name"),"true red","name degeri dogru degil");
        softAssert.assertEquals(jsonPath.getInt("data.year"),2002,"year degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932","color degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"),"19-1664","pantone_value degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading","url degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!","url degeri dogru degil");
        softAssert.assertAll();
    }
}
