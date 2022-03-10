package com.test.orengehrm.tests;

import Utils.ConfigReader;
import com.test.orengehrm.DataForLoginNegativeTest;
import com.test.orengehrm.TestBase;
import com.test.orengehrm.pages.AdminPage;
import com.test.orengehrm.pages.LoginPage;
import com.test.orengehrm.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {
    AdminPage adminPage;
    @BeforeMethod
    public void initiliazePages(){
        adminPage=new AdminPage(driver);
    }

    @Test
    public void validateTheCreationOfEmployeeMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
//        AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();// if you want to use this change username
        Assert.assertTrue(adminPage.validationTheEmployeeIsCreated("DenemeNews1"));

    }


    @Test(dataProvider = "UserRoles",invocationCount = 3, dataProviderClass = DataForLoginNegativeTest.class)
    public void validateTheSelectRoleFunctions(String roleName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"), ConfigReader.readProperty("orangehrmpassword"));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.selectUserRole(roleName, driver);
        Assert.assertTrue(adminPage.validateRoleText(roleName));

    }

//    @Test
//    public void validateTheSelectRoleFunctions2(String roleName) {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login(ConfigReader.readProperty("orangehrmusername"), ConfigReader.readProperty("orangehrmpassword"));
//        MainPage mainPage = new MainPage(driver);
//        mainPage.clickAdminButton();
//        AdminPage adminPage = new AdminPage(driver);
//        adminPage.selectUserRole("ESS", driver);
//        Assert.assertTrue(adminPage.validateRoleText());
//
//    }
}
