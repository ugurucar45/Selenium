package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice {
    @Test
    public void IframeTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();

        driver.switchTo().frame("mce_0_ifr");

        WebElement content = driver.findElement(By.id("tinymce"));
        content.clear();
        content.sendKeys("I Love Selenium");
        String actualP=content.getText().trim();
        String expectedP="I Love Selenium";
        Assert.assertEquals(actualP,expectedP);

        //don't forget the switch
        driver.switchTo().parentFrame();
        String actualh3=driver.findElement(By.xpath("//h3")).getText().trim();
        String expectedh3="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualh3,expectedh3);
    }
}
