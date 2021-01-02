package com.ecommerce.pages;

import com.ecommerce.basepage.BasePage;
import com.ecommerce.testutils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {


    private ElementUtils elementUtils;


    // 1. locators - By
    private By emailId = By.id("input-email");
    private By password = By.id("input-password");
    private By loginButton = By.xpath("//input[@type='submit']");
    private By signUpButton = By.xpath("//a[text()='Continue11']");
    private By registerLink = By.linkText("Register");


    public LoginPage(WebDriver driver)
    {
       this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }

    public String pageTitle() {
        return driver.getTitle();
    }

    public boolean signUpButtonExist() {
        return driver.findElement(signUpButton).isDisplayed();
    }

    public void doLogin(String username, String pw) {
        driver.findElement(emailId).sendKeys(username);
        driver.findElement(password).sendKeys(pw);
        driver.findElement(loginButton).click();

    }

    public RegisterPage navigateToRegisterPage() {
        elementUtils.doClick(registerLink);
        return new RegisterPage(driver);
    }


}
