package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() {
        return JsonDataReader.getValidLoginData();
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        return JsonDataReader.getInvalidLoginData();
    }
}
