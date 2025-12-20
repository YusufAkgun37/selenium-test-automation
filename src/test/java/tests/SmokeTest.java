package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void openGoogleTest() {
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }
}
