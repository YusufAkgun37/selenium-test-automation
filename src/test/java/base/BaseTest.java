package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;


public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected LoginPage loginPage;

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setup() {
        driver.set(DriverFactory.createDriver());
        getDriver().get(ConfigReader.getProperty("url"));

        loginPage = new LoginPage(getDriver());
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

}

