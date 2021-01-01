package com.ecommerce.testutils;

import java.util.ArrayList;
import java.util.List;

public class Constants {


    public static final String LOGIN_PAGE_TITLE = "Account Login";
    public static final String Home_PAGE_TITLE = "My Account";
    public static final String Home_HEADER_TITLE = "Your Store";
    public static final String REGISTER_SHEET_NAME = "registration";
    public static final String ACCOUNT_SUCCESS_MESSG = "Your Account Has Been Created";

    public static final int ACCOUNTS_SECTIONS = 4;

    public static List<String> getExpectedAccountSectionList() {
        List<String> accountSections = new ArrayList<>();
        accountSections.add("My Account");
        accountSections.add("My Orders");
        accountSections.add("My Affiliate Account");
        accountSections.add("Newsletter");

        return accountSections;

    }
}