package ProjectDays.ThirdWeek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ss {
    @Test
    public void searchingInfo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Index");
        driver.manage().window().maximize();
        Thread.sleep(400);
        driver.navigate().refresh();

        WebElement createButton = driver.findElement(By.xpath("//a[.='Create New']"));
        createButton.click();
        Thread.sleep(400);
        driver.navigate().refresh();
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Kanat");
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Osmonov");
        WebElement enrollmentDate = driver.findElement(By.id("EnrollmentDate"));
        enrollmentDate.sendKeys("02/22/22");

        WebElement createButn = driver.findElement(By.xpath("//input[@class='btn btn-default']"));
        createButn.click();
        Thread.sleep(400);
        driver.navigate().refresh();
        WebElement searchBar= driver.findElement(By.id("Search_Data"));
        searchBar.sendKeys("Osmonov");


    }
}
