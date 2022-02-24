package Iframe;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTask {
    @Test
    public void PracticeForIframeWindowHandleAction() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://skpatro.github.io/demo/iframes/");
        String main = driver.getCurrentUrl();
        driver.manage().window().maximize();
        WebElement pavilion = driver.findElement(By.xpath("//*[contains(text(),'Pavilion')]"));
        pavilion.click();
        Thread.sleep(400);
        BrowserUtil.switchBetweenTwoTabs(driver, main);
        Actions actions = new Actions(driver);
        WebElement selenium = driver.findElement(By.xpath("//*[@id='primary-menu']//span[.='Selenium']//.."));
        actions.moveToElement(selenium).perform();
        Thread.sleep(400);
        WebElement selnium = driver.findElement(By.xpath("//*[@id='primary-menu']//span[.='Selenium-Java']//.."));
        actions.click(selnium).perform();
        Thread.sleep(400);
        WebElement actualTextElement = driver.findElement(By.tagName("h1"));
        String expected = "Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualTextElement.getText().trim(), expected);
        BrowserUtil.switchByTitle(driver, "iframes");
        Thread.sleep(400);
        driver.switchTo().frame("Framename1");
        WebElement category1 = driver.findElement(By.xpath("//*[contains(text(),'Category1')]"));
        category1.click();
        Thread.sleep(400);
        BrowserUtil.switchByTitle(driver, "Home - qavalidation");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='bottom-bar']")).getText().trim().contains("All rights reserved | qavalidation"));
        BrowserUtil.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame2");
        Thread.sleep(400);
        BrowserUtil.switchByTitle(driver, "SoftwareTesting Archives - qavalidation");

        Assert.assertEquals(driver.getCurrentUrl(), "https://qavalidation.com/category/seleniumtesting/");


    }
}
