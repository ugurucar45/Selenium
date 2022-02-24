package FileUpload;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {
    @Test
    public void validateFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\uguru\\Desktop\\Homework\\html\\turkey.png");

        WebElement upload=driver.findElement(By.id("file-submit"));
        upload.click();

        WebElement text1=driver.findElement(By.xpath("//h3"));
        String expected1="File Uploaded!";
        Assert.assertEquals(BrowserUtil.getTextMethod(text1),expected1);
        WebElement picText=driver.findElement(By.id("uploaded-files"));
        String expected2="turkey.png";
        Assert.assertEquals(picText.getText().trim(),expected2);

    }
}
