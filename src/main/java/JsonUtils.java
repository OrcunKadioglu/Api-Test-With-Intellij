import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
    private static ObjectMapper mapper;

    static{
        mapper = new ObjectMapper();
    }

    //1 Method: This method will convert Json Data to Java Object(De-Serialization)
    //when is static you will not need to create objects

    //Data Type
    public static  <T> T convertJsonToJavaObject(String json, Class<T> cls){// will take the Json as String
        //When put map, i will get map                       // to make my method dynamic put Class<t>
        // it means in the second parameter you can put any data type
        // it is called GENERIC METHOD==> Parameter accepts any data type

        T javaResult = null;

        try {
            javaResult = mapper.readValue(json, cls);//readvalue will get string and covert it to java object i will give(if it is object it will be object)
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return javaResult;
    }

    //2. Method: This method will convert Java Object to Json Data(Serialization)
    public static String convertJavaObjectToJson(Object obj){// we mentioned above that java object will be String

        String jsonResult = null;

        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonResult;
    }



}
