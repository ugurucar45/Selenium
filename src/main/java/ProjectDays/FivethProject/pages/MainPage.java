package ProjectDays.FivethProject.pages;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    public MainPage(){
        PageFactory.initElements(DriverHelper.getDriver(),this);
    }

    //TestCase1 Elements
    @FindBy(xpath = "//span[.='Switch']")
    WebElement switchToOpen;

    @FindBy(xpath = "//h4[.='Switch Employee']")
    WebElement switchEmployee;

    @FindBy(xpath = "//p[.='Select The Employee to Switch Into']")
    WebElement selectTheEmployeeInfo;

    @FindBy(xpath = "//b[@role='presentation']")
    WebElement arrowDownOptions;

    @FindBy(xpath = "//div[.='Lala Lamees']")
    WebElement lalaLamees;

    @FindBy(xpath = "//button[.='Switch']")
    WebElement switchConfirm;

    @FindBy(xpath = "//a[.='Lala Lamees']")
    WebElement lalaL;

    @FindBy(xpath = "//a[.=' Changed To ']")
    WebElement changedTo;

    @FindBy(xpath = "//i[@class='fa fa-circle text-warning']")
    WebElement brownDot;


    @FindBy(xpath = "//a[.='Lala Lamees']")
    WebElement changedtoBtn;

    @FindBy(xpath = "//span[contains(text(),'Company')]")
    WebElement company;

    @FindBy(id="module_Company")
    WebElement staffDirectory;




    public  void clicktochangeto() throws InterruptedException {
        Thread.sleep(2000);
        changedtoBtn.click();

    }

    public  void clicktocompany() throws InterruptedException {
        Thread.sleep(2000);
        company.click();

    }

    public  void clicktoStaffDirectory() throws InterruptedException {
        Thread.sleep(2000);
        company.click();
        Thread.sleep(1000);
        staffDirectory.click();

    }

    //TestCase1 Methods
    public void clickSwitch() throws InterruptedException {

        switchToOpen.click();
        Thread.sleep(500);
    }

    public boolean validateSwitchPopUp1(){
        return switchEmployee.isDisplayed();
    }

    public boolean validateSwitchPopUp2(){
        return selectTheEmployeeInfo.isDisplayed();
    }

    public void confirmLalaLamees() throws InterruptedException {
        arrowDownOptions.click();
        lalaLamees.click();
        Thread.sleep(500);
        switchConfirm.click();
    }

    public boolean lalaIsDisplayed(){
        return lalaL.isDisplayed();
    }

    public String changeToIsCorrect(){
        return BrowserUtils.getTextMethod(changedTo);
    }

    public String getColorOfTheDot(){
        return brownDot.getCssValue("color");
    }


}



