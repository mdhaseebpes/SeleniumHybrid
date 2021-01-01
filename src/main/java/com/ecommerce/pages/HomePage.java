package com.ecommerce.pages;

import com.ecommerce.basepage.BasePage;
import com.ecommerce.testutils.Constants;
import com.ecommerce.testutils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private WebDriver driver;
    private ElementUtils elementutils;

    private By header = By.xpath("//a[.='Your Store']");
    private By wishListicon = By.xpath("//span[.='Wish List (0)']");
    private By accountHomeSection = By.xpath("//div[@id='content']/h2");
    private By searchTextBox = By.xpath("//div[@id='search']/input[@name='search']");
    private By searchButton = By.xpath("//div[@id='search']/span/button");
    private By productSearchList = By.xpath("//div[contains(@class,'product-layout')]/div");
    private By resultItems = By.cssSelector(".product-thumb h4 a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementutils = new ElementUtils(this.driver);

    }

    public String gethomepageTitle() {
        return elementutils.waitForTitlePresent(Constants.Home_PAGE_TITLE, 10);

    }
    public String getHomeHeaderValue() {
        /*
         * if (driver.findElement(header).isDisplayed()) { return
         * driver.findElement(header).getText(); }
         */

        if(elementutils.doIsDisplayed(header)) {
            return elementutils.doGetText(header);
        }
        return null;
    }

    public boolean wishListIconExsit() {

        /*
         * if (driver.findElements(wishListicon).size() > 0) { return true; }
         */

        if(elementutils.getElements(wishListicon).size()>0) {
            return true;
        }
        return false;
    }

    public List<String> getAccountSections() {
        List<String> accountSections = new ArrayList<>();
        List<WebElement> accountlist =elementutils.getElements(accountHomeSection);
        for (WebElement e : accountlist) {
            accountSections.add(e.getText());

        }

        return accountSections;
    }

    public int getAccountSectionCount() {

        return elementutils.getElements(accountHomeSection).size();

    }

    public boolean productSearch(String productName) {
        elementutils.doSendKeys(searchTextBox, productName);
        elementutils.doClick(searchButton);

        if (elementutils.getElements(productSearchList).size() > 0) {
            return true;
        }

        return false;
    }

    public ProductInfoPage selectProductFromResults(String ProductName)
    {
        List<WebElement> resultItemList = elementutils.getElements(resultItems);
        System.out.println("total number of items displayed: " + resultItemList.size());

        for(WebElement e: resultItemList)
        {
            if(e.getText().equalsIgnoreCase(ProductName))
            {
                e.click();
                break;
            }
        }

        return new ProductInfoPage(driver);
    }
}

