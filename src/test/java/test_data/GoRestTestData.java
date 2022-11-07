package test_data;

import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {


    Map<String, String> innerDataMap;

    public Map<String, String> innerMapDataMethod(String name, String email, String gender, String status) {
        innerDataMap = new HashMap<>();
        innerDataMap.put("name", name);
        innerDataMap.put("email", email);
        innerDataMap.put("gender", gender);
        innerDataMap.put("status", status);
        return innerDataMap;
    }
    public Map<String, Object> expectedData(String meta, Object innerDataMap) {
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("meta", meta);
        expectedDataMap.put("data", innerDataMap);
        return expectedDataMap;
    }
}
