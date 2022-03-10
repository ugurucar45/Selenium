package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practiceWindowHandling {
    /*
1)navigate to the "https://www.hyrtutorials.com/p/window-handles-practice.html"
2)Click open multiple tabs under button 4
3)switch back to Basic Controls and validate the header(Basic Controls)
4)Fill all the boxes and click register
5)validate the message"Registration is Successful";
6)Go back to Alert tabs and click the one of the click me box
7)Close all the tabs
8)Enjoy the chocolate if you are top 5

 */
    @Test
    public void practiceMultipleWindowHandling() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        WebElement button4 = driver.findElement(By.xpath("//*[@id='newTabsBtn']"));
        button4.click();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(1000);
        BrowserUtils.switchByTitle(driver,"Basic Controls");
        Thread.sleep(1000);
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Ugur");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("ucar");
        WebElement language = driver.findElement(By.id("englishchbx"));
        language.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("selam@mail.com");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("1234");
        WebElement button = driver.findElement(By.xpath("//*[@id='registerbtn']"));
        button.click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='msg']")).getText().trim(), "Registration is Successful");

        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        Thread.sleep(400);

        WebElement alertBox = driver.findElement(By.xpath("//*[@id='alertBox']"));
        alertBox.click();

        driver.quit();

    }
}
