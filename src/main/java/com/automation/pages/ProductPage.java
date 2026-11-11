package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    private By productTitle = By.id("productTitle");
    private By addToCartButton = By.cssSelector(
            "#add-to-cart-button, input[name='submit.add-to-cart']");
    private By cartCount = By.id("nav-cart-count");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
    }

    public void addToCart() {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", button);
        wait.until(ExpectedConditions.elementToBeClickable(button));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

        // wait until the cart count is no longer 0
        try {
            wait.until(d -> !d.findElement(cartCount).getText().trim().equals("0"));
        } catch (Exception e) {
            // continue, the cart page check will confirm
        }
    }
}