package tests.smoke;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;

public class SmokeTest extends BaseTest {

@Severity(SeverityLevel.BLOCKER)
@Tag("smoke")
@Test(groups = {"smoke"})
public void googleTitleTest() {
    GooglePage googlePage = new GooglePage(driver);
    googlePage.open();
    Assert.assertTrue(googlePage.getTitle().contains("Google"));
}
    
}
