package com.ecommerce.tests;

import com.ecommerce.basepage.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductInfoTest extends BaseTest {


    @Test
    public void verifyProductInfoTest_MacBook() {
        String productName = "Macbook";

        loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
        Assert.assertTrue(homePage.productSearch(productName));

        productInfoPage = homePage.selectProductFromResults("MacBook Pro");

        Assert.assertTrue(productInfoPage.getproductAdditionalImageCount() == 3);

        Map<String, String> productInfoMap =
                productInfoPage.productInfoDetails();
        System.out.println(productInfoMap);
        // {Brand=Apple, Availability=In Stock,
        // price=$2,000.00, name=MacBook Pro,
        // Product Code=Product 18, Reward Points=800,
        // exTaxPrice=$2,000.00

        Assert.assertEquals(productInfoMap.get("name"), "MacBook Pro");
        Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
        Assert.assertEquals(productInfoMap.get("price"), "Ex Tax: $2,000.00");
        Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
        Assert.assertEquals(productInfoMap.get("Reward Points"), "800");

    }

}
