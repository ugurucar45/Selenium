package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class TestNGPracticeWithReal2 {
    @Test
    public void validationOfAscendingOrderOfOptions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);

        WebElement optionsNameButton=driver.findElement(By.xpath("//a[.='Options']"));
        optionsNameButton.click();
        Thread.sleep(1000);
        List <WebElement> allOptions=driver.findElements(By.xpath("//tbody/tr/td[2]"));
        Set<String> actualOptionsOrde=new LinkedHashSet<String>();
        Set<String> expectedOptionsOrder=new TreeSet<String>();
        for (WebElement option:allOptions){
            actualOptionsOrde.add(option.getText().trim());
            expectedOptionsOrder.add(option.getText().trim());
        }
        Assert.assertEquals(actualOptionsOrde,expectedOptionsOrder);

    }

    @Test
    public  void validationOfDescendingOrderOptions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);

        WebElement optionsNameButton=driver.findElement(By.xpath("//a[.='Options']"));
        optionsNameButton.click();
        Thread.sleep(1000);
        List <WebElement> allOptions=driver.findElements(By.xpath("//tbody/tr/td[2]"));
        List<String> actualDescendingOptionsOrder=new LinkedList<String>();
        List<String> expectedOptionsOrder=new ArrayList<String>();
        for (int i=0;i<actualDescendingOptionsOrder.size();i++){
            actualDescendingOptionsOrder.add(allOptions.get(i).getText().trim());
            expectedOptionsOrder.add(allOptions.get(i).getText().trim());
            Collections.sort(expectedOptionsOrder);
            Collections.reverse(expectedOptionsOrder);
        }
        Assert.assertEquals(actualDescendingOptionsOrder,expectedOptionsOrder);
    }
}
