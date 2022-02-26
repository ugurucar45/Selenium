package com.test.orengehrm.tests;

import com.test.orengehrm.TestBase;
import com.test.orengehrm.pages.AdminPage;
import com.test.orengehrm.pages.LoginPage;
import com.test.orengehrm.pages.MainPage;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {
    @Test
    public void validateTheCreationOfEmployeeMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();
    }
}
