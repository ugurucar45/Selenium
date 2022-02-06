package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSeleniumBasics {
    public static void main(String[] args) {


        WebDriver driver= new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //TASK: I want you go to the 3 websites. get the title,currentURL
        //You decide and going back
        //Forward with them lastly refresh and quit.

        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.etsy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.close();


    }
}
