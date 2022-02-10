package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
    /*
    Facebook Sign up:
Scenario:
Open a Chrome browser.
Navigate to "http://www.fb.com"
Verify that the page is redirected to "http://www.facebook.com", by getting the current URL. (use Assertion)
Verify that there is a "Create an account" section on the page.
Fill in the text boxes: First Name, Surname, Mobile Number or email address, "Re-enter mobile number", new password.
Update the date of birth in the drop-down.
Select gender.
Click on "Create an account".
Verify that the account is not created.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        String actualURL = driver.getCurrentUrl();
        String expevtedURL = "https://www.facebook.com/";
        System.out.println(driver.getCurrentUrl());
        if (actualURL.equals(expevtedURL)) {
            System.out.println("The website is correct");
        } else {
            System.out.println("The website is false");
        }
        WebElement createAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        boolean validationButton = createAccountButton.isDisplayed();
        boolean expectedValidationButton = true;

        if (validationButton == expectedValidationButton) {
            System.out.println("Button is displayed");
        } else {
            System.out.println("Button is not displayed");
        }
        createAccountButton.click();


        Thread.sleep(1000);

        WebElement firstName= driver.findElement(By.name("firstname"));
        firstName.sendKeys("ali");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("ssss");

        WebElement mail = driver.findElement(By.name("reg_email__"));
        mail.sendKeys("sss@mail.ru");
        Thread.sleep(1000);

        WebElement mail1 = driver.findElement(By.name("reg_email_confirmation__"));
        mail1.sendKeys("sss@mail.ru");

        WebElement pass = driver.findElement(By.name("reg_passwd__"));
        pass.sendKeys("12345678qwertyuiASDFG!@#$");

        WebElement month = driver.findElement(By.id("month"));
        month.sendKeys("Aug");
        WebElement day = driver.findElement(By.id("day"));
        day.sendKeys("11");
        WebElement year = driver.findElement(By.name("birthday_year"));
        year.sendKeys("1999");

        WebElement gender= driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
        gender.click();

        WebElement signupbutton = driver.findElement(By.name("websubmit"));
        signupbutton.click();

    }
}
