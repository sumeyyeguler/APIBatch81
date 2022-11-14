package sum;

import baseURL.ReqresBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class One_way extends ReqresBaseURL {
    /*
    1) response.body(path,Hamcrest Matchers(hasItem(),...))
     */

    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void test01() {

        //set the url
        spec.pathParams("first","users","second",2);
        //set the expected data
        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //do assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email",equalTo("janet.weaver@reqres.in")
                        ,"data.first_name",equalTo("Janet")
                        ,"data.last_name",equalTo("Weaver")
                        ,"support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        //body methodu jason datayı kullanabilecegim hale donusturuyor
        //hard assert icin 2 body, soft assert icin tek bodyde yapmak yeterlidir(fail olan olsa bile sonraki assertionı kontrol edecektir).
    }
}
