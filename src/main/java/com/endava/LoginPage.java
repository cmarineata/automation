package com.endava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by cmarineata on 8/4/2015.
 */
public class LoginPage {

    @FindBy(id = "Email")  //identific elementuld de username
    private WebElement userNameField;

    @FindBy(id = "next")
    private WebElement nextButton;

    @FindBy(id = "Passwd")
    private WebElement passwordField;

    @FindBy(id = "signIn")
    private WebElement loginButton;

    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.google.com");
    }

    public InboxPage login(String email, String pass){
        userNameField.sendKeys(email);
        nextButton.click();
        passwordField.sendKeys(pass);
        loginButton.submit();

        InboxPage inboxPage = PageFactory.initElements(driver, InboxPage.class);
        return inboxPage;
    }
}
