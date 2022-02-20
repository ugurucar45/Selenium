package WindowHandle;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {
    @Test
    public void practice1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle());
        WebElement clickhere = driver.findElement(By.xpath("//a[.='Click Here']"));
        BrowserUtil.clickWithJs(driver, clickhere);
        System.out.println(driver.getWindowHandles());

        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();


        //it works just for only 2 tabs
        for (String id : allPagesId) {
//            System.out.println(id);
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
            }
        }
        WebElement text = driver.findElement(By.xpath("//h3[.='New Window']"));
        Assert.assertEquals(text.getText(), "New Window");
    }

    @Test
    public void windowHandlePractice2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        String mainPageId = driver.getWindowHandle();
        WebElement clickhere = driver.findElement(By.xpath("//*[@id='newTabBtn']"));
        BrowserUtil.clickWithJs(driver, clickhere);

        BrowserUtil.switchBetweenTwoTabs(driver,mainPageId);
//        Set<String> allPagesId = driver.getWindowHandles();
//
//        for (String id : allPagesId) {
//            if (!id.equals(mainPageId)) {
//                driver.switchTo().window(id);
//            }
//        }
//        WebElement text = driver.findElement(By.xpath("//*[@id='Blog1']"));
        WebElement text = driver.findElement(By.xpath("//h1[contains(text(),'Alert')]"));
        Assert.assertEquals(text.getText(), "AlertsDemo");


        WebElement button = driver.findElement(By.xpath("//*[@id='alertBox']"));
        button.click();

    }

}
