package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();


        WebElement abstesting= driver.findElement(By.linkText("A/B Testing"));
        List<WebElement> allLinks= driver.findElements(By.xpath("//li/a"));

        int count=0;
        for (WebElement link:allLinks){
            if (link.getText().length()<13){
                count++;
            }
            System.out.println(link.getText());
        }
        System.out.println(count);
    }
}
