package ProjectDays.FivethProject.tests;

import ProjectDays.FivethProject.TestBase;
import ProjectDays.FivethProject.pages.LoginPage;
import ProjectDays.FivethProject.pages.MainPage;
import Utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    @BeforeMethod
    public void pageInitialization(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
    }

//testcase1
    @Test
    public void validate() throws InterruptedException {
        loginPage.sendKeysUserNameAndPassword(ConfigReader.readProperty("userName"),ConfigReader.readProperty("password"));
        mainPage.clickSwitch();
        Assert.assertTrue(mainPage.validateSwitchPopUp1());
        Assert.assertTrue(mainPage.validateSwitchPopUp2());
        mainPage.confirmLalaLamees();
        Assert.assertTrue(mainPage.lalaIsDisplayed());
        Assert.assertEquals(mainPage.changeToIsCorrect(),"Changed To");
        Assert.assertEquals(mainPage.getColorOfTheDot(),"rgba(138, 109, 59, 1)");
mainPage.clicktochangeto();
    }
}