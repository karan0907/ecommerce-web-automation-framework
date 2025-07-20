package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test(dataProvider = "invalidCredentials")
    public void testInvalidLogin(String username, String password) {
        driver.findElement(By.id("user")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("loginBtn")).click();

        String error = driver.findElement(By.id("loginError")).getText();
        Assert.assertTrue(error.contains("Invalid"), "Login error message not displayed correctly");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidData() {
        return new Object[][] {
            {"wronguser", "wrongpass"},
            {"", "somepass"},
            {"admin", ""},
            {"<script>", "hack"}
        };
    }
}
