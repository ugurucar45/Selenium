package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
    //Step1: We need to define the chrome driver into the project as a property.
    //        System.setProperty("webdriver.chrome.driver","chromedriver"); // mac users
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");//windows users
    //Step2: We need to instantiate(declare) our driver.
        WebDriver driver= new ChromeDriver();
        //NOTE: driver is a reference name.WebDriver ---> Interface
        //new ChromeDriver() ---> new Object.


        //INTERVIEW QUESTION:
        //Where do you use polymorphism in your testing framework?
        //I use it to instantiate my driver like
        //WebDriver driver= new ChromeDriver();
        //ChromeDriver driver1=new ChromeDriver();


        //SECOND INTERVIEW QUESTION:
        //Can you instantiate ypur driver Like
        //WebDriver driver= new ChromeDriver();
        //ChromeDriver driver1=new ChromeDriver();


        //FIRST METHOD:
        //Get() --> methods navigates to the given url.
        driver.get("https://www.techtorialacademy.com/");   // if i run the main it goes to the web sites

        //getTitle() --> methods get the title of the page.

        String title= driver.getTitle();
        System.out.println(title);

        if(title.equals("Home Page - Techtorial")){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }

        //getCurrentUrl()
        String url=driver.getCurrentUrl();
        System.out.println(url);
        String expected="https://www.techtorialacademy.com/";
        if(url.equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
