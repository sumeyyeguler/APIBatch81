package get;

import baseURL.ReqresBaseURL;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Get06a extends ReqresBaseURL {
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
        Map<String,Object>expectedData=new HashMap<>();
        //keyler string valuelar ise hem string hemde int oldugu icin value kısmını object sectik
        //object'in dezavantajı; manipulation yapamayız, bizi kısıtlıyor.
        //map'in icine datayi put ile koyuyoruz.
        //expectedData'da map'i json formatına benzetip,response'dan gelen formatıda map'e cevirerek karsilastirmalar,assertionlar yapacagız.
        expectedData.put("userId",1);
        expectedData.put("id",2);
    }
}
