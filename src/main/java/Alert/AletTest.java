package Alert;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AletTest {

    @Test
    public void JSAlertOwn(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();

        WebElement button=driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/button"));
        button.click();

        Alert alert= driver.switchTo().alert();
        String actualText= alert.getText();
        String expectedText= "Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
    }
    @Test////h5[contains(text(),'Normal alert')] //..//button
    public void JSAlert(){
    /*(ALERT CLASS)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom left one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();

        WebElement button=driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')] //..//button"));
        button.click();

        Alert alert= driver.switchTo().alert();
        String actualText= alert.getText();
        String expectedText= "Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
    }

    @Test
    public void TrialForAlertToHandleHTMLpopup(){
    /* TASK 2 (ALERT CLASS)
     1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();

        WebElement button=driver.findElement(By.xpath("//div[3][@class='code-container'] //button"));
        //button[contains(@onclick,'swal')]
        button.click();

        Alert alert= driver.switchTo().alert();
        alert.accept();

    }
    @Test
    public void HTMLALERT () throws InterruptedException {
    /*
    TASK 3 (HTML ALERT)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();

        WebElement button=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        button.click();
        Thread.sleep(1000);
        WebElement text=driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        Thread.sleep(1000);
        String actualText= text.getText().trim();
        String expectedText="Something went wrong!";
        Assert.assertEquals(actualText,expectedText);

        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();
    }

}
