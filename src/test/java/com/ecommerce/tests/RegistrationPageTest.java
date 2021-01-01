package com.ecommerce.tests;

import com.ecommerce.basepage.BaseTest;
import com.ecommerce.testutils.Constants;
import com.ecommerce.testutils.ExcelReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {


    String appendMail = RandomStringUtils.randomAlphabetic(3)+"@gmail.com";

    @DataProvider
    public Object[][] getDataRegistration() {
        return ExcelReader.getTestdata(Constants.REGISTER_SHEET_NAME);
    }

    @Test(dataProvider = "getDataRegistration")
    public void accountRegistrationTest(String firstname, String lastname, String email, String telephone,
                                        String password, String subscribe) {


        loginPage.navigateToRegisterPage();
        boolean accountCreated = registerPage.accountRegistration(firstname, lastname, email+""+appendMail+"", telephone, password, subscribe);
        Assert.assertEquals(accountCreated, true);
    }

}
