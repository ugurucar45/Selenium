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

public class TestCase2 {
       /*  Navigate to the "http://uitestpractice.com/Students/Index"
Search any Lastname in search bar
Click Edit button
Change first name
Click save button
Search with new lastname
Validate Firstname is changed
*/

    @Test
    public void Test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/Students/Index");

        WebElement createNewButton = driver.findElement(By.xpath("//a[.='Create New']"));
        createNewButton.click();
        Thread.sleep(2000);

        driver.navigate().refresh();

        createNewButton = driver.findElement(By.xpath("//a[.='Create New']"));
        createNewButton.click();

        WebElement firstName= driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("ssss");
        Thread.sleep(1000);

        WebElement lastName= driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("uuuu");
        Thread.sleep(1000);

        WebElement data= driver.findElement(By.xpath("//input[@data-val-date='The field EnrollmentDate must be a date.']"));
        data.sendKeys("02/22/2022");

        WebElement buttonFinish= driver.findElement(By.xpath("//input[@value='Create']"));
        buttonFinish.click();




        WebElement searchName = driver.findElement(By.id("Search_Data"));
        searchName.sendKeys("uuuu", Keys.ENTER);

        WebElement edit = driver.findElement(By.xpath("//tr[2]//button[@class='btn'][1]"));
        edit.click();
        firstName= driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.clear();
        Thread.sleep(500);
        firstName.sendKeys("ssss");

        WebElement save = driver.findElement(By.xpath("//input[@type='submit']"));
        save.click();

        searchName = driver.findElement(By.id("Search_Data"));
        searchName.sendKeys("uuuu", Keys.ENTER);

        WebElement nameText = driver.findElement(By.xpath("//td[1]"));
        String actualUpdatedFirstName = BrowserUtils.getTextMethod(nameText);
        String expectedUpdatedFirstName = "ssss";
        Assert.assertEquals(actualUpdatedFirstName,expectedUpdatedFirstName);

    }
}
