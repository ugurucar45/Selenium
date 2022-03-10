package PracticeMyself;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class trysa {


    @Test
    public void Test3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/Students/Index");

        WebElement searchLastName= driver.findElement(By.id("Search_Data"));
        Thread.sleep(3000);
        searchLastName.sendKeys("White");

//        WebElement FindButton= driver.findElement(By.xpath("//input[@value='Find']"));
//        FindButton.click();
//
//        WebElement deleteButton= driver.findElement(By.xpath("//tr[2]/td[4]/button[3]"));
//        deleteButton.click();
//
//        WebElement confirmDelete= driver.findElement(By.xpath("//input[@class='btn btn-default']"));
//        confirmDelete.click();
//
//        Thread.sleep(2000);
//        WebElement searchLastName1= driver.findElement(By.id("Search_Data"));
//        searchLastName1.sendKeys("White");

        WebElement FindButton1= driver.findElement(By.xpath("//input[@value='Find']"));
        FindButton1.click();

        String actualMessage=driver.findElement(By.xpath("//html //div[@class='container body-content']//div[1]")).getText().trim();
        String expectedMessage="\n" +
                "There are zero students with this search text\n" +
                "    Page 0 of 0\n" +
                "    ";
        Assert.assertEquals(actualMessage,expectedMessage);






    }
}

