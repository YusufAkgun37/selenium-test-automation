package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;


public class BaseTest {

    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }


    protected LoginPage loginPage;

    @BeforeMethod
public void setup() {
    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless=new");
    options.addArguments("--disable-gpu");
    options.addArguments("--window-size=1920,1080");

    driver = new ChromeDriver(options);
    driver.manage().window().maximize();

    loginPage = new LoginPage(driver);
}


@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

