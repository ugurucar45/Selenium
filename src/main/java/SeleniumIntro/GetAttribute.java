package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement googleSearch = driver.findElement(By.name("btnK"));
//        System.out.println(googleSearch.getText());
        System.out.println(googleSearch.getAttribute("value"));
        System.out.println(googleSearch.getAttribute("aria-label"));
        if (googleSearch.getAttribute("value").equals("Google Search")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}
