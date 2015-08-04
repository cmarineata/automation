package com.endava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cmarineata on 8/4/2015.
 */
public class PageObjectTest {

    LoginPage page ;
    WebDriver driver;
    @Before
    public void before(){
        driver = new FirefoxDriver();
        page = PageFactory.initElements(driver, LoginPage.class);
    }

    @After
    public void after(){
        driver.close();
    }

    @Test
    public void test(){
      String subject = "test";
      InboxPage inbox = page.login("costina1m@gmail.com","parolameapentrucontulfake");
        inbox.composeMessage("costina1m@gmail.com",subject,"test1");
        inbox.checkLastEmail(subject);
    }
}
