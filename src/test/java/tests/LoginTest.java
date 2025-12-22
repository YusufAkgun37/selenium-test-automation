package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login("tomsmith", "WrongPasswprd!");

        Assert.assertTrue(
                loginPage.getSuccessMessage().contains("You logged into a secure area"),
                "Login basarisiz!"
        );
        try {
    Thread.sleep(3000); 
       }catch (InterruptedException e) {
    e.printStackTrace();
}
}
@Test
public void negativeLoginTest() {
    LoginPage loginPage = new LoginPage(driver);

    loginPage.open();
    loginPage.login("tomsmith", "WrongPassword!");

    Assert.assertTrue(
            loginPage.getErrorMessage().contains("Your password is invalid"),
            "Hata mesaji beklenenden farkli!"
    );
}
}
