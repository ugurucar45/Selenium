package com.test.orengehrm.tests;

import com.test.orengehrm.TestBase;
import com.test.orengehrm.pages.AdminPage;
import com.test.orengehrm.pages.LoginPage;
import com.test.orengehrm.pages.MainPage;
import com.test.orengehrm.pages.PimPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PimPage pimPage;

    @BeforeMethod
    public void initiliazingPages(){
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        pimPage = new PimPage(driver);
    }

    @Test
    public void ValidateTheCreationOfEmployee() throws InterruptedException {
        loginPage.login("Admin","admin123");
        mainPage.clickPimButton();
        pimPage.addEmployeeForPIM("Ugur","ucar","1995","C:/Users/uguru/Desktop/Homework/html/turkey.png");
        Assert.assertEquals(pimPage.validateFirstName(),"Ugur");
        Assert.assertEquals(pimPage.validateLastName(),"ucar");
        Assert.assertTrue(pimPage.validateEmployeeId("1995"));
    }

    @Test
    public void ValidatePersonalDetailElement() throws InterruptedException {
        loginPage.login("Admin","admin123");
        mainPage.clickPimButton();
        pimPage.addEmployeeForPIM("Ugur","ucar","1995","C:/Users/uguru/Desktop/Homework/html/turkey.png");
        pimPage.editPersonalDetails("Turkish","1991-08-13","Single");
        Assert.assertEquals(pimPage.validateTheNationality(),"Turkish");
    }

}