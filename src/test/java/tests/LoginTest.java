package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test(groups = {"regression"})
public void successfulLoginTest() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.open();
    loginPage.login("tomsmith", "SuperSecretPassword!");

    Assert.assertTrue(
            loginPage.getSuccessMessage().contains("You logged into a secure area")
    );
}

    @Test(groups = {"regression"})
public void negativeLoginTest() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.open();
    loginPage.login("tomsmith", "WrongPassword!");

    Assert.assertTrue(
            loginPage.getErrorMessage().contains("Your password is invalid")
    );
}

   @Test(groups = {"regression"})
public void logoutTest() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.open();
    loginPage.login("tomsmith", "SuperSecretPassword!");
    loginPage.logout();

    Assert.assertTrue(
            loginPage.getErrorMessage().contains("You logged out")
    );
}
}
