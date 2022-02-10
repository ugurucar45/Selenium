package TestNG;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class TestNGPracticeWithReal {
    @Test
    public void validateWebsite(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        String actualWebsite= driver.getCurrentUrl();
        String expectedWebsite="https://demo.opencart.com/admin/";
        Assert.assertEquals(actualWebsite,expectedWebsite);
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
//        driver.manage().
    }

    @Test
    public void validateCatalogisDisplayed(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
        boolean actualCatalog= catalogBar.isDisplayed();
        boolean expected= true;
        Assert.assertEquals(actualCatalog,expected,"Catalog is not there");
        catalogBar.click();

//        WebElement products= driver.findElement(By.xpath("//a[.='Products']"));
//        products.click();
    }
    @Test
    public void validateProductisDisplayed(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
        catalogBar.click();

        WebElement products= driver.findElement(By.xpath("//a[.='Products']"));
        boolean actualProduct= products.isDisplayed();
        boolean expected= true;
        Assert.assertEquals(actualProduct,true);
        products.click();
    }
    @Test
    public void validationOfBoxes() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement products= driver.findElement(By.xpath("//a[.='Products']"));
        Thread.sleep(200);
        products.click();
        List<WebElement> boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i=1;i<boxes.size();i++){
            boxes.get(i).click();
            boolean Actualboxvalid=boxes.get(i).isDisplayed();
            boolean expected=true;
            Assert.assertEquals(Actualboxvalid,expected);
            boolean ActualBoxisSelect= boxes.get(i).isSelected();
            Assert.assertEquals(ActualBoxisSelect,expected);
        }
    }
}
