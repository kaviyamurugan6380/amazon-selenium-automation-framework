package com.automation.pages;

import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Stops at the checkout/payment page. No payment is placed.
    public boolean isCheckoutPageDisplayed() {
        try {
            Thread.sleep(6000); // let the checkout page load
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String url = driver.getCurrentUrl().toLowerCase();
        System.out.println("CHECKOUT URL: " + url);
        System.out.println("CHECKOUT TITLE: " + driver.getTitle());
        return url.contains("checkout") || url.contains("/buy") || url.contains("spc")
                || url.contains("addressselect") || url.contains("payselect")
                || url.contains("signin");
    }
}