package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectClassExample {
    @Test
    public void validationTripButton() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        Assert.assertTrue(oneWayButton.isDisplayed());
        Assert.assertTrue(oneWayButton.isSelected());

        WebElement roudTripButton = driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertFalse(roudTripButton.isSelected());
        Assert.assertTrue(roudTripButton.isDisplayed());
    }

    @Test
    public void selectMethods() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        WebElement passenger = driver.findElement(By.name("passCount"));
        Select psnger = new Select(passenger);
        psnger.selectByIndex(1);

        WebElement departfrom = driver.findElement(By.name("fromPort"));
        Select selectDepart = new Select(departfrom);
        selectDepart.selectByVisibleText("Frankfurt");

        WebElement month = driver.findElement(By.name("fromMonth"));
        Select mnth = new Select(month);
        mnth.selectByVisibleText("January");

        WebElement day = driver.findElement(By.name("fromDay"));
        Select dy = new Select(day);
        mnth.selectByVisibleText("15");

        WebElement arrivingIn = driver.findElement(By.name("toPort"));
        Select arr = new Select(arrivingIn);
        mnth.selectByVisibleText("London ");

        WebElement month1 = driver.findElement(By.name("toMonth"));
        Select mnth1 = new Select(month1);
        mnth.selectByIndex(2);

        WebElement day1 = driver.findElement(By.name("toDay"));
        Select dy1 = new Select(day1);
        mnth.selectByIndex(14);

        WebElement service = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]"));
        service.click();

        WebElement airline = driver.findElement(By.name("airline"));
        Select air = new Select(airline);
        mnth.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.name("findFlights"));
        continueButton.click();


    }
}
