package ProjectDays.FivethProject.pages;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.util.List;

public class StaffDirectoryPage {
        public StaffDirectoryPage(){
            PageFactory.initElements(DriverHelper.getDriver(), this);
        }

    @FindBy(id = "StaffDirectory_filterBtn")
    WebElement filter;

//    @FindBy(xpath = "//*[@id='select2-chosen-2']")
//    WebElement jobTitleselection;

    @FindBy(id="job_title")
    WebElement jobtitle;

    @FindBy(xpath = "//button[@class=\"filterBtn btn btn-primary pull-right\"]")
    WebElement clickfilter2;

    @FindBy(xpath = "//*[@id=\"loadMoreStaffDirectory\"]/a")
    WebElement loadmore;

    @FindBy(xpath = "//h5")
    List<WebElement> allproductmanager;

        public  void clickfilter(){
            filter.click();
        }
        public  void jobtitleselect(WebDriver driver) throws InterruptedException {
            Thread.sleep(2000);
            BrowserUtils.selectBy(jobtitle,"Product Manager", "text");
            clickfilter2.click();
          Thread.sleep(2000);
            loadmore.click();

        }
        public void assertallmanagers(){
            for(int i=1; i< allproductmanager.size(); i++){
                Assert.assertEquals(allproductmanager.get(i).getText().trim(),"Product Manager");
            }
        }


}
