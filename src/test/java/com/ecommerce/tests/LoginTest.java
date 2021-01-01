package com.ecommerce.tests;

import com.ecommerce.basepage.BaseTest;
import com.ecommerce.testutils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends BaseTest {

    @Test(priority=1)
    public void verifyLoginTitleTest()
    {
        String actualTitle =loginPage.pageTitle();
        System.out.println("Title of hubspot " + actualTitle);
        Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
    }


    @Test(priority=2)
    public void verifySignUpButtonTest()
    {
        Assert.assertTrue(loginPage.signUpButtonExist());;
    }


    @Test(priority=3)
    public void verifyLoginTest()
    {
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        String actualHomePageTitle = loginPage.pageTitle();
        Assert.assertEquals(actualHomePageTitle, Constants.Home_PAGE_TITLE);
    }
}
