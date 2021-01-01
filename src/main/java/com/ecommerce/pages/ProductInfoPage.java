package com.ecommerce.pages;

import com.ecommerce.basepage.BasePage;
import com.ecommerce.testutils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductInfoPage extends BasePage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    private By productNameHeader = By.xpath("//div[@id='content']//h1");
    private By productInfo = By.xpath("//div[@id='content']//ul[@class='list-unstyled']/li");
    private By productQuantity = By.xpath("//div[@id='product']//input[@name='quantity']");
    private By productImages = By.xpath("//li[@class='image-additional']/a");
    private By addToCartBtn = By.id("button-cart");

    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }

    public Map<String, String> productInfoDetails() {
        Map<String, String> productDetails = new HashMap<String, String>();
        productDetails.put("name",elementUtils.doGetText(productNameHeader));

        List<WebElement> productText = elementUtils.getElements(productInfo);
        for (WebElement e : productText) {

            if (e.getText().contains("$")) {
                productDetails.put("price",e.getText());

            } else

                productDetails.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
        }

        return productDetails;
    }

    public int productQuantity() {
        return elementUtils.getElements(productQuantity).size();
    }

    public void addToCart()
    {
        elementUtils.doClick(addToCartBtn);
    }

    public int getproductAdditionalImageCount()
    {
        return elementUtils.getElements(productImages).size();
    }

    public List<String> productImages() {
        List<String> imagesList = new ArrayList<>();
        List<WebElement> images = elementUtils.getElements(productImages);
        for (WebElement e : images) {
            imagesList.add(e.getText());
        }

        return imagesList;
    }
}




