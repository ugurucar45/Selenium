package SeleniumLocators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice1 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement title=driver.findElement(By.xpath("//h3"));
        //what if we have to many h3 in this page
        //-->   //h3[contains(text(),'Horizontal')]
        System.out.println(title.getText());

        WebElement paragraph= driver.findElement(By.xpath("//h4[@class='subheader']"));
        System.out.println(paragraph.getText());

        //CONTAINS: it works with text
        //tagname[contains(text(),'Horizontal')]
        WebElement title1= driver.findElement(By.xpath("//h3[contains(text(),'Horizontal')]"));
        System.out.println(title1.getText());


        //Text: it works with text as well. This is for simplier than contains method. it looks for the exact text
        //h3[.='text']

        WebElement title2= driver.findElement(By.xpath("//h3[.='Horizontal Slider']"));
        System.out.println(title2.getText());
    }
}
