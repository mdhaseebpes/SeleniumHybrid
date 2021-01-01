package com.ecommerce.tests;

import com.ecommerce.basepage.BaseTest;
import com.ecommerce.testutils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyHomeHeaderValueTest()
    {
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        String actualHeader = homePage.getHomeHeaderValue();
        Assert.assertEquals(actualHeader, Constants.Home_HEADER_TITLE);
    }

    @Test(priority = 2)
    public void verifyWishIconTest()
    {
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(homePage.wishListIconExsit());
    }
}
