package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();
        WebElement news= driver.findElement(By.xpath("//a[@id='root_2']"));
        news.click();
        Thread.sleep(1000);
        List<WebElement> headers = driver.findElements(By.xpath("//h3"));
        for (WebElement s:headers){
            if(s.getText().contains("covid")||s.getText().contains("COVID")){
                System.out.println(s.getText());
            }
//            System.out.println(s.getText());
        }

    }
}
