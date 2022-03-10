package ProjectDays.FivethProject.pages;

import Utils.DriverHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(DriverHelper.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    public void sendKeysUserNameAndPassword(String userNAME, String passWORD){
        userName.sendKeys(userNAME);
        password.sendKeys(passWORD, Keys.ENTER);
    }

}
