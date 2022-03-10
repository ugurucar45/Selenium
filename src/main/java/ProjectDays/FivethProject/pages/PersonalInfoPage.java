package ProjectDays.FivethProject.pages;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PersonalInfoPage {
    public PersonalInfoPage(){
        PageFactory.initElements(DriverHelper.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Lala Lamees']")
    WebElement changedtoBtn;

    @FindBy(xpath = "//td[.='Pre-Sales Executive']")
    WebElement jobTitle;

@FindBy(xpath = "//td[.='Full Time Contract']")
WebElement employeeStatus;

@FindBy(xpath = "//td[.='IceHrm Employee']")
WebElement supervisorName;

    @FindBy(xpath = "//td[.='Head Office']")
    WebElement department;



    public  void clicktochangeto() throws InterruptedException {
        Thread.sleep(2000);
        changedtoBtn.click();

    }

    public void validatecurrenturl(WebDriver driver){

        Boolean actualcurrenturl=driver.getCurrentUrl().contains("Personal_Information");
        Assert.assertTrue(actualcurrenturl);
    }

    public  void validatetitle(WebDriver driver){
        Boolean actualtitle= driver.getTitle().contains("ICE Hrm");
        Assert.assertTrue(actualtitle);

    }

    public  void validateJobTitle(WebDriver driver){
        String actualJobMessage=jobTitle.getText().trim();
        Assert.assertEquals(actualJobMessage, "Pre-Sales Executive");
    }

    public  void validateEmployeeStatus(WebDriver driver){
        String actualJobMessage=employeeStatus.getText().trim();
        Assert.assertEquals(actualJobMessage, "Full Time Contract");
    }

    public  void validateSupervisorName(WebDriver driver){
        String actualJobMessage=supervisorName.getText().trim();
        Assert.assertEquals(actualJobMessage, "IceHrm Employee");
    }
    public  void validatedepartment(WebDriver driver){
        String actualJobMessage=department.getText().trim();
        Assert.assertEquals(actualJobMessage, "Head Office");
    }


}

