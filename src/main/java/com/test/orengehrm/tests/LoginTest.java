package com.test.orengehrm.tests;

import com.test.orengehrm.DataForLoginNegativeTest;
import com.test.orengehrm.TestBase;
import com.test.orengehrm.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage;

    @BeforeMethod
    public void initiliazePage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validateLoginPositive() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void validateLoginNegative(String username, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "ahmet");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
    }

    @Test(dataProvider = "LoginNegativeTestScenario", dataProviderClass = DataForLoginNegativeTest.class)
    public void validateLoginNegative2(String username, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getErrrorMessage(), expectedMessage);
    }


//    @Test
//    public void validateLoginNegative2a() {
////        WebDriverManager.chromedriver().setup();
////        WebDriver driver=new ChromeDriver();
////        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
////        driver.manage().window().maximize();
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("", "");
//        String actualErrorMessage = loginPage.getErrrorMessage();
//        String expectedErrorMessage = "Username cannot be empty";
//        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
//        String actualColorOfErrorMessage = loginPage.getColorOfTheErrorMessage();
//        String expectedColorOfErrorMessage = "rgba(221, 119, 0, 1)";
//        Assert.assertEquals(actualColorOfErrorMessage, expectedColorOfErrorMessage);
//
//    }


}
