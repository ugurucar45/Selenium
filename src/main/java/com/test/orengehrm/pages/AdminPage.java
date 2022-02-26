package com.test.orengehrm.pages;

import Utils.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnAdd")
    WebElement addButton;

    @FindBy(id = "systemUser_userType")
    WebElement userRoles;
    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;
    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement username;
    @FindBy(name = "systemUser[status]")
    WebElement status;
    @FindBy(name = "systemUser[password]")
    WebElement password;
    @FindBy(name = "systemUser[confirmPassword]")
    WebElement confirmPassword;
    @FindBy(className = "addbutton")
    WebElement saveButton;

    public void sendingAllInformationForEmployee() {
        addButton.click();
        BrowserUtil.selectBy(userRoles, "Admin", "text");
        employeeName.sendKeys("Alice Duval");
        username.sendKeys("Deneme1234");
        BrowserUtil.selectBy(status, "0", "value");
        password.sendKeys("12345678");
        confirmPassword.sendKeys("12345678");
        saveButton.click();
    }
}
