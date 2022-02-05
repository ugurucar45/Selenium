package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException {
        //INTERVIEW QUESTIONS
        //What is the difference between driver.get() and driver.navigate().to()

        //INTERVIEW QUESTIONS:
        //What is the difference between driver.close and driver.quit
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        //navigate()
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //getPageSource()---> it gives html codes of page
        System.out.println(driver.getPageSource());

//        Thread.sleep(3000);
        driver.navigate().to("https://www.techtorialacademy.com/");
//        Thread.sleep(3000);
        driver.navigate().back();   //amazon
//        Thread.sleep(3000);
        driver.navigate().forward();//techtorial
//        Thread.sleep(3000);
        driver.navigate().refresh();

//        driver.close();
//        driver.quit();

    }
}
