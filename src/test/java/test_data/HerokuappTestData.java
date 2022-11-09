package test_data;

import java.util.Map;

public class HerokuappTestData {
    /*{
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }

     */


    Map<String, Object> expectedDataMap;

    public Map<String, Object> expectedDataMapMethod(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingDatesDataInnerMapMethod) {
        expectedDataMap.put("firstname", firstname);
        expectedDataMap.put("lastname", lastname);
        expectedDataMap.put("totalprice", totalprice);
        expectedDataMap.put("depositpaid", depositpaid);
        expectedDataMap.put("bookingdates", expectadInnerMap);
        return expectedDataMap;
    }

    Map<String, String> expectadInnerMap;

    public Map<String, String> bookingDatesDataInnerMapMethod(String checkin, String checkout) {
        expectadInnerMap.put("checkin", checkin);
        expectadInnerMap.put("checkout", checkout);
        return expectadInnerMap;
    }
}
