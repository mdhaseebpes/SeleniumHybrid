package com.ecommerce.basepage;

import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductInfoPage;
import com.ecommerce.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public Properties prop;
    public BasePage basePage;
    public LoginPage loginPage;
    public HomePage homePage;
    public RegisterPage registerPage;
    public ProductInfoPage productInfoPage;


    @BeforeMethod
    public void setup() {
        basePage = new BasePage();
        prop = basePage.initProp();
        driver = basePage.intiDriver(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        productInfoPage = new ProductInfoPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
