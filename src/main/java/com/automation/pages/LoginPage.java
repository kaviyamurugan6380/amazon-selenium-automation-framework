package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailField = By.cssSelector("#ap_email, #ap_email_login");
    private By continueButton = By.id("continue");
    private By passwordField = By.id("ap_password");
    private By signInButton = By.id("signInSubmit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        type(emailField, email);
        click(continueButton);
        type(passwordField, password);
        click(signInButton);
    }
}