package tests.regression;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestDataProvider;
import io.qameta.allure.Step;
import io.qameta.allure.Description;



public class LoginTest extends BaseTest {

@Test(
    groups = {"regression"},
    dataProvider = "validLoginData",
    dataProviderClass = TestDataProvider.class
)
@Description("Valid user should login successfully")
public void successfulLoginTest(String username, String password) {

    loginWithCredentials(username, password);

    Assert.assertTrue(
            loginPage.getSuccessMessage().contains("You logged into a secure area")
    );
}


@Test(
    groups = {"regression"},
    dataProvider = "invalidLoginData",
    dataProviderClass = TestDataProvider.class
)
@Description("Invalid credentials should show proper error message")
public void negativeLoginTest(String username, String password) {

    loginWithCredentials(username, password);

    String errorMessage = loginPage.getErrorMessage();

    Assert.assertTrue(
        errorMessage.contains("Your password is invalid")
        || errorMessage.contains("Your username is invalid"),
        "Unexpected error message: " + errorMessage
    );
}

@Step("Login with username: {username} and password: {password}")
public void loginWithCredentials(String username, String password) {
    loginPage.open();
    loginPage.login(username, password);
}




/* 
@Test(groups = {"regression"})
public void logoutTest() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.open();
    loginPage.login("tomsmith", "SuperSecretPassword!");
    loginPage.logout();

    Assert.assertTrue(
        loginPage.getLogoutMessage().contains("You logged out")
    );
}
*/
}