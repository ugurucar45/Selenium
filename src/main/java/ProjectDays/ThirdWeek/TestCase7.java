package ProjectDays.ThirdWeek;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7 {
   /*   Navigate to the "http://uitestpractice.com/"
"Click on the below button to open link in new Window
Validate Title has "C# Beginner to advanced" text
Validate the link has youtube text in new window
*/

    @Test
    public void Test7() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com");

        String mainPage=driver.getCurrentUrl();

        WebElement clickBelowButton= driver.findElement(By.xpath("//a[contains(text(),'Click here to watch videos on C#')]"));
        clickBelowButton.click();

        BrowserUtils.switchBetweenTwoTabs(driver,mainPage);

        // System.out.println(driver.getTitle());     this shows the name of the new title

        String actualMessage= driver.getTitle();
        String expectedMessage="C# Beginner to advanced - Lesson 29 - Delegates - YouTube";
        Assert.assertEquals(actualMessage,expectedMessage);

        String currentURL= driver.getCurrentUrl();
        String expectedURL="https://www.youtube.com/watch?v=dX-MDFWKBwE";
        Assert.assertEquals(currentURL,expectedURL);




    }
}
