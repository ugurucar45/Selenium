package FileUpload;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTask {

    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        driver.manage().window().maximize();
        WebElement chooseFile=driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\uguru\\Desktop\\Homework\\html\\turkey.png");

        WebElement box=driver.findElement(By.id("terms"));
        box.click();

        WebElement send=driver.findElement(By.id("submitbutton"));
        send.click();
        WebElement text=driver.findElement(By.xpath("//*[@id='res']/center"));
        //h3
        //id=   res
        //html //div //h3 //center
        //html //div //h3
        //div/h3
        //div/h3/center
        Thread.sleep(2000);
        String expected1="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(text.getText().trim(),expected1);
    }
}
