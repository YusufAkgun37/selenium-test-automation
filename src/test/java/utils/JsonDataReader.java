package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonDataReader {

    private static JsonNode jsonData;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = JsonDataReader.class
                    .getClassLoader()
                    .getResourceAsStream("testdata/loginData.json");
            jsonData = mapper.readTree(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON test data", e);
        }
    }

    public static Object[][] getValidLoginData() {
        JsonNode array = jsonData.get("validLogins");
        Object[][] data = new Object[array.size()][2];

        for (int i = 0; i < array.size(); i++) {
            data[i][0] = array.get(i).get("username").asText();
            data[i][1] = array.get(i).get("password").asText();
        }
        return data;
    }

    public static Object[][] getInvalidLoginData() {
        JsonNode array = jsonData.get("invalidLogins");
        Object[][] data = new Object[array.size()][2];

        for (int i = 0; i < array.size(); i++) {
            data[i][0] = array.get(i).get("username").asText();
            data[i][1] = array.get(i).get("password").asText();
        }
        return data;
    }
}
