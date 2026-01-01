package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!"}
        };
    }

@DataProvider(name = "invalidLoginData")
public static Object[][] invalidLoginData() {
    return new Object[][]{
        {"tomsmith", "wrongPassword"},
        {"wrongUser", "SuperSecretPassword!"}
    };
}


}

