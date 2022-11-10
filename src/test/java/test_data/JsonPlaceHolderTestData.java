package test_data;

import java.util.*;

public class JsonPlaceHolderTestData {
    //bir class iki farklı class'a extends yapılamaz.
    //static yaparsak başka classlarda onu kullandigi zaman datamizin degisme ihtimali olabilir
    //obje olusturursak kopyasini olusturmus gibi oluruz. degisiklikler aslini etkilemez
    //id olusturmamamizin sebebi zaten id ile cagiriyor olusumuzdur.
    //Wrapper class tercih etmemizin sebebi bazen null bir deger atamamiz gerekecek

    public Map<String, Object> expectedDataMethod(Integer userId, String tittle, Boolean completed) {
        Map<String, Object> expectedDataMap = new HashMap<>();
        if (userId!=null){
        expectedDataMap.put("userId", userId);}
        if(tittle!=null){
        expectedDataMap.put("title", tittle);}
        if (completed!=null){
        expectedDataMap.put("completed", completed);}
        //System.out.println("expectedDataMap = " + expectedDataMap);
        return expectedDataMap;
    }
}
