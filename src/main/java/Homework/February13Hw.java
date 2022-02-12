package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class February13Hw {
    @Test
    public void descendingSortTest() throws InterruptedException {
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
        WebElement sortButton=driver.findElement(By.xpath("//*[@id=\"form-option\"]/div/table/thead/tr/td[3]/a"));
        sortButton.click();
        List<WebElement> allOptions=driver.findElements(By.xpath("//*[@id=\"form-option\"]/div/table/thead/tr/td[3]/a"));
        List<String> actualDescendingOptionsOrder=new LinkedList<String>();
        List<String> expectedOptionsOrder=new ArrayList<String>();
        for (int i=0;i<actualDescendingOptionsOrder.size();i++){
            actualDescendingOptionsOrder.add(allOptions.get(i).getText().trim());
            expectedOptionsOrder.add(allOptions.get(i).getText().trim());
            Collections.sort(expectedOptionsOrder);
            Collections.reverse(expectedOptionsOrder);
        }
        Assert.assertEquals(actualDescendingOptionsOrder,expectedOptionsOrder);
        System.out.println(actualDescendingOptionsOrder);
        System.out.println(expectedOptionsOrder);
        for (WebElement ss : allOptions) {
            System.out.println(ss.getText());
        }   }

    @Test
    public void ascendingSortTest() throws InterruptedException {
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
        WebElement sortButton=driver.findElement(By.xpath("//*[@id=\"form-option\"]/div/table/thead/tr/td[3]/a"));
        sortButton.click();


        List<WebElement> allOptions=driver.findElements(By.xpath("//*[@id=\"form-option\"]/div/table/thead/tr/td[3]/a"));
        List<String> actualAscendingOptionsOrder=new LinkedList<String>();
        List<String> expectedOptionsOrder=new ArrayList<String>();
        for (int i=0;i<actualAscendingOptionsOrder.size();i++){
            actualAscendingOptionsOrder.add(allOptions.get(i).getText().trim());
            expectedOptionsOrder.add(allOptions.get(i).getText().trim());
        }
        Assert.assertEquals(actualAscendingOptionsOrder,expectedOptionsOrder);
        System.out.println(actualAscendingOptionsOrder);
        System.out.println(expectedOptionsOrder);
    }
}
