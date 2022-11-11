package post_requests;

import baseURL.HerokuappBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post04Pojo extends HerokuappBaseURL {
     /*
         Given
          1)  https://restful-booker.herokuapp.com/booking
          2)   {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 },
                 "additionalneeds": "Breakfast"
             }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
 		                            "bookingid": 16,
 		                            "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        },
                                        "additionalneeds": "Breakfast"
                                     }
                                  }
     */

    @Test
    public void post04pojo() {
        //set the url
        spec.pathParam("first","booking");
        //set the expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2021-09-21","2021-12-21");
        BookingPojo expectedData=new BookingPojo("Ali","Can",999,true,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        //send the request get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //do assertion
        BookingResponseBodyPojo actualDate=response.as(BookingResponseBodyPojo.class);
        System.out.println("actualDate = " + actualDate);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getFirstname(),actualDate.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(),actualDate.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(),actualDate.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualDate.getBooking().getDepositpaid());
        assertEquals(expectedData.getDepositpaid(),actualDate.getBooking().getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualDate.getBooking().getAdditionalneeds());
        assertEquals(bookingDatesPojo.getCheckin(),actualDate.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualDate.getBooking().getBookingdates().getCheckout());

    }
}
