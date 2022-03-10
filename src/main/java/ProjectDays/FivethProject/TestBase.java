package ProjectDays.FivethProject;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utils.ConfigReader;
import Utils.DriverHelper;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver=DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("urlIcehrm"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
//        if(!result.isSuccess()){
//            BrowserUtils.getScreenshot(driver,"OrangeHrmScreenshot");
//        }
      //  DriverHelper.tearDown();
    }
}

