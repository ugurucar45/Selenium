package Alert;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AlertIntro {
    public String name="Techtorial";

    @Test
    public void JSBasicAlertAcceptMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement clickJsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickJsAlert.click();
//        WebElement header=driver.findElement(By.tagName("h3")); //UnhandledAlertException
//        System.out.println(header.getText().trim());

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage= BrowserUtil.getTextMethod(message);
        String expectedMessage="You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void JSAlertDismissMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement clickJsAlert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickJsAlert.click();

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "I am a JS Confirm";
        Assert.assertEquals(actualText,expectedText);
        alert.dismiss();
        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage= BrowserUtil.getTextMethod(message);
        String expectedMessage="You clicked: Cancel";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void JSAlertPromptMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement clickJsAlert = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickJsAlert.click();

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "I am a JS prompt";
//        alert.sendKeys("Techtorial");
        alert.sendKeys(name);
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage= BrowserUtil.getTextMethod(message);
        String expectedMessage="You entered: Techtorial";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
