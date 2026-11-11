package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage {

    private By ratingFilter = By.xpath("(//span[contains(text(),'& Up')]/ancestor::a)[1]");
    private By resultsList = By.cssSelector("div[data-component-type='s-search-result']");
    private By productLinks = By.xpath(
            "//div[@data-component-type='s-search-result']//h2/ancestor::a"
            + " | //div[@data-component-type='s-search-result']//h2//a");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean areResultsDisplayed() {
        return isDisplayed(resultsList);
    }

    public void applyRatingFilter() {
        click(ratingFilter);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsList));
    }

    public void openFirstProduct() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productLinks));
        List<WebElement> links = driver.findElements(productLinks);
        System.out.println("PRODUCT LINKS FOUND: " + links.size());
        String chosen = null;
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href != null && href.contains("/dp/")
                    && !href.contains("/sspa/") && !href.contains("sp_atf")) {
                chosen = href;
                break;
            }
        }
        if (chosen == null && !links.isEmpty()) {
            chosen = links.get(0).getAttribute("href");
        }
        System.out.println("OPENING: " + chosen);
        driver.get(chosen);
    }
}