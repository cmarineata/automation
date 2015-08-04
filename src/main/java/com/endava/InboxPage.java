package com.endava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

/**
 * Created by cmarineata on 8/4/2015.
 */
public class InboxPage {

    @FindBy(xpath = "//div[text()='COMPOSE']")
    private WebElement composeButton;

    @FindBy(xpath = "//textarea[@aria-label='To']")
    private WebElement toField;

    @FindBy( name = "subjectbox")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private WebElement textField;

    @FindBy(xpath = "//div[contains(text(),'Send') and @role='button']")
    private WebElement sendButton;

    @FindBy(xpath = "//table//tr[1]//td[6]//span[1]")
    private WebElement lastMail;

    WebDriver driver;

    public InboxPage(WebDriver driver){
        this.driver = driver;
    }

    public void composeMessage(String to,String subject, String text){
        composeButton.click();
        toField.sendKeys(to);
        subjectField.sendKeys(subject);
        textField.sendKeys(text);
        sendButton.click();
    }

    public void checkLastEmail(String subject){
        String subjectText = lastMail.getText();
        assertEquals(subject,subjectText);
    }
}
