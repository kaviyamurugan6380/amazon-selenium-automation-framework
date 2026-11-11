package com.automation.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductPage;
import com.automation.pages.SearchResultsPage;
import com.automation.utils.ConfigReader;

public class AmazonE2ETest extends BaseTest {

    @Test(description = "Login, search, filter, add to cart, checkout, logout")
    public void amazonEndToEndFlow() {
        String user = ConfigReader.get("username");
        String pass = ConfigReader.get("password");
        if (user == null || user.isEmpty()) {
            throw new SkipException("Add username and password in config.properties");
        }

        HomePage home = new HomePage(driver);
        home.clickSignIn();
        new LoginPage(driver).login(user, pass);
        Assert.assertTrue(home.isSignedIn(), "Login failed");

        home.searchFor(ConfigReader.get("searchTerm"));
        SearchResultsPage results = new SearchResultsPage(driver);
        Assert.assertTrue(results.areResultsDisplayed(), "No search results");

        results.applyRatingFilter();
        results.openFirstProduct();

        ProductPage product = new ProductPage(driver);
        Assert.assertFalse(product.getProductTitle().isEmpty(), "Product title missing");
        product.addToCart();

        CartPage cart = new CartPage(driver);
        cart.openCart();
        Assert.assertTrue(cart.isItemInCart(), "Item not in cart");
        cart.proceedToCheckout();

        Assert.assertTrue(new CheckoutPage(driver).isCheckoutPageDisplayed(), "Checkout not reached");

        driver.navigate().to(ConfigReader.get("baseUrl"));
        home.logout();
    }
}