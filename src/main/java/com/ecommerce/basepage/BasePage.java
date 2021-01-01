package com.ecommerce.basepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

   public WebDriver driver;
   public Properties prop;

   public static ThreadLocal<WebDriver>  tlDriver = new ThreadLocal<WebDriver>();

   public WebDriver intiDriver(String browser)
   {
       System.out.println("Browser value is " + browser);

       if(browser.equalsIgnoreCase("chrome"))
       {
           WebDriverManager.chromedriver().setup();
          // driver = new ChromeDriver();
           tlDriver.set(new ChromeDriver());
       }
       else if(browser.equalsIgnoreCase("firefox"))
       {
           WebDriverManager.firefoxdriver().setup();
           //driver = new FirefoxDriver();
           tlDriver.set(new FirefoxDriver());
       }
       else
           System.out.println(" Browser value is not correct " + browser);

       getDriver().manage().deleteAllCookies();
       getDriver().manage().window().maximize();
       getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       return getDriver();
   }

   public static synchronized WebDriver getDriver()
   {
      return tlDriver.get();
   }

   public Properties initProp()
   {
       prop = new Properties();

       try {
           FileInputStream file  = new FileInputStream(".\\src\\main\\java\\com\\ecommerce\\configproperties\\config.properties");
           prop.load(file);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return prop;
   }

   public String getScreenShot()
   {
       File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
       String path = System.getProperty("user.dir") + "/Screenshots/" +System.currentTimeMillis() + ".png";
       File destination = new File(path);

       try {
           FileUtils.copyFile(src,destination);
       } catch (IOException e) {
           e.printStackTrace();
       }
       return path;
   }
}
