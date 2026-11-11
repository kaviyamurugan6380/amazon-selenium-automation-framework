package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private By accountMenu = By.id("nav-link-accountList");
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By signOut = By.id("nav-item-signout");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn() {
        click(accountMenu);
    }

    public void searchFor(String product) {
        type(searchBox, product);
        click(searchButton);
    }

    public void logout() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(accountMenu));
        new Actions(driver).moveToElement(menu).perform();
        click(signOut);
    }

    public boolean isSignedIn() {
        return isDisplayed(accountMenu);
    }
}