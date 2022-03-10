package ProjectDays.FivethProject.tests;

import ProjectDays.FivethProject.TestBase;
import ProjectDays.FivethProject.pages.LoginPage;
import Utils.ConfigReader;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
//    @Parameters({"userName","password"})
//    @Test
//    public void validate(String userNAME, String passWORD){
//        LoginPage loginPage = new LoginPage();
//        loginPage.sendKeysUserNameAndPassword(userNAME,passWORD);
//    }

    @Test
    public void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.sendKeysUserNameAndPassword(ConfigReader.readProperty("userName"),ConfigReader.readProperty("password"));
    }
}
