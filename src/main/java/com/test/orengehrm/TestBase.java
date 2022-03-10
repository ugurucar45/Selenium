package com.test.orengehrm;

import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("urlorangehrm"));
    }

    @AfterMethod
    public void tearDown(ITestResult result){
//        if(!result.isSuccess()){
//            BrowserUtil.getScreenshot(driver,"OrangeHrmScreenShot");
//        }
        DriverHelper.tearDown();
    }
}
