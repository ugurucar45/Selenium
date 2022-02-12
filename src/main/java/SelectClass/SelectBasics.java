package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectBasics {
    @Test
    public void practice1(){
//        System.setProperty();
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropdrown=driver.findElement(By.linkText("Dropdown"));
        dropdrown.click();
        WebElement optionBox=driver.findElement(By.id("dropdown"));
        optionBox.sendKeys("Option 1");
        Select option=new Select(optionBox);//provide web element location
//        option.selectByIndex(1);//option2
//        option.selectByValue("1");//option
        option.selectByVisibleText("Option 1");
        List<WebElement> options= option.getOptions();
        for (WebElement optn:options){
            System.out.println(optn.getText().trim());
        }

    }
}
