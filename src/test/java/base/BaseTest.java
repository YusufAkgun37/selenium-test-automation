package base;

import pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BaseTest {

    protected WebDriver driver;
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
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        File target = new File("target/screenshots/" + testName + ".png");

        try {
            Files.createDirectories(target.getParentFile().toPath());
            Files.copy(source.toPath(), target.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
