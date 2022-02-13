package ActionClass;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {

    //ContextClick() --> right click    *******
    @Test
    public void ContextClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement contextMenu = driver.findElement(By.partialLinkText("Context"));
        contextMenu.click();
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //ACTION CLASS YOU MUST USE PERFORM AT THE END.
        actions.contextClick(box).perform();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement hover = driver.findElement(By.linkText("Hovers"));
        hover.click();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List<WebElement> pictures = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        for (int i=0;i<pictures.size();i++) {
            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform();       //hover over here
            System.out.println(BrowserUtil.getTextMethod(names.get(i)));//get text here
            Assert.assertEquals(BrowserUtil.getTextMethod(names.get(i)),expectedNames.get(i));
        }


    }
}
