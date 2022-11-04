package get;

import baseURL.ReqresBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get06 extends ReqresBaseURL {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
              id si 3 ten kucuk olanların 2 tane oldugunu test et
    */

    @Test
    public void test01() {
        //set the url
        spec.pathParam("first","unknown");
        //set the expected data
        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //do assertion
        //Status code is 200
        assertEquals(200,response.statusCode());
        //Print all pantone_values
        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getList("data.pantone_value"));
        //Print all ids greater than 3 on the console
        List<Integer>ids=jsonPath.getList("data.findAll{it.id>3}.id");
        //Assert that there are 3 ids greater than 3
    }
}
