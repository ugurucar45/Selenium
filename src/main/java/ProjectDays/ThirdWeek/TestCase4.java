package ProjectDays.ThirdWeek;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4 {
      /*  Navigate to the "http://uitestpractice.com/"
Move small box into the Drop Here box
Validate text "Dropped" displayed
 */


    @Test
    public void Test4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com");

        WebElement draggable= driver.findElement(By.id("draggable"));
        WebElement droppable= driver.findElement(By.id("droppable"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,droppable).perform();

        String actualMessage= BrowserUtils.getTextMethod(driver.findElement(By.xpath("//p[.='Dropped!']")));
        String expectedMessage="Dropped!";
        Assert.assertEquals(actualMessage,expectedMessage);


    }
}
