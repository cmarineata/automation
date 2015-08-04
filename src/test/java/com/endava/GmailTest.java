package com.endava;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class GmailTest {
    static WebDriver driver;

    @BeforeClass
    public static void before(){
        System.setProperty("webdriver.chrome.driver","D:/Tools/SeleniumDrivers/chromedriver.exe"); //schimb browserul - pt Chrome am instalat driverul de pe net
        driver = new ChromeDriver(); //schimb browserul

//        System.setProperty("webdriver.ie.driver","D:/Tools/SeleniumDrivers/IEDriverServer.exe"); //schimb browserul - pt Chrome am instalat driverul de pe net
//        driver = new InternetExplorerDriver();


//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //fullscreen window
    }

    @AfterClass
    public static void after(){
        driver.close();
    }

    @Before
    public void goToPage(){
        driver.get("http://mail.google.com");
    }
    @Test
    public void testGmail(){

        WebElement userNameField = driver.findElement(By.id("Email"));
        userNameField.sendKeys("costina1m@gmail.com");

        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();

        WebElement passwordField = driver.findElement(By.id("Passwd"));
        passwordField.sendKeys("parolameapentrucontulfake");

        WebElement submitButton = driver.findElement(By.id("signIn"));
        submitButton.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement composeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='COMPOSE']")));
        System.out.println(driver.getTitle());

        String title = driver.getTitle();
        assertTrue(title.contains("costina1m@gmail.com"));

//        WebElement writeButton = driver.findElement(By.xpath("//div[text()='COMPOSE']"));
//        writeButton.click();
//
//        WebElement toField = driver.findElement(By.className("vO"));
//        toField.sendKeys("costina.marineata@gmail.com");
//
//        WebElement subjectField = driver.findElement(By.className("aoT"));
//        subjectField.sendKeys("Primul test automat");
//
//        WebElement textField = driver.findElement(By.className("LW-avf"));
//        textField.sendKeys("Aici introduc textul!");
//
//        WebElement sendButton = driver.findElement(By.xpath("//div[text()='Send']"));
//        sendButton.click();
    }

}
