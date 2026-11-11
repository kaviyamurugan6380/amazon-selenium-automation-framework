package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.ConfigReader;

public class CartPage extends BasePage {

    private By cartCount = By.id("nav-cart-count");
    private By cartItems = By.cssSelector(
            "#sc-active-cart .sc-list-item, div[data-name='Active Items'], "
            + "div.sc-list-item, [data-asin][data-itemtype], input[value='Delete']");
    private By proceedToBuy = By.cssSelector(
            "input[name='proceedToRetailCheckout'], #sc-buy-box-ptc-button, "
            + "#sc-buy-box-ptc-button input");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        driver.get(ConfigReader.get("baseUrl") + "/gp/cart/view.html");
        try {
            Thread.sleep(8000); // short pause so you can see the cart page
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isItemInCart() {
        int matches = driver.findElements(cartItems).size();
        String count = "?";
        try {
            count = driver.findElement(cartCount).getText().trim();
        } catch (Exception e) {
            // ignore
        }
        boolean emptyText = driver.getPageSource().contains("Your Amazon Cart is empty");
        System.out.println("CART MATCHES: " + matches);
        System.out.println("CART COUNT: " + count);
        System.out.println("CART EMPTY TEXT: " + emptyText);
        return matches > 0 || (!count.equals("0") && !count.equals("?") && !emptyText);
    }

    public void proceedToCheckout() {
        click(proceedToBuy);
    }
}