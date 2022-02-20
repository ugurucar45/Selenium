package WindowHandle;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    @Test
    public void multipleWindowTask1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle());
        WebElement clickhere = driver.findElement(By.xpath("//a[.='Click Here']"));
        BrowserUtil.clickWithJs(driver, clickhere);

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

//        Set<String>  allPagesId= driver.getWindowHandles();
//        for(String id:allPagesId){
//            if (driver.getTitle().contains("About Us - Techtorial")) {
//                driver.switchTo().window(id);
//                  break;
//            }
//        }
    BrowserUtil.switchByTitle(driver,"Home Page - Techtorial");

    }

}