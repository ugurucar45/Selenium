package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAndTags {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/uguru/Desktop/ss.html");
        driver.manage().window().maximize();

        WebElement javalink= driver.findElement(By.linkText("Java"));
        javalink.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.navigate().back();
        WebElement seleniumLink= driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        driver.navigate().back();
        WebElement cucumberLibnk=driver.findElement(By.linkText("Cucumber"));
        cucumberLibnk.click();
        driver.navigate().back();

        javalink=driver.findElement(By.linkText("Java"));
        javalink.click();
        driver.navigate().back();


        WebElement restApi= driver.findElement(By.partialLinkText("Rest Api"));
        restApi.click();
        driver.navigate().back();

        WebElement version = driver.findElement(By.tagName("u"));
        System.out.println(version.getText());
    }
}
