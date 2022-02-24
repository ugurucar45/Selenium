package PracticeMyself;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sss {
    /*  navigate to  https://www.cars.com/
        select "certified cars" from the drop-down menu
        select "toyota" from all makes
        select "corolla" from drop-down
        select max price is $30000
        select 40 miles from drop-down box
        insert 60018 as zip code
        click search button
        validate title has certified  used
        validate "certified used toyota corolla for sale" is displayed
*/
    @Test
    public void cars() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement new_used = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtil.selectBy(new_used, "cpo", "value");
        Thread.sleep(500);

        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtil.selectBy(make, "toyota", "value");
        Thread.sleep(400);

        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtil.selectBy(model, "Corolla", "text");
        Thread.sleep(400);

        WebElement MaxPrice = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtil.selectBy(MaxPrice, "30000", "value");
        Thread.sleep(4000);

        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtil.selectBy(distance, "40", "value");
        Thread.sleep(400);

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60018");

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-cpo-make']"));
        searchButton.click();
        Thread.sleep(400);

        WebElement validateCertifiedUsed = driver.findElement(By.xpath("//h1[contains(text(),'Toyota Certified Used Corolla')]"));
        String actualText = validateCertifiedUsed.getText();
        String expectedText = "Toyota Certified Used Corolla";
        Assert.assertEquals(actualText, expectedText);
        Thread.sleep(4000);

        WebElement ValidateCertifiedUsedForSaleDisplayed = driver.findElement(By.xpath("//h1[.='Certified used Toyota Corolla for sale']"));
        boolean itIsDisplayed = ValidateCertifiedUsedForSaleDisplayed.isDisplayed();
        Assert.assertTrue(itIsDisplayed);

    }
}
