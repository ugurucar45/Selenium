package Iframe;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrame {
    @Test
    public void nestedFrameValidation() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
//        driver.switchTo().frame("frame-top");
        //this is the examle of using index to switch frame
        driver.switchTo().frame(0);     //I am on the top right Now

        //this is the example of using web element to switch frame
        WebElement middle = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middle);     //I am on the middle frame
        WebElement textBox=driver.findElement(By.id("content"));
        String actualName= BrowserUtil.getTextMethod(textBox);
        String expectedName="MIDDLE";
        Assert.assertEquals(actualName,expectedName);

        driver.switchTo().parentFrame();//if i skip this section i see NoSuchFrameException
        driver.switchTo().frame("frame-left");
        WebElement leftbox=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        String actualr=BrowserUtil.getTextMethod(leftbox);
        String expectedr="LEFT";
        Assert.assertEquals(actualr,expectedr);

//        driver.switchTo().parentFrame();//top
//        driver.switchTo().parentFrame();//html
        driver.switchTo().defaultContent();//means it directly goes to the HTML
        driver.switchTo().frame("frame-bottom");
        WebElement bottom=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        String actualB=BrowserUtil.getTextMethod(bottom);
        String expectedB="BOTTOM";
        Assert.assertEquals(actualB,expectedB);
        driver.quit();
    }

}
