package com.endava;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class GmailTest {
    static WebDriver driver;

    @BeforeClass
    public static void before(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        submitButton.click();

        WebElement writeButton = driver.findElement(By.xpath("//div[text()='COMPOSE']"));
        writeButton.click();

        WebElement toField = driver.findElement(By.className("vO"));
        toField.sendKeys("costina.marineata@gmail.com");

        WebElement subjectField = driver.findElement(By.className("aoT"));
        subjectField.sendKeys("Primul test automat");

        WebElement textField = driver.findElement(By.className("LW-avf"));
        textField.sendKeys("Aici introduc textul!");

        WebElement sendButton = driver.findElement(By.xpath("//div[text()='Send']"));
        sendButton.click();
    }

}
