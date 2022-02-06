package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTestCaseExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        driver.manage().window().maximize();
        String actualTitle=driver.getTitle();
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        driver.close();
    }
}
