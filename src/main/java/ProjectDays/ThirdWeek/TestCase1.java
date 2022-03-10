package ProjectDays.ThirdWeek;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
    /*   Navigate to the "http://uitestpractice.com/Students/Index"
Click Create new button
Enter any firstname, lastname and enrollment date
Click create button
Search firstname in search bar
Validate the new information is created
*/
    @Test
    public void Test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/Students/Index");

        WebElement createNewButton = driver.findElement(By.xpath("//a[.='Create New']"));
        createNewButton.click();
        Thread.sleep(2000);
        driver.navigate().refresh();

        Thread.sleep(3000);
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("sss");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("uuu");
        Thread.sleep(1000);

        WebElement data = driver.findElement(By.xpath("//input[@data-val-date='The field EnrollmentDate must be a date.']"));
        data.sendKeys("11/8/2016");

        WebElement create = driver.findElement(By.xpath("//input[@value='Create']"));
        create.click();

        WebElement searchName = driver.findElement(By.id("Search_Data"));
        searchName.sendKeys("ssss", Keys.ENTER);

        WebElement nameText = driver.findElement(By.xpath("//td[1]"));
        WebElement lastText = driver.findElement(By.xpath("//td[2]"));
        WebElement dateText = driver.findElement(By.xpath("//td[3]"));
        System.out.println(BrowserUtils.getTextMethod(dateText));
        String actualText = BrowserUtils.getTextMethod(nameText) + " " + BrowserUtils.getTextMethod(lastText) + " " + BrowserUtils.getTextMethod(dateText);
        String expectedText = "George Stoleru 11/8/2016 12:00:00 AM";
        Assert.assertEquals(actualText, expectedText);

    }
}
