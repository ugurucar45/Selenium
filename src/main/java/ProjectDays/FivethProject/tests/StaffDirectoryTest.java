package ProjectDays.FivethProject.tests;

import ProjectDays.FivethProject.TestBase;
import ProjectDays.FivethProject.pages.LoginPage;
import ProjectDays.FivethProject.pages.MainPage;
import ProjectDays.FivethProject.pages.StaffDirectoryPage;
import Utils.ConfigReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaffDirectoryTest extends TestBase {

    LoginPage loginPage;
    MainPage mainPage;
    StaffDirectoryPage staffDirectoryPage;

    @BeforeMethod
    public void pageInitialization() {
        loginPage = new LoginPage();
        mainPage = new MainPage();
        staffDirectoryPage = new StaffDirectoryPage();
    }

    @Test
    public void validate3() throws InterruptedException {
        loginPage.sendKeysUserNameAndPassword(ConfigReader.readProperty("userName"), ConfigReader.readProperty("password"));
        mainPage.clicktoStaffDirectory();
        staffDirectoryPage.clickfilter();
        staffDirectoryPage.jobtitleselect(driver);
staffDirectoryPage.assertallmanagers();

    }

}
