package ProjectDays.ThirdWeek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase5 {

    /*   Navigate to the "http://uitestpractice.com/"
Click two times Double click button
Validate Alert has "Double Clicked !!" text
Click Okay button to close the alert
*/
    @Test
    public void Test5() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com");

        WebElement doubleClickButton= driver.findElement(By.xpath("//button[.='Double Click ME !']"));
        Actions actions=new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();

        Alert alert=driver.switchTo().alert();

        String actualMessage= alert.getText();
        String expectedMessage="Double Clicked !!";
        Assert.assertEquals(actualMessage, expectedMessage);
        alert.accept();

    }
}
