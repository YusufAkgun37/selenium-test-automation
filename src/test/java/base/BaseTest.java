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

    protected WebDriver driver;
    protected LoginPage loginPage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver();
        driver.get(ConfigReader.getProperty("url"));

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

