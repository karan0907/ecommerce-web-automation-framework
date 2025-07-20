package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSearchTest extends BaseTest {

    @Test
    public void testSearchProductAndAddToCart() {
        // Search for a product
        driver.findElement(By.id("search")).sendKeys("Laptop");
        driver.findElement(By.id("searchBtn")).click();

        // Validate results are shown
        boolean isResultDisplayed = driver.findElements(By.cssSelector(".product-item")).size() > 0;
        Assert.assertTrue(isResultDisplayed, "No products found for search term");

        // Add first item to cart
        driver.findElements(By.cssSelector(".product-item .add-to-cart")).get(0).click();

        // Go to cart
        driver.findElement(By.id("cart")).click();

        // Validate cart has the item
        String cartItemText = driver.findElement(By.cssSelector(".cart-item")).getText();
        Assert.assertTrue(cartItemText.toLowerCase().contains("laptop"), "Item not added to cart properly");
    }
}
