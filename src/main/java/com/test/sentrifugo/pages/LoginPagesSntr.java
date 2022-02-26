package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LoginPagesSntr {

    public LoginPagesSntr(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    //we are going to store our element locations and methods in here
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(id = "loginsubmit")
    WebElement login;

    public void login(){
        username.sendKeys("EM01");
        password.sendKeys("sentrifugo");
        login.click();
    }

    public void dynamicLogin(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.login.submit();
    }


}
