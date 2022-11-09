package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class HomePage1
{
    protected static WebDriver driver;

    // Method for unique id
    public String getTimeStamp()
    {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }
    // Method for click
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    // Method for entering text
    public void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    // Method for Get Text line in output
    public String getTextFormElement(By by)
    {
        return driver.findElement(by).getText();
    }

    // Open Website
    @BeforeTest
    public void openBrowser()
    {
        // To do Auto-generated method sub
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        // For keep fullscreen
        driver.manage().window().maximize();
        // Enter URL
        driver.get("https://demo.nopcommerce.com/");

    }

    // close website
    @AfterTest
    public void closeBrowser()
    {
        driver.close();
    }

    @Test
    public void verifyUserShouldBeAbleToRegister()
    {
        // Click on Register
        clickOnElement(By.className("ico-register"));
        // Enter First Name
        typeText(By.id("FirstName"),"Rajesh");
        // Enter Last Name
        typeText(By.id("LastName"),"Patel");
        // Enter Email with unique id
        typeText(By.id("Email"),"rajeshpatelhh"+getTimeStamp()+"@gmail.com");
        // Enter Password
        typeText(By.id("Password"),"Test&1234");
        // Enter Confirm Password
        typeText(By.id("ConfirmPassword"),"Test&1234");
        // Click on Register Button
        clickOnElement(By.name("register-button"));

        // Get Text line after successfully Registartion in output
        String regMsg = getTextFormElement(By.className("result"));
        System.out.println(regMsg);
    }

    @Test
    public void verifyUserShouldBeAbleTOSeeProductOfDesktopOnComputersPage()
    {
        // Click on Computers on Homepage
        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]"));
        // Click on Desktops on Computers page
        clickOnElement(By.xpath("//h2/a[@href=\"/desktops\"]"));

        // Get as a text in output products of desktop(computers)
        String productComputer1 = getTextFormElement(By.xpath("//h2/a[@href=\"/build-your-own-computer\"]"));
        System.out.println(productComputer1);
        // Get as a text in output products of desktop(computers)
        String productComputer2 = getTextFormElement(By.xpath("//h2/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));
        System.out.println(productComputer2);
        // Get as a text in output products of desktop(computers)
        String productComputer3 = getTextFormElement(By.xpath("//h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));
        System.out.println(productComputer3);
    }

}
