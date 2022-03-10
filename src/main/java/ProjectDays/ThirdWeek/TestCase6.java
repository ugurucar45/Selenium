package ProjectDays.ThirdWeek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6 {
     /*   navigate to  http://uitestpractice.com/
         enter your name inside the iframe
         click the link inside the iframe box
         validate ..is displayed
 */

    @Test
    public void Test6() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com");

        driver.switchTo().frame("iframe_a");

        WebElement enterName= driver.findElement(By.id("name"));
        enterName.sendKeys("aigul");

        driver.switchTo().parentFrame();

        WebElement link= driver.findElement(By.xpath("//a[@target='iframe_a']"));
        link.click();
        Thread.sleep(3000);

        driver.switchTo().frame("iframe_a");

        Actions actions=new Actions(driver);

        WebElement linkhtml= driver.findElement(By.xpath("//*[@id='sub-frame-error']"));

        actions.moveToElement(linkhtml).perform();

        WebElement htmlLink=driver.findElement(By.id("sub-frame-error-details"));
        Assert.assertTrue(htmlLink.isDisplayed());
    }
}
