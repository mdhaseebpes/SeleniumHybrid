package com.ecommerce.testutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsUtils {

    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");
    }

    public static void refreshBrowserByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public static String getBrowserinfo(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String uAgent = js.executeScript("return navigator.userAgent").toString();
        return uAgent;
    }

    public static void sendKeysUsingJSWithID(WebDriver driver, String id, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementById('" + id + "').value='" + value + "'");

    }

    public static void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("argument[0].click();", element);
    }

    public static void drawBorder(WebDriver driver, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("argument[0].style.border='3px solid red'", element);
    }

    public static void flash(WebDriver driver, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 20; i++) {
            changeColor("rgb(0,200,0)", element, driver);
            changeColor(bgColor, element, driver);
        }
    }

    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor ='" + color + "'", element);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }
    }

    public static String getPageInnerText(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String pageText = js.executeScript("return document.documentElement.innerText").toString();
        return pageText;
    }

    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scroll(0,document.body.scrollHeight)");
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
