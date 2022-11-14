package sum;

import baseURL.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Third_way extends JsonplaceholderBaseUrl {
    //response.as(HashMap.class);

    //De-Serialization: Json datayı Java objesine çevirme
    //Serialization: Java objesini Json formatına çevirme.
    //De-Serialization: Iki türlü yapacağız.
    //Gson: Google tarafından üretilmiştir.
    //Object Mapper: Daha popüler...

      /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void test01() {
        //set the url
        spec.pathParams("first","todos","second",2);

        //set the expected data/payload
        //keyler string valuelar ise hem string hemde int oldugu icin value kısmını object sectik
        //object'in dezavantajı; manipulation yapamayız, bizi kısıtlıyor.
        //map'in icine datayi put ile koyuyoruz.
        //expectedData'da map'i json formatına benzetip,response'dan gelen formatıda map'e cevirerek karsilastirmalar,assertionlar yapacagız.
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println("expectedData = " + expectedData);
        //{id=2, completed=false, userId=1, tittle=quis ut nam facilis et officia qui}  hashMap sıra gozetmedigi icin hizlidir.

        //send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion
        //response'u Map e ceviriyoruz
        Map<String, Object> actualData = response.as(HashMap.class);//json formatı Map'e donusturduk- De-Serialization
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals("1.1 vegur", response.header("Via"));
        assertEquals("cloudflare", response.header("Server"));
        assertEquals(200, response.statusCode());


    }
}
