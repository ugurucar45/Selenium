package SelectClass;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectClassExample {
    private BrowserUtil BrowserUtils;

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
        dy.selectByIndex(7);

        WebElement arrivingIn = driver.findElement(By.name("toPort"));
        Select arriving = new Select(arrivingIn);
        arriving.selectByVisibleText("Sydney");

        WebElement month1 = driver.findElement(By.name("toMonth"));
        Select mnth1 = new Select(month1);
        mnth1.selectByIndex(2);

        WebElement day1 = driver.findElement(By.name("toDay"));
        Select dy1 = new Select(day1);
        dy1.selectByIndex(14);

        WebElement service = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]"));
        service.click();

        WebElement airline = driver.findElement(By.name("airline"));
        Select air = new Select(airline);
        air.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.name("findFlights"));
        continueButton.click();
    }
    @Test
    public void secondWay(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        WebElement trip = driver.findElement(By.xpath("//input[@value='oneway']"));
        trip.click();
        WebElement passenger = driver.findElement(By.name("passCount"));
        BrowserUtils.selectBy(passenger,"2","value");
        WebElement departingFrom = driver.findElement(By.name("fromPort"));
        BrowserUtils.selectBy(departingFrom,"Paris","text");
        WebElement frommonth = driver.findElement(By.name("fromMonth"));
        BrowserUtils.selectBy(frommonth,"7","index");
        WebElement fromday = driver.findElement(By.name("fromDay"));
        BrowserUtils.selectBy(fromday,"13","value");
        WebElement arrivingIn = driver.findElement(By.name("toPort"));
        BrowserUtils.selectBy(arrivingIn,"Sydney","text");
        WebElement tomonth = driver.findElement(By.name("toMonth"));
        BrowserUtils.selectBy(tomonth,"9","index");
        WebElement toDay = driver.findElement(By.name("toDay"));
        BrowserUtils.selectBy(toDay,"3","value");
        WebElement Services = driver.findElement(By.xpath("//input[@value='First']"));
        Services.click();
        WebElement airlines = driver.findElement(By.name("airline"));
        Select airline = new Select(airlines);
        List<WebElement> allairlines = airline.getOptions();
        List<String> actualAirlines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        List<String> expectedairlines = new ArrayList<>();
        for (WebElement line : allairlines) {
            expectedairlines.add(line.getText().trim());
        }
        Assert.assertEquals(actualAirlines, expectedairlines);
        WebElement continueButton = driver.findElement(By.name("findFlights"));
        continueButton.click();
        WebElement message = driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        String actual = message.getText().trim();
        String expected = "After flight finder - No Seats Avaialble";
        Assert.assertEquals(actual, expected);

    }
}
