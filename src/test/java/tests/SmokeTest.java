package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;

public class SmokeTest extends BaseTest {

    @Test(groups = {"smoke"})
public void googleTitleTest() {
    GooglePage googlePage = new GooglePage(driver);
    googlePage.open();
    Assert.assertTrue(googlePage.getTitle().contains("Google"));
}
    
}
