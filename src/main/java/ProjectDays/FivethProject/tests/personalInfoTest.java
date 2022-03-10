package ProjectDays.FivethProject.tests;

import ProjectDays.FivethProject.TestBase;
import ProjectDays.FivethProject.pages.LoginPage;
import ProjectDays.FivethProject.pages.MainPage;
import ProjectDays.FivethProject.pages.PersonalInfoPage;
import Utils.ConfigReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class personalInfoTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PersonalInfoPage personalInfoPage;
    @BeforeMethod
    public void pageInitialization(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        personalInfoPage= new PersonalInfoPage();
    }

    //testcase2
    @Test
    public void validate2() throws InterruptedException {
        loginPage.sendKeysUserNameAndPassword(ConfigReader.readProperty("userName"),ConfigReader.readProperty("password"));

        mainPage.clickSwitch();
      mainPage.confirmLalaLamees();
           personalInfoPage.clicktochangeto();
personalInfoPage.validatecurrenturl(driver);
personalInfoPage.validatetitle(driver);
personalInfoPage.validateJobTitle(driver);
personalInfoPage.validateEmployeeStatus(driver);
personalInfoPage.validateSupervisorName(driver);
personalInfoPage.validatedepartment(driver);

    }
}
