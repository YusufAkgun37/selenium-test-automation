package listeners;

import base.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        attachScreenshot(driver);
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver) {
        System.out.println("📸 Allure screenshot attached");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
