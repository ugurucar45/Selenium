package SelectClass;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class DreamCars {
    @Test
    public void BMWahmetsWay() {
        //first go to the website
        //Choose the options you want for your car
        //Click search button
        //Validate the header
        //and validate the all subheaders contains the name of the cars you are looking for
        //.clear --> sendKeys
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement newCar = driver.findElement(By.xpath("//*[@id='make-model-search-stocktype']"));
        WebElement makes = driver.findElement(By.xpath("//*[@id='makes']"));
        WebElement model = driver.findElement(By.xpath("//*[@id='models']"));
        WebElement button = driver.findElement(By.xpath("//*[@id='by-make-tab']/div/div[7]/button"));
        BrowserUtil.selectBy(newCar, "new", "value");
        BrowserUtil.selectBy(makes, "Volvo", "text");
        BrowserUtil.selectBy(model, "volvo-s90", "value");
        button.click();

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'New Volvo S90 for sale')]"));
        String actualHeader = BrowserUtil.getTextMethod(header);
        String expectedHeader = "New Volvo S90 for sale";
        Assert.assertEquals(actualHeader, expectedHeader);

        List<WebElement> validationForSubheaders = driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement car : validationForSubheaders) {
            boolean contains = car.getText().trim().toLowerCase().contains("volvo");
            Assert.assertTrue(contains);
        }
    }

    @Test
    public void BMWmyWay() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement newCar = driver.findElement(By.xpath("//*[@id='make-model-search-stocktype']"));
        BrowserUtil.selectBy(newCar, "New cars", "text");

        WebElement porsche = driver.findElement(By.xpath("//*[@id=\"makes\"]"));
        BrowserUtil.selectBy(porsche, "Porsche", "text");

        WebElement random = driver.findElement(By.xpath("//*[@id=\"models\"]"));
        BrowserUtil.selectBy(random, "porsche-911", "value");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"by-make-tab\"]/div/div[7]/button"));
        button.click();

        WebElement header = driver.findElement(By.xpath("//*[@id=\"search-live-content\"]/header/div/h1"));
        Assert.assertEquals(header.getText().trim(), "New Porsche 911 for sale");

        List<WebElement> subheaders = driver.findElements(By.xpath("//h2[@class='title']"));
        boolean check = true;

        for (WebElement ss : subheaders) {
            if (!ss.getText().contains("911")) {
                check = false;
                break;
            }
        }
        Assert.assertTrue(check);
    }
}
