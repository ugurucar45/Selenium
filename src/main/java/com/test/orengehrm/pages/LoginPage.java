package com.test.orengehrm.pages;

import Utils.BrowserUtil;
import com.test.orengehrm.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "txtUsername")
    WebElement userName;

    @FindBy(id = "txtPassword")
    WebElement password;

    @FindBy(id = "btnLogin")
    WebElement login;

    @FindBy(id = "spanMessage")
    WebElement errorMessage;

    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.login.submit();
    }

    public String getErrrorMessage(){
        return BrowserUtil.getTextMethod(errorMessage);
    }

    public String getColorOfTheErrorMessage(){

        return errorMessage.getCssValue("color");
    }
}
