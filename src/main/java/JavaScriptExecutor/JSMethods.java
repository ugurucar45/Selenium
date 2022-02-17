package JavaScriptExecutor;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSMethods {
    //whenever normal methods are not working then last decision should javaScript.
    @Test
    public void titleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

//        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
//        String title=javascriptExecutor.executeScript("return document.title").toString();
//        System.out.println(title+" from javaScript");
        String actualTitle=BrowserUtil.getTitleWithJS(driver);
        String expectedTitle=("Home Page - Techtorial");
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test       // THIS METHOD IS IMPORTANT
    public void clickWithJS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        driver.manage().window().maximize();
//        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        WebElement browserCourse= driver.findElement(By.xpath("//a[.='Browse Course']"));
//        javascriptExecutor.executeScript("arguments[0].click()",browserCourse);
        BrowserUtil.clickWithJs(driver,browserCourse);
    }

    @Test
    public void clickStudentLogin(){       WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement studentLogin= driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        //div[@class='sidenav']//a[.='Student login']
        //div[@class='sidenav']//div
        // a[.='Student login']

        BrowserUtil.clickWithJs(driver,studentLogin);}
}
