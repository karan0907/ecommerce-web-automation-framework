package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.testng.Assert;

public class CheckoutTest extends BaseTest {

    @Test
    public void testLoginAndCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "testpass");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"), "Login failed or wrong redirection.");
    }
}
