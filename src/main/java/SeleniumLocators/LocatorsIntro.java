package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/uguru/Desktop/Homework/ss.html");

        //Locatar ID
        //getText() --> it gives you the text of the element.
        WebElement header=driver.findElement(By.id("techtorial1"));
        String actualText=header.getText();
        String expectedText="Techtorial Academy";
        if (actualText.equals(expectedText)){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }


        WebElement header1=driver.findElement(By.id("details2"));
        String text1=header1.getText();
        String expected1="To create your account, we'll need some basic information about you. This information " +
                "will be used to send reservation confirmation emails, mail tickets when needed and contact you if " +
                "your travel arrangements change. Please fill in the form completely.";
        if (text1.equals(expected1)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }


        //LOCATOR: ClassName
        WebElement tools=driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());


        //LOCATOR: Name
        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ugur");
        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Ucar");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("1112223");
        WebElement email= driver.findElement(By.name("userName"));
        email.sendKeys("sss@mail.com");

        WebElement javaBox=driver.findElement(By.id("cond1"));
        javaBox.click();
        javaBox.isDisplayed();//return true
        javaBox.isSelected(); //return true

        WebElement testng = driver.findElement(By.id("cond3"));
        testng.click();
        System.out.println(javaBox.isDisplayed());
        System.out.println(javaBox.isSelected());

        WebElement cucumber= driver.findElement(By.id("cond4"));
        cucumber.click();
        System.out.println(javaBox.isDisplayed());
        System.out.println(javaBox.isSelected());


    }
}
